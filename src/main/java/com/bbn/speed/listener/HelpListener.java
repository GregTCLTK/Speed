package com.bbn.speed.listener;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.time.Instant;

public class HelpListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(@Nonnull MessageReactionAddEvent event) {
        if (Speed.rethink.isHelp(event.getMessageId()) && !event.getUser().isBot()) {
            switch (event.getReactionEmote().getEmoji()) {
                case 1 + "\u20E3":
                    event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                            .setTitle("Hilfe")
                            .setDescription("Hier siehst du alle Befehle der Moderation")
                            .addField("?unmute", "Entmutet einen Benutzer", true)
                            .addField("?mute", "Mutet einen Benutzer", true)
                            .addField("?unban", "Entbannt einen Benutzer", true)
                            .addField("?kick", "Kickt einen Benutzer", true)
                            .addField("?ban", "Bannt einen Benutzer", true)
                            .addField("?clear", "Löscht die angegebene Anzahl von Nachrichten", true)
                            .setColor(Color.GREEN)
                            .setTimestamp(Instant.now())
                            .build()).queue((message) -> {
                        message.clearReactions().queue();
                        message.addReaction("⏪").queue();
                    });
                    break;
                case 2 + "\u20E3":
                    event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                            .setTitle("Hilfe")
                            .setDescription("Hier siehst du alle Befehle welche mit dem Geldsystem zu tun haben")
                            .addField("?stats", "Zeigt deine Stats an", true)
                            .addField("?give", "Gibt einem anderem Benutzer eine bestimmte Anzahl von Bäumen", true)
                            .addField("?work", "Arbeitet um Geld zu verdienen", true)
                            .addField("?shop", "Zeigt den aktuellen Shop an", true)
                            .addField("?buy", "Kauft einen Gegenstand aus dem Shop", true)
                            .addField("?rob", "Raubt den angegebenen User aus", true)
                            .addField("?lotto", "Gibt die die Chance Premium oder Bot Plus zu gewinnen", true)
                            .addField("?add", "Gibt einem Benutzer Bäume (Nur für Klötchengrafik)", true)
                            .addField("?remove", "Entfernt einem Benutzer Bäume (Nur für Klötchengrafik)", true)
                            .setColor(Color.GREEN)
                            .setTimestamp(Instant.now())
                            .build()).queue((message) -> {
                        message.clearReactions().queue();
                        message.addReaction("⏪").queue();
                    });
                    break;
                case 3 + "\u20E3":
                    event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                            .setTitle("Hilfe")
                            .setDescription("Hier siehst du alle Fun Befehle")
                            .addField("?meme", "Sendet ein zufälliges Meme", true)
                            .addField("?selbstzerstörung", "Leitet die Selbstzerstörung ein", true)
                            .setColor(Color.GREEN)
                            .setTimestamp(Instant.now())
                            .build()).queue((message) -> {
                        message.clearReactions().queue();
                        message.addReaction("⏪").queue();
                    });
                    break;
                case 4 + "\u20E3":
                    event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                            .setTitle("Hilfe")
                            .addField("?setglobal", "Legt den Channel für den globalen Chat fest", true)
                            .addField("?removeglobal", "Entfernt den Channel für den globalen Chat", true)
                            .addField("?globalmute", "Schaltet User für den globalen Chat stumm", true)
                            .addField("?serverban", "Schaltet Server für den globalen Chat stumm", true)
                            .setColor(Color.GREEN)
                            .setTimestamp(Instant.now())
                            .build()).queue((message) -> {
                        message.clearReactions().queue();
                        message.addReaction("⏪").queue();
                    });
                    break;
                case "⏪":
                    event.getTextChannel().retrieveMessageById(event.getMessageId()).complete().editMessage(new EmbedBuilder()
                            .setTitle("Hilfe")
                            .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                            .setColor(Color.GREEN)
                            .setTimestamp(Instant.now())
                            .build()).queue((message -> {
                        message.clearReactions().queue();
                        message.addReaction(1 + "\u20E3").queue();
                        message.addReaction(2 + "\u20E3").queue();
                        message.addReaction(3 + "\u20E3").queue();
                        message.addReaction(4 + "\u20E3").queue();
                        Speed.rethink.setHelp(message.getId());
                    }));
                    break;
            }
        }
        super.onMessageReactionAdd(event);
    }
}
