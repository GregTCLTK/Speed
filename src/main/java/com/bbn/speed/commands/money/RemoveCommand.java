package com.bbn.speed.commands.money;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class RemoveCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.isTeam(event.getAuthor().getId()) || event.getAuthor().getId().equals("477141528981012511")) {
            if (args.length == 2) {
                if (event.getMessage().getMentionedUsers().size() == 1) {
                    try {
                        int amount = Integer.parseInt(args[1]);
                        Speed.rethink.setMoney(event.getMessage().getMentionedUsers().get(0).getId(), Speed.rethink.getMoney(event.getMessage().getMentionedUsers().get(0).getId()) - amount);
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich entfernt")
                                .setDescription(event.getMessage().getMentionedUsers().get(0).getName() + " hat erfolgreich " + amount + " Bäume verloren.")
                                .setColor(Color.GREEN)
                                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    } catch (Exception e) {
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Falsche Nutzung")
                                .setDescription("Du musst eine Zahl angeben.")
                                .setColor(Color.RED)
                                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Falsche Nutzung")
                            .setDescription("Du musst genau einen User angeben. Nicht mehr und nicht weniger.")
                            .setColor(Color.RED)
                            .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Falsche Nutzung")
                        .setDescription("Du musst genau einen User und eine Zahl angeben.")
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
