package eu.xevix.xvSpawn.managers;

import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public class HashMapManager {
    public static ConcurrentHashMap<Player, Integer> teleportTimeMap = new ConcurrentHashMap<>();
    private int teleportTime = 0;

    public HashMapManager() {
        ConfigManager configManager = new ConfigManager();
        this.teleportTime = configManager.getConfig().getInt("teleportTime");
    }

    public void addPlayer(Player p){
        teleportTimeMap.put(p, teleportTime);
    }


    public int getPlayerTeleportTime(Player p){
        return teleportTimeMap.getOrDefault(p, 0);
    }

    public boolean playerHasTeleportTime(Player p){
        return teleportTimeMap.containsKey(p);
    }

    public static ConcurrentHashMap<Player, Integer> getMap(){
        return teleportTimeMap;
    }
}
