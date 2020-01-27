package com.bbn.speed.commands.misc;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class HelpCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE) && event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Hilfe")
                    .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .build()).queue((message -> {
                        message.addReaction(1 + "\u20E3").queue();
                        message.addReaction(2 + "\u20E3").queue();
                        message.addReaction(3 + "\u20E3").queue();
                        message.addReaction(4 + "\u20E3").queue();
                Speed.rethink.setHelp(message.getId());
            }));
        } else {
            event.getAuthor().openPrivateChannel().complete().sendMessage(new EmbedBuilder()
                    .setTitle("Hilfe")
                    .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .build()).queue((message -> {
                message.addReaction(1 + "\u20E3").queue();
                message.addReaction(2 + "\u20E3").queue();
                message.addReaction(3 + "\u20E3").queue();
                message.addReaction(4 + "\u20E3").queue();
                Speed.rethink.setHelp(message.getId());
            }));
        }
    }
}
