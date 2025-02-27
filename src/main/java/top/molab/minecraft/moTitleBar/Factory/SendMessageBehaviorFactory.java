package top.molab.minecraft.moTitleBar.Factory;

import top.molab.minecraft.moTitleBar.behaviors.BaseMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowActionbarMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowSubtitleMessageBehavior;
import top.molab.minecraft.moTitleBar.behaviors.ShowTitleMessageBehavior;

public class SendMessageBehaviorFactory {
    public static BaseMessageBehavior getBehavior(String type, String message)
    {
        switch (type)
        {
            case "title":
                return new ShowTitleMessageBehavior(message);
            case "subtitle":
                return new ShowSubtitleMessageBehavior(message);
            case "actionbar":
                return new ShowActionbarMessageBehavior(message);
            default:
                return null;
        }
    }
}
