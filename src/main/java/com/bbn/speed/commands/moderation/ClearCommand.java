package com.bbn.XZerkrypter.commands.moderation;

import com.bbn.XZerkrypter.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ClearCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length > 0) {
            if (event.getGuild().getMemberById(event.getAuthor().getId()).hasPermission(Permission.MESSAGE_MANAGE)) {
                if (event.getGuild().getMemberById(event.getJDA().getSelfUser().getId()).hasPermission(Permission.MESSAGE_MANAGE)) {
                    try {
                        int nbToDelete = Integer.parseInt(args[0]);
                        if(nbToDelete < 1 || nbToDelete > 200) {
                            event.getTextChannel().sendMessage(new EmbedBuilder().setTitle("Keine Nummer").setDescription("Du musst eine Nummer zwischen 1 und 200 angeben!").setTimestamp(Instant.now()).setColor(Color.RED).build()).queue();
                            return;
                        }
                        List<Message> history = event.getTextChannel().getHistory().retrievePast(nbToDelete +1).complete();
                        List<Message> msgToDelete = new ArrayList<>();
                        msgToDelete.addAll(history);
                        event.getTextChannel().deleteMessages(msgToDelete).queue();
                        event.getTextChannel().sendMessage(new EmbedBuilder().setTitle("Erfolgreich gelöscht").setDescription("Ich habe erfolgreich " + nbToDelete + " Nachrichten gelöscht.").build()).queue();
                    } catch (NumberFormatException e) {
                        event.getTextChannel().sendMessage(new EmbedBuilder().setTitle("Keine Nummer").setDescription("Du musst eine Nummer zwischen 1 und 200 angeben!").setTimestamp(Instant.now()).setColor(Color.RED).build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Permission")
                            .setDescription("Ich benötigst die `Manage Messages` Permission um diesen Command auszuführen.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Du benötigst die `Manage Messages` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder().setTitle("Keine Nummer").setDescription("Du musst eine Nummer zwischen 1 und 200 angeben!").setTimestamp(Instant.now()).setColor(Color.RED).build()).queue();
        }
    }
}
