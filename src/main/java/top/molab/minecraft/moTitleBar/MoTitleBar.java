package top.molab.minecraft.moTitleBar;

import org.bukkit.plugin.java.JavaPlugin;

public final class MoTitleBar extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Config.getInstance(getConfig());
        getLogger().info(String.format("MoTitleBar %b", Config.getInstance().getEnableTitleAd()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
