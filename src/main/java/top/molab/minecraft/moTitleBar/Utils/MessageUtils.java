package top.molab.minecraft.moTitleBar.Utils;

import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import top.molab.minecraft.moTitleBar.Config;

import javax.annotation.Nullable;

public class MessageUtils {
    @SuppressWarnings("deprecation")
    public static void showTitleToAllPlayers(@Nullable String title, @Nullable String subtitle, int fadeIn, int stay, int fadeOut){
        var players = Bukkit.getOnlinePlayers();
        boolean papiEnabled = Config.getInstance().isPAPIEnabled();
        String newTitle = "";
        String newSubtitle = "";
        if (title != null) {
            title = ColorUtil.parse(title);
        }
        if (subtitle != null) {
            subtitle = ColorUtil.parse(subtitle);
        }
        for(Player p : players){
            if (papiEnabled){
                 if (title != null){newTitle = papiFormatMessage(p, title);}else{newTitle = title;}
                if (subtitle != null){newSubtitle = papiFormatMessage(p, subtitle);}else{newSubtitle = subtitle;}
            }

            p.sendTitle(
                   newTitle, newSubtitle, fadeIn, stay, fadeOut
           );

        }
    }
    public static String mergeArgsMessage(String[] args){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<args.length; i++){
            result.append(args[i]);
            result.append(" ");
        }
        return result.toString();
    }

    public static String papiFormatMessage(Player player, String raw){
        raw = PlaceholderAPI.setPlaceholders(player, raw);

        return raw;
    }

    @SuppressWarnings("deprecation")
    public static void showActionBarToAllPlayers(String message){
        String newMessage = "";
        boolean papiEnabled = Config.getInstance().isPAPIEnabled();
        message = ColorUtil.parse(message);
        var players = Bukkit.getOnlinePlayers();
        for(Player p : players){
            if (papiEnabled){newMessage = papiFormatMessage(p, message);}
            p.sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(newMessage));

        }
    }
}
