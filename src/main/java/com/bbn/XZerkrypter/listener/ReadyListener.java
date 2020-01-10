package com.bbn.XZerkrypter.listener;

import com.bbn.XZerkrypter.XZerkrypter;
import com.bbn.XZerkrypter.core.GameAnimator;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        /*
        for (Guild g : event.getJDA().getGuilds()) {
            XZerkrypter.rethink.insertGuild(g.getId());
        }
        for (User u : event.getJDA().getUsers()) {
            XZerkrypter.rethink.insertUser(u.getId());
        } */
        System.out.println("Bot started!");
        new GameAnimator(event.getJDA()).start();
    }
}
