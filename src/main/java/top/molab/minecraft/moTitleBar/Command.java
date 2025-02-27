package top.molab.minecraft.moTitleBar;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import top.molab.minecraft.moTitleBar.Factory.SendMessageBehaviorFactory;
import top.molab.minecraft.moTitleBar.Utils.ColorUtil;
import top.molab.minecraft.moTitleBar.behaviors.BaseMessageBehavior;

import java.util.ArrayList;
import java.util.List;

public class Command implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, @NotNull String[] args) {
        MoTitleBar plugin = (MoTitleBar) Bukkit.getPluginManager().getPlugin("MoTitleBar");
        //plugin.getLogger().info(Arrays.toString(args));
        if (args.length == 0){ return false;}
        ArrayList<BaseMessageBehavior> tasks = new ArrayList<>();
        switch (args[0]){
            case "reload":
                Config.getInstance().reloadConfig();
                sender.sendMessage(ColorUtil.parse("&a&l重载配置成功！"));
                return true;
            default:
                if (args.length < 2){
                    return false;
                }
                StringBuilder builder = new StringBuilder();
                String lastMessageType = null;
                for(String item : args) {
                    switch (item) {
                        case "title":
                            if (lastMessageType == null) {
                                lastMessageType = "title";
                                continue;
                            }
                            tasks.add(SendMessageBehaviorFactory.getBehavior(lastMessageType, ColorUtil.parse(builder.toString())));
                            lastMessageType = "title";
                            builder = new StringBuilder();
                            break;
                        case "subtitle":
                            if (lastMessageType == null) {
                                lastMessageType = "subtitle";
                                continue;
                            }
                            tasks.add(SendMessageBehaviorFactory.getBehavior(lastMessageType, builder.toString()));
                            lastMessageType = "subtitle";
                            builder = new StringBuilder();
                            break;
                        case "actionbar":
                            if (lastMessageType == null) {
                                lastMessageType = "actionbar";
                                continue;
                            }
                            tasks.add(SendMessageBehaviorFactory.getBehavior(lastMessageType, builder.toString()));
                            lastMessageType = "actionbar";
                            builder = new StringBuilder();
                            break;
                        default:
                            builder.append(item).append(" ");
                    }
                }
                tasks.add(SendMessageBehaviorFactory.getBehavior(lastMessageType, builder.toString()));

        }
        for (BaseMessageBehavior task : tasks){
            task.sendMessage();
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> result = new ArrayList<>();
        if (args.length == 1){
            result.add("reload");
        }
        if (args.length %2 == 1){
            result.add("title");
            result.add("subtitle");
            result.add("actionbar");
        }else{
            result.add("<Message>");
        }
        return result;
    }

}
