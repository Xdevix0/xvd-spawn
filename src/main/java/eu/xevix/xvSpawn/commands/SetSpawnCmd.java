package eu.xevix.xvSpawn.commands;

import eu.xevix.xvSpawn.managers.SpawnManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("setspawn")){
            if (sender instanceof Player p){
                if (p.hasPermission("xv-spawn.setspawn")){
                    SpawnManager spawnManager = new SpawnManager();
                    spawnManager.setSpawn((Player) sender);
                }

            }else{
                Bukkit.getServer().getLogger().info("Tą komendę można wywołać z poziomu gry.");
            }

        }
        return false;
    }
}
