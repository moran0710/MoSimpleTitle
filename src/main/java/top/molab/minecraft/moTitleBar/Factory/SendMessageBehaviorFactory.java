package top.molab.minecraft.moTitleBar.Factory;

import top.molab.minecraft.moTitleBar.behaviors.BaseMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowActionbarMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowSubtitleMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowTitleMessageBehavior;

public class SendMessageBehaviorFactory {
    public static BaseMessageBehavior getBehavior(String type, String message)
    {
        return switch (type) {
            case "title" -> new ShowTitleMessageBehavior(message);
            case "subtitle" -> new ShowSubtitleMessageBehavior(message);
            case "actionbar" -> new ShowActionbarMessageBehavior(message);
            default -> null;
        };
    }
}
