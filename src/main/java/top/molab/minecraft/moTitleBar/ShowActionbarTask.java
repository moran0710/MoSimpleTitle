package top.molab.minecraft.moTitleBar;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import top.molab.minecraft.moTitleBar.Utils.MessageUtils;

import java.util.List;
import java.util.Random;

public class ShowActionbarTask extends BukkitRunnable {

    private int index = 0;
    private final Random random = new Random();

    public void start(Plugin plugin){
        this.runTaskTimerAsynchronously(plugin, 0, (long) (Config.getInstance().getActionbarSwitchTime() * 20));
    }

    @Override
    public void run() {
        Config config = Config.getInstance();
        List<String> messages = config.getActionbarMessages();
        //getLogger().info(messages.toString());

        if (Config.getInstance().getEnableActionbarRandom()){
            int messageIndex = this.random.nextInt(0, messages.size());
            String message = messages.get(messageIndex);
            MessageUtils.showActionBarToAllPlayers(message);
        }else{
            String message = messages.get(this.index);
            MessageUtils.showActionBarToAllPlayers(message);
            this.index += 1;
            if (this.index >= messages.size()){
                this.index = 0;
            }
        }
    }
}
