package eu.xevix.xvSpawn.managers;

import eu.xevix.xvSpawn.Main;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskManager {
    public void startGlobalMap() {
        SpawnManager spawnManager = new SpawnManager();
        BukkitRunnable timerTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (!HashMapManager.getMap().isEmpty()) {
                    HashMapManager.getMap().forEach((p, time) -> {
                        if (p == null || time == null) return;
                        if (time == 0) {
                            HashMapManager.getMap().remove(p);
                            spawnManager.teleportToSpawn(p);
                        } else {
                            spawnManager.sendAction(p);
                            HashMapManager.getMap().put(p, time - 1);
                        }
                    });
                }
            }
        };
        timerTask.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
    }
}
