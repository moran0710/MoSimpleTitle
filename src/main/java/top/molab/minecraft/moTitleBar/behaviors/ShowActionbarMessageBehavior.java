package top.molab.minecraft.moTitleBar.behaviors;

import top.molab.minecraft.moTitleBar.Utils.MessageUtils;

public class ShowActionbarMessageBehavior implements BaseMessageBehavior {
    private final String message;

    public ShowActionbarMessageBehavior(String message){
        this.message = message;
    }

    @Override
    public void sendMessage(){
        MessageUtils.showActionBarToAllPlayers(this.message);
    }

}
