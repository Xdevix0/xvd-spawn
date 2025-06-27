package eu.xevix.xvSpawn.managers;

import eu.xevix.xvSpawn.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public static YamlConfiguration yamlConfiguration;
    public void loadConfig(){
        yamlConfiguration = new YamlConfiguration();
        try {
            yamlConfiguration.load(new File(Main.getPlugin(Main.class).getDataFolder().getAbsolutePath(), "config.yml"));
            Bukkit.getServer().getLogger().info("Pomyślnie załadowano config.yml");
        } catch (InvalidConfigurationException | IOException e) {
            Bukkit.getServer().getLogger().info("Konfiguracja pliku jest nie poprawna");
            Bukkit.getServer().shutdown();
            throw new RuntimeException(e);
        }
    }
    public YamlConfiguration getConfig(){
        return yamlConfiguration;
    }
    public void saveConfig() throws IOException {
        try{
            yamlConfiguration.save(new File(Main.getPlugin(Main.class).getDataFolder().getAbsolutePath(), "config.yml"));

        }catch (IOException e ){
            Bukkit.getServer().getLogger().info("Wystąpił bład podczas zapisywania danych");

            throw new RuntimeException(e);
        }
    }

}
