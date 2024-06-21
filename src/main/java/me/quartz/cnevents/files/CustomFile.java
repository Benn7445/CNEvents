package me.quartz.cnevents.files;

import me.quartz.cnevents.CNEvents;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomFile {

    private File customConfigFile;
    private FileConfiguration customConfig;

    public CustomFile(String name) {
        createCustomConfig(name);
    }

    public FileConfiguration getCustomConfig() {
        return this.customConfig;
    }

    public File getCustomConfigFile() {
        return this.customConfigFile;
    }

    public void saveFile() {
        try {
            getCustomConfig().save(getCustomConfigFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createCustomConfig(String name) {
        customConfigFile = new File(CNEvents.getInstance().getDataFolder(), name + ".yml");
        if (!customConfigFile.exists()) {
            customConfigFile.getParentFile().mkdirs();
            CNEvents.getInstance().saveResource(name + ".yml", false);
        }

        customConfig = new YamlConfiguration();
        try {
            customConfig.load(customConfigFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
}
