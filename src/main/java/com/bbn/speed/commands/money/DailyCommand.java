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

public class DailyCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.getDailyTime(event.getAuthor().getId()) == null) {
            collect(event);
        } else if (Speed.rethink.getDailyTime(event.getAuthor().getId()).isBefore(Instant.now().minusSeconds(86400L))) {
            collect(event);
        } else event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Nicht möglich")
                .setDescription("Du kannst nur alle 24 Stunden deine tägliche Belohnung abholen.")
                .setColor(Color.RED)
                .setTimestamp(Instant.now())
                .build()).queue();
    }

    private void collect(MessageReceivedEvent event) {
        Speed.rethink.setDailyTime(Instant.now(), event.getAuthor().getId());
        Speed.rethink.setMoney(event.getAuthor().getId(), Speed.rethink.getMoney(event.getAuthor().getId()) + 150);
        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Erfolgreich abgeholt")
                .setDescription("Du hast erfolgreich deine tägliche Belohnung abgeholt.")
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
