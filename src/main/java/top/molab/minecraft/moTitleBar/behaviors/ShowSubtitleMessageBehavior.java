package top.molab.minecraft.moTitleBar.behaviors;

import top.molab.minecraft.moTitleBar.Utils.MessageUtils;

public class ShowSubtitleMessageBehavior implements BaseMessageBehavior {

    private final String message;

    public ShowSubtitleMessageBehavior(String message){
        this.message = message;
    }

    @Override
    public void sendMessage() {
        MessageUtils.showTitleToAllPlayers(null, message, 20, 20, 20);
    }
}
