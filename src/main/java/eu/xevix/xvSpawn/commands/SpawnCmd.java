package eu.xevix.xvSpawn.commands;

import eu.xevix.xvSpawn.managers.HashMapManager;
import eu.xevix.xvSpawn.managers.SpawnManager;
import eu.xevix.xvSpawn.utils.ColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("spawn")){
            if (sender instanceof Player p){
                if (p.hasPermission("xv-spawn.spawn")){
                    SpawnManager spawnManager = new SpawnManager();
                    if (spawnManager.getSpawnStatus()){
                        HashMapManager hashMapManager = new HashMapManager();
                        hashMapManager.addPlayer(p);
                        System.out.println("11");
                    }else{
                        p.sendMessage(ColorUtil.getColor("&cSpawn nie jest ustawiony"));
                    }
                }

            }else{
                Bukkit.getServer().getLogger().info("Tą komendę można wywołać z poziomu gry.");
            }

        }
        return false;
    }
}
