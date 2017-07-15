package MyJavaBot;
/*
 *     This file is part of Discord4J.
 *
 *     Discord4J is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Discord4J is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */


import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * An example to demonstrate event listening and message sending.
 * It will repeat everything said in a channel.
 */
public class ModBot extends SimpleBot implements IListener {

    protected List<IGuild> guildList = new LinkedList<>();
    protected HashMap<IGuild, List<IRole>> roleMap = new HashMap<>();

    public ModBot(String token) {
        super(token);
        EventDispatcher dispatcher = _client.getDispatcher(); // Gets the client's event dispatcher
        dispatcher.registerListener(this); // Registers this bot as an event listener
        dispatcher.registerListener(new MessageModule());
        dispatcher.registerListener(new JoinModule());

        //Create a record of the guilds and all the roles in them
        guildList = _client.getGuilds();
        for (int i = 0; i < guildList.size(); i++) {

            roleMap.put(guildList.get(i), guildList.get(i).getRoles());

        }

        _client.changePlayingText("Fixing Bugs");
    }


    /**
     * Called when the client receives a message.
     */
    @Override
    public void handle(Event event) {


    }
}
