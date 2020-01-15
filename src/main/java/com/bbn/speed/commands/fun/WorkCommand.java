package com.bbn.speed.commands.fun;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.Random;

public class WorkCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.getWorkTime(event.getAuthor().getId()) == null) {
            work(event);
        } else if (Speed.rethink.getWorkTime(event.getAuthor().getId()).isBefore(Instant.now().minusSeconds(1800000L))) {
            work(event);
        } else event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Nicht möglich")
                .setDescription("Du kannst nur alle 30 Minuten arbeiten gehen.")
                .setColor(Color.RED)
                .setTimestamp(Instant.now())
                .build()).queue();
    }

    private void work(MessageReceivedEvent event) {
        int i = new Random().nextInt(10);

        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
        }
        Speed.rethink.setWorkTime(Instant.now(), event.getAuthor().getId());
        Speed.rethink.setMoney(event.getAuthor().getId(), Speed.rethink.getMoney(event.getAuthor().getId()) + 150);
        //TODO: Do math stuff and work messages ;)
    }
}
