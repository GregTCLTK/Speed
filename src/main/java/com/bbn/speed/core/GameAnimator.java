package com.bbn.XZerkrypter.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Activity;

public class GameAnimator {

    private JDA jda;

    public GameAnimator(JDA jda) {
        this.jda = jda;
    }

    public void start() {
        Thread t = new Thread(() -> {
            String[] gameAnimations = new String[]{"auf SPEED | ?help ", "mit %u Usern"};
            int currentGame = 0;
            long last = 0;
            while (true) {
                if (System.currentTimeMillis() >= last + 60000) {
                    jda.getShardManager().setActivity(Activity.playing(gameAnimations[currentGame].replace("%u", String.valueOf(jda.getUsers().size()))));
                    if (currentGame == gameAnimations.length - 1) {
                        currentGame = 0;
                    } else {
                        currentGame += 1;
                    }
                    last = System.currentTimeMillis();
                }

            }
        });
        t.setName("GameAnimator");
        t.start();
    }

}
