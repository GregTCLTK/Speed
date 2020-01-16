package com.bbn.speed.commands.misc;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.awt.*;
import java.time.Instant;

public class HelpCommand implements Command {

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
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
                .addField("?work", "Arbeitet um Geld zu verdienen.", true)
                .setColor(Color.GREEN)
                .setTimestamp(Instant.now())
                .build()).queue();
    }
}
