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

public class StatsCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        EmbedBuilder eb = new EmbedBuilder();

        if (Speed.rethink.isBotPremium(event.getAuthor().getId())) {
            eb.addField("Bot Plus", "ja", true);
        } else {
            eb.addField("Bot Plus", "nein", true);
        }
        event.getTextChannel().sendMessage(eb
                .setTitle("Deine Statistiken")
                .addField("Bäume", String.valueOf(Speed.rethink.getMoney(event.getAuthor().getId())), true)
                .setColor(Color.GREEN)
                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
