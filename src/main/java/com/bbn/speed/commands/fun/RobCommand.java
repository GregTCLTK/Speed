package com.bbn.speed.commands.fun;

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

public class RobCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMessage().getMentionedUsers().size() == 1) {
            if (Speed.rethink.getRobTime(event.getAuthor().getId()) == null) {
                rob(event, event.getMessage().getMentionedUsers().get(0));
            } else if (Speed.rethink.getRobTime(event.getAuthor().getId()).isBefore(Instant.now().minusSeconds(480L))) {
                rob(event, event.getMessage().getMentionedUsers().get(0));
            } else event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Nicht möglich")
                    .setDescription("Du kannst nur alle acht Minuten den Rob Command nutzen.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Nicht möglich")
                    .setDescription("Du musst genau einern User angeben den du ausrauben möchtest.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }

    private void rob(MessageReceivedEvent event, User u) {
        boolean success = Math.random() < 0.35;
        if (success) {
            int money = (int)(Speed.rethink.getMoney(u.getId())*(19.0f/100.0f));
            event.getGuild().addRoleToMember(event.getMember(), event.getJDA().getGuildById("662472489317695490").getRoleById("664367891839189015")).reason("Im Lotto gewonnen").queue();
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Gewonnen!")
                    .setDescription("Herzlichen Glückwunsch du hast soeben die Premium Rolle gewonnen!")
                    .setColor(Color.magenta)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Nicht möglich")
                    .setDescription("Du kannst nur alle acht Minuten den Rob Command nutzen.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
        Speed.rethink.setRobTime(Instant.now(), event.getAuthor().getId());
    }
}
