package com.bbn.speed.listener;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.time.Instant;

public class HelpListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        if (Speed.rethink.isHelp(event.getMessageId())) {
            if (!event.getUser().isBot()) {
                switch (event.getReactionEmote().getEmoji()) {
                    case 1 + "\u20E3":
                        event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                                .setTitle("Hilfe")
                                .setDescription("Hier siehst du alle Befehle der Moderation")
                                .addField("?unmute", "Entmutet einen Benutzer", true)
                                .addField("?mute", "Mutet einen Benutzer", true)
                                .addField("?unban", "Entbannt einen Benutzer", true)
                                .addField("?kick", "Kickt einen Benutzer", true)
                                .addField("?ban", "Bannt einen Benutzer", true)
                                .addField("?clear", "Löscht die angegebene Anzahl von Nachrichten", true)
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue((message) -> {
                                    message.clearReactions().queue();
                                    message.addReaction("⏪").queue();
                        });
                        break;
                    case 2 + "\u20E3":
                        break;
                    case 3 + "\u20E3":
                        break;
                    case 4 + "\u20E3":
                        break;
                    case "⏪":
                        event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                                .setTitle("Hilfe")
                                .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue((message -> {
                                    message.clearReactions().queue();
                                    message.addReaction(1 + "\u20E3").queue();
                                    message.addReaction(2 + "\u20E3").queue();
                                    message.addReaction(3 + "\u20E3").queue();
                                    message.addReaction(4 + "\u20E3").queue();
                            Speed.rethink.setHelp(message.getId());
                        }));
                        break;
                }
            }
        }
        super.onMessageReactionAdd(event);
    }
}
