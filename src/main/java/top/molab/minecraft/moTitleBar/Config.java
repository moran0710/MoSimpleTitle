package top.molab.minecraft.moTitleBar;

import org.bukkit.configuration.file.FileConfiguration;

public class Config {
    private final String[] titles;
    private final String[] subTitles;
    private final Boolean enableTitleAd;
    private final Boolean enableSubTitleAd;
    private final double subTitleSwitchTime;
    private final double titleSwitchTime;
    private final double subTitleRenderTime;
    private final double titleRenderTime;
    private static Config instance = null;

    public static Config getInstance(FileConfiguration config) {
        if (instance == null) {
            instance = new Config(config);
        }
        return instance;
    }

    public static Config getInstance() {
        if (instance == null) {
            throw new IllegalStateException("Config not initialized yet.");
        }
        return instance;
    }

    private Config(FileConfiguration ConfigFile){
        this.titles = ConfigFile.getObject("title.texts", String[].class, new String[0]);
        this.subTitles = ConfigFile.getObject("subtitle.texts", String[].class, new String[0]);
        this.enableSubTitleAd = ConfigFile.getBoolean("subtitle.enable", false);
        this.enableTitleAd = ConfigFile.getBoolean("title.enable", true);
        this.subTitleSwitchTime = ConfigFile.getDouble("subtitle.switchTime", 0);
        this.titleSwitchTime = ConfigFile.getDouble("title.switchTime", 0);
        this.subTitleRenderTime = ConfigFile.getDouble("subtitle.renderTime", 0);
        this.titleRenderTime = ConfigFile.getDouble("title.renderTime", 0);
    }

    public String[] getTitles() {
        return titles;
    }

    public String[] getSubTitles() {
        return subTitles;
    }

    public Boolean getEnableTitleAd() {
        return enableTitleAd;
    }

    public Boolean getEnableSubTitleAd() {
        return enableSubTitleAd;
    }

    public double getSubTitleSwitchTime() {
        return subTitleSwitchTime;
    }

    public double getTitleSwitchTime() {
        return titleSwitchTime;
    }

    public double getSubTitleRenderTime() {
        return subTitleRenderTime;
    }

    public double getTitleRenderTime() {
        return titleRenderTime;
    }
}
