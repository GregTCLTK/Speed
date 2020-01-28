package com.bbn.speed.commands.fun;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class SelbstzerstoerungCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (Speed.rethink.isBotPremium(event.getAuthor().getId())) {
            boolean random = Math.random() < 0.50;
            Message msg = event.getTextChannel().sendMessage("Leite Selbstzerstörung ein in 5... :bomb:").complete();
            e(msg);
            if (random) {
                a(msg, "BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm, das hat irgendwie nicht so geklappt,");
                msg.editMessage("BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm, das hat irgendwie nicht so geklappt, ich bin noch da...").queue();
            } else {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                msg.editMessage("BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm, im Kino").queue();
                a(msg, "BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm, im Kino kam das irgendwie cooler rüber... ");
                msg.editMessage("BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm, im Kino kam das irgendwie cooler rüber... https://tenor.com/uDdW.gif").queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Kein Bot Plus")
                    .setDescription("Du benötigst den Bot Plus Status um diesen Command ausführen zu können.")
                    .setColor(Color.RED)
                    .setFooter("Speed", "https://cdn.discordapp.com/avatars/648542896269819906/4bd3ff019e6107a65f8e96d6d9de7983.png")
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }

    private void a(Message msg, String s) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage(s).queue();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void e(Message msg) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("Leite Selbstzerstörung ein in 4... :bomb:").queue();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("Leite Selbstzerstörung ein in 3... :bomb:").queue();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("Leite Selbstzerstörung ein in 2... :bomb:").queue();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("Leite Selbstzerstörung ein in 1... :bomb:").queue();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("BOOOOOM!!! :boom::boom::boom:").queue();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        msg.editMessage("BOOOOOM!!! :boom::boom::boom: \n\n Hmmmm,").queue();
    }
}
