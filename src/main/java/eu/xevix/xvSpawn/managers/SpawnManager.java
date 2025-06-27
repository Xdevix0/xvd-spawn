package eu.xevix.xvSpawn.managers;

import eu.xevix.xvSpawn.utils.ColorUtil;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;


public class SpawnManager {
    ConfigManager configManager = new ConfigManager();
    boolean title = configManager.getConfig().getBoolean("actions.title");
    boolean actionbar = configManager.getConfig().getBoolean("actions.actionbar");
    public void setSpawn(Player p){
        Location loc = p.getLocation();
        try {
            configManager.getConfig().set("location", loc);

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aPomyślnie ustawiono spawn"));
            configManager.saveConfig();
        } catch (Exception e) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "Wystąpił nieoczekiwany błąd zajrzyj do konsoli"));
            throw new RuntimeException(e);
        }

    }
    public void teleportToSpawn(Player p){
        if (title){
            String titleMessage = configManager.getConfig().getString("title.success.title");
            String subTitleMessage = configManager.getConfig().getString("title.success.subtitle");
            p.sendTitle(ColorUtil.getColor(titleMessage), ColorUtil.getColor(subTitleMessage));
        }else if (actionbar){
            String actionbarMessage = configManager.getConfig().getString("actionBar.success.content");

            p.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR,
                    new TextComponent(ColorUtil.getColor(actionbarMessage)));
        }else {
            p.sendMessage("&cNie ustawiono zadnej akcji");
        }

        p.teleport(configManager.getConfig().getLocation("location"));

    }
    public boolean getSpawnStatus(){
        if (configManager.getConfig().getLocation("location") != null){
            return true;
        }else{
            return false;
        }
    }
    public void sendAction(Player p){
        HashMapManager hashMapManager = new HashMapManager();
        if (title){
            String titleMessage = configManager.getConfig().getString("title.info.title").replaceAll("%teleportTime%", String.valueOf(hashMapManager.getPlayerTeleportTime(p)));
            String subTitleMessage = configManager.getConfig().getString("title.info.subtitle").replaceAll("%teleportTime%", String.valueOf(hashMapManager.getPlayerTeleportTime(p)));
            p.sendTitle(ColorUtil.getColor(titleMessage), ColorUtil.getColor(subTitleMessage));
        }else if (actionbar){
            String actionbarMessage = configManager.getConfig().getString("actionBar.info.content").replaceAll("%teleportTime%", String.valueOf(hashMapManager.getPlayerTeleportTime(p)));;

            p.spigot().sendMessage(net.md_5.bungee.api.ChatMessageType.ACTION_BAR,
                    new TextComponent(ColorUtil.getColor(actionbarMessage)));
        }else {
            p.sendMessage(ColorUtil.getColor("&cNie ustawiono zadnej akcji"));
        }
    }
}
