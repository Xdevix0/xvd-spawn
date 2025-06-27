package eu.xevix.xvSpawn;

import eu.xevix.xvSpawn.commands.SetSpawnCmd;
import eu.xevix.xvSpawn.commands.SpawnCmd;
import eu.xevix.xvSpawn.listeners.PlayerMoveListener;
import eu.xevix.xvSpawn.managers.ConfigManager;
import eu.xevix.xvSpawn.managers.TaskManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {
    public ConfigManager configManager;
    @Override
    public void onEnable() {
        saveResource("config.yml", false);
        configManager = new ConfigManager();
        configManager.loadConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
        Bukkit.getServer().getPluginCommand("spawn").setExecutor(new SpawnCmd());
        Bukkit.getServer().getPluginCommand("setspawn").setExecutor(new SetSpawnCmd());
        TaskManager taskManager = new TaskManager();
        taskManager.startGlobalMap();
    }

    @Override
    public void onDisable() {
        try {
            configManager.saveConfig();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
