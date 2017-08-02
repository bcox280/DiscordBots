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


import MyJavaBot.Modules.JoinModule;
import MyJavaBot.Modules.MessageModule;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.obj.IPrivateChannel;

/**
 * A mod bot that will handle all moderation of a server
 * Author = Blair Cox
 * Thanks to Discord4J for the API
 */
public class ModBot extends SimpleBot implements IListener {


    public ModBot(String token) {
        super(token);
        EventDispatcher dispatcher = _client.getDispatcher(); // Gets the client's event dispatcher

        //Use the modular approach to add mods that can be added to other bots if needed, will be useful in the future
        dispatcher.registerListener(this); // Registers this bot as an event listener
        dispatcher.registerListener(new MessageModule()); // Handles all message commands
        dispatcher.registerListener(new JoinModule()); // Handles the joining of users

        //Create a record of the guilds and all the roles in them



    }



    @Override
    public void handle(Event event) {



        _client.changePlayingText("Adding Functionality");

    }
}
