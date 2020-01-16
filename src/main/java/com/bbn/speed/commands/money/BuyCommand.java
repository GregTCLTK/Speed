package com.bbn.speed.commands.money;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class BuyCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length > 0) {

        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Kein Gegenstand")
                    .setDescription("Du musst einen Gegenstand zum Kaufen angeben. Eine Liste aller Gegenstände ist mit `?shop` einsehbar.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
