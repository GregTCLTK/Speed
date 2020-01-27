package com.bbn.speed.listener;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class HelpListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        if (Speed.rethink.isHelp(event.getMessageId())) {
            if (!event.getUser().isBot()) {
                switch (event.getReactionEmote().getEmoji()) {
                    case 1 + "\u20E3":
                        break;
                    case 2 + "\u20E3":
                        break;
                    case 3 + "\u20E3":
                        break;
                    case 4 + "\u20E3":
                        break;
                }
            }
        }
        super.onMessageReactionAdd(event);
    }
}
