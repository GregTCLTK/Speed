package com.bbn.speed.commands.money;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Random;

public class WorkCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.getWorkTime(event.getAuthor().getId()) == null) {
            work(event);
        } else if (Speed.rethink.getWorkTime(event.getAuthor().getId()).isBefore(Instant.now().minusSeconds(1800L))) {
            work(event);
        } else {
            Duration between = Duration.between(Instant.now(), Speed.rethink.getWorkTime(event.getAuthor().getId()).plusSeconds(1800L));
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Nicht möglich")
                    .setDescription("Du kannst erneut in `" + LocalTime.MIN.plusSeconds(between.getSeconds()).toString() + "` Minuten arbeiten.")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }

    private void work(MessageReceivedEvent event) {
        int i = new Random().nextInt(11);
        Random r = new Random();
        int low = 20;
        int high = 70;
        int salary = r.nextInt(high-low) + low;

        switch (i) {
            case 0:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast bei Angela Merkel als Putzfrau gearbeitet und erhälst dafür " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 1:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast im US-Verteidigungsministerium die Toiletten sauber gemacht und erhältst dafür " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 2:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast als Supporter bei Microsoft " + salary + " Bäume verdient.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 3:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast erfolgreich an der Rezeption eines 5 Sterne Hotels gearbeitet und erhältst dafür " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 4:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast als Full Stack Developer bei Discord " + salary + " Bäume verdient.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 5:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast in einer Grundschule Mathe unterrichtet und " + salary + " Bäume verdient.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 6:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast Minecraft nachprogrammiert und dafür " + salary + " Bäume erhalten.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 7:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast auf der Baustelle gearbeitet und somit " + salary + "Bäume verdient!")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 8:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast deiner Oma geholfen einen Virus von ihrem Gerät zu entfernen und verdienst dadurch " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 9:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du hast einem Kind geholfen die Leiter hochzuklettern, und verdienst somit " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 10:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du schreibst eine Zeitung und verdienst " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
            case 11:
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Erfolgreich gearbeitet")
                        .setDescription("Du teilst 22 Zeitungen aus und verdienst damit " + salary + " Bäume.")
                        .setColor(Color.MAGENTA)
                        .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                        .setTimestamp(Instant.now())
                        .build()).queue();
                break;
        }
        Speed.rethink.setMoney(event.getAuthor().getId(), Speed.rethink.getMoney(event.getAuthor().getId()) + salary);
        Speed.rethink.setWorkTime(Instant.now(), event.getAuthor().getId());
    }
}
