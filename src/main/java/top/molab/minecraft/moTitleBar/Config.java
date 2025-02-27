package top.molab.minecraft.moTitleBar;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class Config {
    public List<String> getActionbarMessages() {
        return actionbarMessages;
    }

    public Boolean getEnableActionbarMessageAd() {
        return enableActionbarMessageAd;
    }

    public Boolean getEnableActionbarRandom() {
        return enableActionbarRandom;
    }

    public double getActionbarSwitchTime() {
        return actionbarSwitchTime;
    }

    private List<String> actionbarMessages;
    private Boolean enableActionbarMessageAd;
    private Boolean enableActionbarRandom;
    private double actionbarSwitchTime;

    public boolean isPAPIEnabled() {
        return isPAPIEnabled;
    }

    private boolean isPAPIEnabled;
    static private Config instance = null;


    public static Config getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Config is not initialized");
        }
        return instance;
    }

    public static Config getInstance(FileConfiguration ConfigFile, boolean isPAPIEnabled) {
        if (instance == null) {
            instance = new Config(ConfigFile, isPAPIEnabled);
        }
        return instance;
    }

    public void reloadConfig() {
        Boolean PAPI = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
        MoTitleBar plugin = (MoTitleBar) Bukkit.getPluginManager().getPlugin("MoTitleBar");
        YamlConfiguration ConfigFile = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
        this.init(ConfigFile, PAPI);
    }

    private Config(FileConfiguration ConfigFile, boolean isPAPIEnabled) {
        init(ConfigFile, isPAPIEnabled);
    }

    private void init(FileConfiguration ConfigFile, boolean PAPI) {
        this.isPAPIEnabled = PAPI;

        this.actionbarMessages = ConfigFile.getStringList("actionbar.texts");
        this.enableActionbarMessageAd = ConfigFile.getBoolean("actionbar.enable");
        this.enableActionbarRandom = ConfigFile.getBoolean("actionbar.random");
        this.actionbarSwitchTime = ConfigFile.getDouble("actionbar.switchTime");

    }
}


