package com.bbn.XZerkrypter.commands.misc;

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

public class SetTeamCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals("601366418759483393") || event.getAuthor().getId().equals("477141528981012511")) {
            if (event.getMessage().getMentionedUsers().size() > 0) {
                for (User u : event.getMessage().getMentionedUsers()) {
                    XZerkrypter.rethink.addTeam(u.getId());
                }
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich hinzugefügt")
                        .setDescription("Ich habe erfolgreich " + event.getMessage().getMentionedUsers().size() + " User dem Team hinzugefügt.")
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
                    .setDescription("Du bist nicht Klötchengrafik!")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
