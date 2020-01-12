package com.bbn.speed.listener;

/*
 * @Author Skidder / GregTCLTK
 */

import com.bbn.speed.Speed;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class GuildListener extends ListenerAdapter {

    @Override
    public void onGuildJoin(@Nonnull GuildJoinEvent event) {
        Speed.rethink.insertGuild(event.getGuild().getId());
        super.onGuildJoin(event);
    }

    @Override
    public void onGuildLeave(@Nonnull GuildLeaveEvent event) {
        Speed.rethink.removeGuild(event.getGuild().getId());
        super.onGuildLeave(event);
    }
}
