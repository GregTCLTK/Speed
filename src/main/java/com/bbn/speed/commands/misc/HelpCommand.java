package com.bbn.speed.commands.misc;

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

public class HelpCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_MANAGE) && event.getGuild().getSelfMember().hasPermission(Permission.MESSAGE_ADD_REACTION)) {
            event.getTextChannel().sendMessage(new EmbedBuilder()
                    .setTitle("Hilfe")
                    .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .build()).queue((message -> {
                message.addReaction(1 + "\u20E3").queue();
                message.addReaction(2 + "\u20E3").queue();
                message.addReaction(3 + "\u20E3").queue();
                message.addReaction(4 + "\u20E3").queue();
                Speed.rethink.setHelp(message.getId());
            }));
        } else {
            event.getAuthor().openPrivateChannel().complete().sendMessage(new EmbedBuilder()
                    .setTitle("Hilfe")
                    .setDescription("Bitte wähle die Kategorie zu der du Hilfe benötigst.\n\n:one: Moderation\n:two: Money\n:three: Fun\n:four: Global")
                    .setColor(Color.GREEN)
                    .setTimestamp(Instant.now())
                    .build()).queue((message -> {
                message.addReaction(1 + "\u20E3").queue();
                message.addReaction(2 + "\u20E3").queue();
                message.addReaction(3 + "\u20E3").queue();
                message.addReaction(4 + "\u20E3").queue();
                Speed.rethink.setHelp(message.getId());
            }));
        }
        /*
        event.getTextChannel().sendMessage(new EmbedBuilder()
                .setTitle("Hilfe")
                .addField("?unmute", "Entmutet einen Benutzer", true)
                .addField("?mute", "Mutet einen Benutzer", true)
                .addField("?unban", "Entbannt einen Benutzer", true)
                .addField("?kick", "Kickt einen Benutzer", true)
                .addField("?ban", "Bannt einen Benutzer", true)
                .addField("?clear 99", "Löscht die angegebene Anzahl von Nachrichten", true)
                .addField("?meme", "Sendet ein zufälliges Meme", true)
                .addField("?selbstzerstörung", "Leitet die Selbstzerstörung ein", true)
                .addField("?lotto", "Gibt die die Chance Premium oder Bot Plus zu gewinnen", true)
                .addField("?stats", "Zeigt deine Stats an", true)
                .addField("?add", "Gibt einem Benutzer Bäume (Nur für Klötchengrafik)", true)
                .addField("?remove", "Entfernt einem Benutzer Bäume (Nur für Klötchengrafik)", true)
                .addField("?give", "Gibt einem anderem Benutzer eine bestimmte Anzahl von Bäumen", true)
                .addField("?setglobal", "Legt den Channel für den globalen Chat fest", true)
                .addField("?removeglobal", "Entfernt den Channel für den globalen Chat", true)
                .addField("?globalmute", "Schaltet User für den globalen Chat stumm", true)
                .addField("?addteam", "Fügt User dem Team hinzu", true)
                .addField("?removeteam", "Entfernt User aus dem Team", true)
                .addField("?work", "Arbeitet um Geld zu verdienen", true)
                .addField("?shop", "Zeigt den aktuellen Shop an", true)
                .addField("?buy", "Kauft einen Gegenstand aus dem Shop", true)
                .addField("?serverban", "Schaltet Server für den globalen Chat stumm", true)
                .addField("?rob", "Raubt den angegebenen User aus", true)
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .build()).queue();
         */
    }
}
