package com.bbn.XZerkrypter.commands.fun;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.XZerkrypter.XZerkrypter;
import com.bbn.XZerkrypter.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class GiveCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length == 2) {
            if (event.getMessage().getMentionedUsers().size() == 1) {
                try {
                    int amount = Integer.parseInt(args[1]);
                    if (XZerkrypter.rethink.getMoney(event.getAuthor().getId()) == amount || XZerkrypter.rethink.getMoney(event.getAuthor().getId()) > amount) {
                        XZerkrypter.rethink.setMoney(event.getMessage().getMentionedUsers().get(0).getId(), XZerkrypter.rethink.getMoney(event.getMessage().getMentionedUsers().get(0).getId()) + amount);
                        XZerkrypter.rethink.setMoney(event.getAuthor().getId(), XZerkrypter.rethink.getMoney(event.getAuthor().getId()) - amount);
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich abgegeben")
                                .setDescription(event.getMessage().getMentionedUsers().get(0).getName() + " hat erfolgreich " + amount + " Bäume erhalten.")
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    } else {
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Keine Bäume")
                                .setDescription("Du hast nicht genug Bäume um so viele abzugeben.")
                                .setColor(Color.RED)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } catch (Exception e) {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Falsche Nutzung")
                            .setDescription("Du musst eine Zahl angeben.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Falsche Nutzung")
                        .setDescription("Du musst genau einen User angeben. Nicht mehr und nicht weniger.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Falsche Nutzung")
                    .setDescription("Du musst genau einen User und eine Zahl angeben.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
