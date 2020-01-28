package com.bbn.speed.commands.moderation;

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class KickCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMessage().getMentionedMembers().size() == 1) {
            if (event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
                if (event.getGuild().getSelfMember().hasPermission(Permission.KICK_MEMBERS)) {
                    if (event.getGuild().getSelfMember().canInteract(event.getMessage().getMentionedMembers().get(0))) {
                        event.getGuild().kick(event.getMessage().getMentionedMembers().get(0)).reason("Gekickt von " + event.getAuthor().getAsTag()).queue();
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich gekickt")
                                .setDescription("Ich habe " + event.getMessage().getMentionedUsers().get(0).getAsTag() + " erfolgreich gekickt.")
                                .setColor(Color.GREEN)
                                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    } else {
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Keine Permission")
                                .setDescription("Meine Rolle muss über der höchsten Rolle der zu bannenden Person sein.")
                                .setColor(Color.RED)
                                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                                .setTimestamp(Instant.now())
                                .build()).queue();
                    }
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Permission")
                            .setDescription("Ich benötige die `Kick Members` Permission um diesen Command auszuführen.")
                            .setColor(Color.RED)
                            .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Du benötigst die `Kick Members` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Mention")
                    .setDescription("Du musst mindestens einen User per Mention angeben. Deine Nachricht sollte also z.B so aussehen: `?kick @Skidder#6775`")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
