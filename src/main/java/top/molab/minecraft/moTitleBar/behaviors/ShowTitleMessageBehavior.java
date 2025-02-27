package top.molab.minecraft.moTitleBar.behaviors;

import top.molab.minecraft.moTitleBar.Utils.MessageUtils;

public class ShowTitleMessageBehavior implements BaseMessageBehavior {
    private final String message;
    public ShowTitleMessageBehavior(String message){
        this.message = message;
    }

    @Override
    public void sendMessage() {
        MessageUtils.showTitleToAllPlayers(message, null, 20, 20, 20);
    }
}
