package com.bbn.XZerkrypter.commands.fun;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.XZerkrypter.XZerkrypter;
import com.bbn.XZerkrypter.commands.Command;
import com.bbn.XZerkrypter.core.Rethink;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.Calendar;

import static com.bbn.XZerkrypter.XZerkrypter.times;

public class LottoCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        Calendar calendar = Calendar.getInstance();
        if (times.containsKey(event.getAuthor()))
            calendar.setTimeInMillis(times.get(event.getAuthor()));
        if ("2".equals("2")) {
            boolean premium = Math.random() < 0.07;
            boolean botplus = Math.random() < 0.30;
            if (premium) {
                if (event.getGuild().getSelfMember().hasPermission(Permission.MANAGE_ROLES)) {
                    event.getGuild().addRoleToMember(event.getMember(), event.getJDA().getGuildById("662472489317695490").getRoleById("664367891839189015")).reason("Im Lotto gewonnen").queue();
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Gewonnen!")
                            .setDescription("Herzlichen Glückwunsch du hast soeben die Premium Rolle gewonnen!")
                            .setColor(Color.magenta)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Keine Permission")
                            .setDescription("Ich benötige die `Manage Roles` Permission um diesen Command auszuführen.")
                            .setColor(Color.RED)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else if (botplus) {
                if (!XZerkrypter.rethink.isBotPremium(event.getAuthor().getId())) {
                    XZerkrypter.rethink.setBotPremium(event.getAuthor().getId());
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Gewonnen!")
                            .setDescription("Herzlichen Glückwunsch du hast soeben den Bot Plus Status gewonnen!")
                            .setColor(Color.magenta)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                } else {
                    event.getTextChannel().sendMessage(new EmbedBuilder()
                            .setTitle("Leider nichts")
                            .setDescription("Das war wohl leider nichts. Vielleicht nächstes mal.")
                            .setColor(Color.CYAN)
                            .setTimestamp(Instant.now())
                            .build()).queue();
                }
            } else {
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Leider nichts")
                        .setDescription("Das war wohl leider nichts. Vielleicht nächstes mal.")
                        .setColor(Color.CYAN)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }

            Calendar calendar1 = Calendar.getInstance();
            calendar1.add(Calendar.HOUR_OF_DAY, 6);
            XZerkrypter.times.put(event.getAuthor(), calendar1.getTimeInMillis());
        } else event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Nicht möglich")
                .setDescription("Du kannst nur alle sechs Stunden den Lotto Command nutzen.")
                .setColor(Color.RED)
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
