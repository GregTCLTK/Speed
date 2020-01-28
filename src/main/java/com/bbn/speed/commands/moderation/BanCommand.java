package com.bbn.speed.commands.moderation;

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class BanCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMessage().getMentionedUsers().size() == 1) {
            if (event.getMember().hasPermission(Permission.BAN_MEMBERS)) {
                if (event.getGuild().getSelfMember().hasPermission(Permission.BAN_MEMBERS)) {
                    if (event.getGuild().getSelfMember().canInteract(event.getMessage().getMentionedMembers().get(0))) {
                        event.getGuild().ban(event.getMessage().getMentionedUsers().get(0), 0).reason("Gebannt von " + event.getAuthor().getAsTag()).queue();
                        event.getTextChannel().sendMessage(new EmbedBuilder()
                                .setTitle("Erfolgreich gebannt")
                                .setDescription("Ich habe " + event.getMessage().getMentionedUsers().get(0).getAsTag() + " erfolgreich gebannt.")
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
                            .setDescription("Ich benötige die `Ban Members` Permission um diesen Command auszuführen.")
                            .setColor(Color.RED)
                            .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Du benötigst die `Ban Members` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Keine Mention")
                    .setDescription("Du musst mindestens einen User per Mention angeben. Deine Nachricht sollte also z.B so aussehen: `?ban @Skidder#6775`")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
