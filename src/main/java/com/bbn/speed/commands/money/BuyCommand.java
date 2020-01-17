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

public class BuyCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("premium")) {
                if (Speed.rethink.getMoney(event.getAuthor().getId()) > 8000 || Speed.rethink.getMoney(event.getAuthor().getId()) == 8000) {
                    try {
                        event.getGuild().addRoleToMember(event.getMember(), event.getJDA().getGuildById("662472489317695490").getRoleById("INSERT LATER")).reason("Im Shop gekauft").queue();
                        Speed.rethink.setMoney(event.getAuthor().getId(), Speed.rethink.getMoney(event.getAuthor().getId()) - 8000);
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich gekauft")
                                .setDescription("Du hast dir erfolgreich Premium gekauft. Dir wurden 8000 Bäume abgezogen.")
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Nicht möglich")
                                .setDescription("Du musst auf dem offiziellen Speed Server sein um die Premium kaufen zu können.")
                                .setColor(Color.RED)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Bäume")
                            .setDescription("Du benötigst 8000 Bäume um dir diesen Gegenstand zu kaufen.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else if (args[0].equalsIgnoreCase("gott des lichtes")) {
                if (Speed.rethink.getMoney(event.getAuthor().getId()) > 12000 || Speed.rethink.getMoney(event.getAuthor().getId()) == 12000) {
                    try {
                        event.getGuild().addRoleToMember(event.getMember(), event.getJDA().getGuildById("662472489317695490").getRoleById("INSERT LATER")).reason("Im Shop gekauft").queue();
                        Speed.rethink.setMoney(event.getAuthor().getId(), Speed.rethink.getMoney(event.getAuthor().getId()) - 12000);
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich gekauft")
                                .setDescription("Du hast dir erfolgreich Premium gekauft. Dir wurden 12000 Bäume abgezogen.")
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Nicht möglich")
                                .setDescription("Du musst auf dem offiziellen Speed Server sein um die Premium kaufen zu können.")
                                .setColor(Color.RED)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Bäume")
                            .setDescription("Du benötigst 12000 Bäume um dir diesen Gegenstand zu kaufen.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Nicht existent")
                        .setDescription("Der angegebene Gegnstand existiert nicht im Shop. Eine Liste aller Gegenstände ist mit `?shop` einsehbar.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
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
