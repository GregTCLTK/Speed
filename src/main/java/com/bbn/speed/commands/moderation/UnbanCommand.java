package com.bbn.speed.commands.moderation;

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class UnbanCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length > 0) {
            if (event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                if (event.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
                    if (event.getGuild().retrieveBanList().complete().toString().contains(event.getMessage().getContentRaw().replace("?unban ", ""))) {
                        String id = event.getGuild().retrieveBanList().complete().toString().split(event.getMessage().getContentRaw().replace("?unban ", ""), 2)[1].replace("(", "").replace(")", "").replace("]", "");
                        event.getGuild().unban(id).reason("Entbannt von " + event.getAuthor().getAsTag()).queue();
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich gebannt")
                                .setDescription("Ich habe erfolgreich " + event.getMessage().getContentRaw().replace("?unban ", "") + " entbannt.")
                                .setColor(Color.GREEN)
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Permission")
                            .setDescription("Ich benötige die `Ban Members` Permission um diesen Command auszuführen.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Du benötigst die `Ban Members` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keinen User angegeben")
                    .setDescription("Du musst einen User Namen angeben also z.B. ?unban Skidder")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
