package eu.xevix.xvSpawn.listeners;

import eu.xevix.xvSpawn.managers.ConfigManager;
import eu.xevix.xvSpawn.managers.HashMapManager;
import eu.xevix.xvSpawn.utils.ColorUtil;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerDamageListener implements Listener {
    ConfigManager configManager = new ConfigManager();
    HashMapManager hashMapManager = new HashMapManager();
    boolean title = configManager.getConfig().getBoolean("actions.title");
    boolean actionbar = configManager.getConfig().getBoolean("actions.actionbar");
    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player p) {
            if (hashMapManager.playerHasTeleportTime(p)){
                HashMapManager.getMap().remove(p);
                if (title){
                    String titleMessage = configManager.getConfig().getString("title.danger.title");
                    String subTitleMessage = configManager.getConfig().getString("title.danger.subtitle");
                    p.sendTitle(ColorUtil.getColor(titleMessage), ColorUtil.getColor(subTitleMessage));
                }else if (actionbar){
                    String actionbarMessage = configManager.getConfig().getString("actionBar.danger.content");

                    p.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR,
                            new TextComponent(ColorUtil.getColor(actionbarMessage)));
                }else {
                    p.sendMessage("&cNie ustawiono zadnej akcji");
                }
            }
        }
    }
}
