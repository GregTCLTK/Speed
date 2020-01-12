package com.bbn.XZerkrypter.commands.moderation;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.XZerkrypter.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class MuteCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMember().hasPermission(Permission.MANAGE_ROLES)) {
            if (event.getMessage().getMentionedMembers().size() > 0) {
                try {
                    event.getGuild().getRolesByName("Muted", true).get(0);
                    event.getGuild().addRoleToMember(event.getMessage().getMentionedMembers().get(0), event.getGuild().getRolesByName("Muted", true).get(0)).reason("Gemuted von " + event.getAuthor().getAsTag()).queue();;
                } catch (Exception e) {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Mute Rolle")
                            .setDescription("Es existiert auf diesem Server keine Rolle mit dem Namen `muted`")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Mention")
                        .setDescription("Du musst mindestens einen User per Mention angeben. Deine Nachricht sollte also z.B so aussehen: `?mute @Skidder#6775`")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Permission")
                    .setDescription("Du benötigst die `Manage Roles` Permission um diesen Command auszuführen.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
