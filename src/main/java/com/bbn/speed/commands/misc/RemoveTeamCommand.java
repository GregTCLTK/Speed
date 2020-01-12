package com.bbn.speed.commands.misc;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class RemoveTeamCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getAuthor().getId().equals("601366418759483393") || event.getAuthor().getId().equals("477141528981012511")) {
            if (event.getMessage().getMentionedUsers().size() > 0) {
                for (User u : event.getMessage().getMentionedUsers()) {
                    Speed.rethink.removeTeam(u.getId());
                }
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich entfernt")
                        .setDescription("Ich habe erfolgreich " + event.getMessage().getMentionedUsers().size() + " User vom Team entfernt.")
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
