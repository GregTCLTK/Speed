package com.bbn.XZerkrypter;

import com.bbn.XZerkrypter.commands.fun.*;
import com.bbn.XZerkrypter.commands.misc.*;
import com.bbn.XZerkrypter.commands.moderation.*;
import com.bbn.XZerkrypter.core.*;
import com.bbn.XZerkrypter.listener.*;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

import javax.security.auth.login.LoginException;
import java.util.HashMap;

public class XZerkrypter {

    public static HashMap<User, Long> times = new HashMap<>();
    public static Rethink rethink = new Rethink();

    public static void main(String[] Args) {

        rethink.connect();

        DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
        builder.setToken(SECRETS.Token);
        builder.addEventListeners(new ReadyListener(), new CommandListener());
        builder.setAutoReconnect(true);

        CommandHandler.commands.put("ban", new BanCommand());
        CommandHandler.commands.put("kick", new KickCommand());
        CommandHandler.commands.put("clear", new ClearCommand());
        CommandHandler.commands.put("unban", new UnbanCommand());
        CommandHandler.commands.put("mute", new MuteCommand());
        CommandHandler.commands.put("unmute", new UnmuteCommand());
        CommandHandler.commands.put("meme", new MemeCommand());
        CommandHandler.commands.put("lotto", new LottoCommand());
        CommandHandler.commands.put("help", new HelpCommand());
        CommandHandler.commands.put("selbstzerstörung", new SelbstzerstoerungCommand());
        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
