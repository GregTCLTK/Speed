package com.bbn.speed.commands.global;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class ServerBanCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.isTeam(event.getAuthor().getId())) {
            if (args.length > 0) {
                if (args[0].length() == 18) {
                    try {
                        Guild g = event.getJDA().getGuildById(args[0]);
                        if (Speed.rethink.isGuildMuted(g.getId())) {
                            Speed.rethink.setGuildMute(g.getId(), false);
                            event.getTextChannel().sendMessage(new EmbedBuilder()
                                    .setTitle("Erfolgreich ausgeführt")
                                    .setDescription("Ich habe erfolgreich den Server " + g.getName() + " entmuted.")
                                    .setColor(Color.GREEN)
                                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                    .setTimestamp(Instant.now())
                                    .build()).queue();
                        } else {
                            Speed.rethink.setGuildMute(g.getId(), true);
                            event.getTextChannel().sendMessage(new EmbedBuilder()
                                    .setTitle("Erfolgreich ausgeführt")
                                    .setDescription("Ich habe erfolgreich den Server " + g.getName() + " gemuted.")
                                    .setColor(Color.GREEN)
                                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                    .setTimestamp(Instant.now())
                                    .build()).queue();
                        }
                    } catch (Exception e) {
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Nicht möglich")
                                .setDescription("Der angegebene Server kann nicht gefunden werden.")
                                .setColor(Color.RED)
                                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Falsche Nutzung")
                            .setDescription("Die angegebene Server ID ist nicht gültig.")
                            .setColor(Color.RED)
                            .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Falsche Nutzung")
                        .setDescription("Du musst genau eine Server ID angeben.")
                        .setColor(Color.RED)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Berechtigung")
                    .setDescription("Du bist nicht Teil des Teams!")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
