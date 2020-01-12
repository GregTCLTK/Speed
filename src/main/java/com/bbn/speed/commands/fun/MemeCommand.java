package com.bbn.XZerkrypter.commands.fun;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.XZerkrypter.XZerkrypter;
import com.bbn.XZerkrypter.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;
import java.time.Instant;

public class MemeCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        if (XZerkrypter.rethink.isBotPremium(event.getAuthor().getId())) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url("https://some-random-api.ml/meme").build();

            try {
                Response response = client.newCall(request).execute();
                JSONObject json = new JSONObject(response.body().string());
                String url = json.get("image").toString();
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Dein Meme")
                        .setImage(url)
                        .setColor(Color.GREEN)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            } catch (IOException e) {
                e.printStackTrace();
                event.getTextChannel().sendMessage(new EmbedBuilder()
                        .setTitle("Fehler!")
                        .setDescription("Die Anfrage an die Meme API ist fehlgeschlagen. Bitte kontaktiere Skidder#6775 auf Discord.")
                        .setColor(Color.RED)
                        .setTimestamp(Instant.now())
                        .build()).queue();
            }
        } else {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Kein Bot Plus")
                    .setDescription("Du benötigst den Bot Plus Status um diesen Command ausführen zu können.")
                    .setColor(Color.RED)
                    .setTimestamp(Instant.now())
                    .build()).queue();
        }
    }
}
