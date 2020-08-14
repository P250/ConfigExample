package me.johnny.configexample;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class Main extends JavaPlugin {

    private File configFile;
    private FileConfiguration config;
    private HashMap<String, Object> defaults;

    private void initalizeConfig() {
        configFile = new File(getDataFolder(), "myEpicConfig.yml");
        config = YamlConfiguration.loadConfiguration(configFile);

        if (configFile.exists() == false) {
            defaults = new HashMap<String, Object>();

            defaults.put("path.to.string", "MyString");
            defaults.put("path.to.integer", 10);
            defaults.put("path.to.double", 20D);

            config.addDefaults(defaults);
            config.options().copyDefaults(true);
        }

        try {
            config.save(configFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onEnable() {
        initalizeConfig();
        getCommand("testcmd").setExecutor(new Command(this));
    }

    @Override
    public FileConfiguration getConfig() {
        return config;
    }
}
