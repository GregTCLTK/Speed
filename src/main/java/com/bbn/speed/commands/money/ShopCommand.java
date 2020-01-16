package com.bbn.speed.commands.money;

/*
 * @Author Skidder / GregTCLTK
 */

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
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
