package com.bbn.speed;

import com.bbn.speed.commands.fun.*;
import com.bbn.speed.commands.global.*;
import com.bbn.speed.commands.misc.*;
import com.bbn.speed.commands.moderation.*;
import com.bbn.speed.commands.money.*;
import com.bbn.speed.core.*;
import com.bbn.speed.listener.*;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;

import javax.security.auth.login.LoginException;

public class Speed {

    public static Rethink rethink = new Rethink();

    public static void main(String[] Args) {

        rethink.connect();

        DefaultShardManagerBuilder builder = new DefaultShardManagerBuilder();
        builder.setToken(SECRETS.Token);
        builder.addEventListeners(
                new ReadyListener(),
                new CommandListener(),
                new GlobalListener(),
                new GuildListener(),
                new UserListener());
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
        CommandHandler.commands.put("stats", new StatsCommand());
        CommandHandler.commands.put("add", new AddCommand());
        CommandHandler.commands.put("give", new GiveCommand());
        CommandHandler.commands.put("remove", new RemoveCommand());
        CommandHandler.commands.put("setglobal", new SetGlobalCommand());
        CommandHandler.commands.put("removeglobal", new RemoveGlobalCommand());
        CommandHandler.commands.put("globalmute", new GlobalMuteCommand());
        CommandHandler.commands.put("addteam", new AddTeamCommand());
        CommandHandler.commands.put("removeteam", new RemoveTeamCommand());
        CommandHandler.commands.put("daily", new DailyCommand());
        CommandHandler.commands.put("work", new WorkCommand());
        CommandHandler.commands.put("shop", new ShopCommand());
        CommandHandler.commands.put("buy", new BuyCommand());

        try {
            builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
