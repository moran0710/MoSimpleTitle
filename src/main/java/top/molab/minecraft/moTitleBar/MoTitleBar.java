package top.molab.minecraft.moTitleBar;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;


public final class MoTitleBar extends JavaPlugin {

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        boolean isPAPIEnabled;
        if (Bukkit.getPluginCommand("motitlebar") != null) {
            Objects.requireNonNull(Bukkit.getPluginCommand("motitlebar")).setExecutor(new Command());
            Objects.requireNonNull(Bukkit.getPluginCommand("motitlebar")).setTabCompleter(new Command());
        }

        isPAPIEnabled = checkIsPAPIEnabled();
        Config.getInstance(getConfig(), isPAPIEnabled);
        if (Config.getInstance().getEnableActionbarMessageAd()) {
            (new ShowActionbarTask()).start(this);
            getLogger().info("enable actionbar message");
        }else{
            getLogger().info("disable actionbar message");
        }

        getLogger().info("##################");
        getLogger().info("#MoTitle | 简单公告#");
        getLogger().info("#Author:Moran0710 #");
        getLogger().info("##################");
    }

    private boolean checkIsPAPIEnabled() {
        boolean isPAPIEnabled;
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            getLogger().info("Find PlaceholderAPI, PAPI functions enabled");
            isPAPIEnabled = true;
        }else{
            getLogger().warning("Cannot find PlaceholderAPI, PAPI functions disabled");
            isPAPIEnabled = false;
        }
        return isPAPIEnabled;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
