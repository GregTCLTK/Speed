package com.bbn.speed.commands.money;

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

/*
 * @Author Skidder / GregTCLTK
 */

public class ShopCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Shop")
                .setDescription("Die hier aufgelisteten Sachen gibt es zur Zeit im Shop.")
                .addField("Premium", "8000 Bäume", true)
                .addField("Gott des Lichtes", "12000 Bäume", true)
                .setColor(Color.GREEN)
                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
