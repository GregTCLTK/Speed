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

public class RemoveGlobalCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMember().hasPermission(Permission.MANAGE_SERVER)) {
            Speed.rethink.setGlobal(event.getGuild().getId(), null);
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Erfolgreich entfernt")
                    .setDescription("Ich habe den Global Channel erfolgreich entfernt.")
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Permission")
                    .setDescription("Du benötigst die `Manage Server` Permission um diesen Command auszuführen.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
