package com.bbn.speed.listener;

import com.bbn.speed.Speed;
import com.bbn.speed.core.GameAnimator;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReadyListener extends ListenerAdapter {

    @Override
    public void onReady(ReadyEvent event) {
        /*
        for (Guild g : event.getJDA().getGuilds()) {
            Speed.rethink.insertGuild(g.getId());
        }
        for (User u : event.getJDA().getUsers()) {
            Speed.rethink.insertUser(u.getId());
        } */
        System.out.println("Bot started!");
        new GameAnimator(event.getJDA()).start();
    }
}
