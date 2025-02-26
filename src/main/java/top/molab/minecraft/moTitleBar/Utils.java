package top.molab.minecraft.moTitleBar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class Utils {
    @SuppressWarnings("deprecation")
    public void showTitleToAllPlayers(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut){
        var players = Bukkit.getOnlinePlayers();
        for(Player p : players){
           p.sendTitle(
                   title, subtitle, fadeIn, stay, fadeOut
           );

        }
    }
}
