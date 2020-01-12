package com.bbn.XZerkrypter.commands.global;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.XZerkrypter.XZerkrypter;
import com.bbn.XZerkrypter.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class GlobalMuteCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (XZerkrypter.rethink.isTeam(event.getAuthor().getId())) {
            if (event.getMessage().getMentionedUsers().size() > 0) {
                for (User u : event.getMessage().getMentionedUsers()) {
                    if (XZerkrypter.rethink.isMuted(u.getId())) {
                        XZerkrypter.rethink.setMuted(u.getId(), false);
                    } else {
                        XZerkrypter.rethink.setMuted(u.getId(), true);
                    }
                }
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich ausgeführt")
                        .setDescription("Ich habe erfolgreich den Mute Status von " + event.getMessage().getMentionedUsers().size() + " User gändert.")
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Falsche Nutzung")
                        .setDescription("Du musst mindestens einen User angeben.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Berechtigung")
                    .setDescription("Du bist nicht Teil des Teams!")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
