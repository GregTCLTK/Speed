package com.bbn.speed.commands.money;

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

public class LottoCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.getLottoTime(event.getAuthor().getId()) == null) {
            lotto(event);
        } else if (Speed.rethink.getLottoTime(event.getAuthor().getId()).isBefore(Instant.now().minusSeconds(21600L))) {
            lotto(event);
        } else event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Nicht möglich")
                .setDescription("Du kannst nur alle sechs Stunden den Lotto Command nutzen.")
                .setColor(Color.RED)
                .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                .setTimestamp(Instant.now())
                .build()).queue();
    }

    private void lotto(MessageReceivedEvent event) {
        boolean premium = Math.random() < 0.07;
        boolean botplus = Math.random() < 0.30;
        if (premium) {
            if (event.getGuild().getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
                event.getGuild().addRoleToMember(event.getMember(), event.getJDA().getGuildById("662472489317695490").getRoleById("664367891839189015")).reason("Im Lotto gewonnen").queue();
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Gewonnen!")
                        .setDescription("Herzlichen Glückwunsch du hast soeben die Premium Rolle gewonnen!")
                        .setColor(Color.magenta)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Keine Permission")
                        .setDescription("Ich benötige die `Manage Roles` Permission um diesen Command auszuführen.")
                        .setColor(Color.RED)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else if (botplus) {
            if (!Speed.rethink.isBotPremium(event.getAuthor().getId())) {
                Speed.rethink.setBotPremium(event.getAuthor().getId());
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Gewonnen!")
                        .setDescription("Herzlichen Glückwunsch du hast soeben den Bot Plus Status gewonnen!")
                        .setColor(Color.magenta)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Leider nichts")
                        .setDescription("Das war wohl leider nichts. Vielleicht nächstes mal.")
                        .setColor(Color.CYAN)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Leider nichts")
                    .setDescription("Das war wohl leider nichts. Vielleicht nächstes mal.")
                    .setColor(Color.CYAN)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
        Speed.rethink.setLottoTime(Instant.now(), event.getAuthor().getId());
    }
}
