package com.bbn.speed.commands.global;

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

public class SetGlobalCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (args.length == 1 && event.getMessage().getMentionedChannels().size() == 1) {
            if (event.getMember().hasPermission(Permission.MANAGE_SERVER)) {
                Speed.rethink.setGlobal(event.getGuild().getId(), event.getMessage().getMentionedChannels().get(0).getId());
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich festgelegt")
                        .setDescription("Ich habe erfolgreich den Global Channel auf " + event.getMessage().getMentionedChannels().get(0).getAsMention()  + " festgelegt.")
                        .setColor(Color.GREEN)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Du benötigst die `Manage Server` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Falsche Nutzung")
                    .setDescription("Du musst den Command wiefolgt nutzen: `?setglobal #serverchat`.")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
