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
import sx.blah.discord.util.DiscordException;

/**
 * This represents a SUPER basic bot (literally all it does is login).
 * This is used as a base for all example bots.
 */
public class SimpleBot {


    public IDiscordClient _client; // The instance of the discord client.


    public SimpleBot(String token) {
        if (token.length() < 1) { // Needs a bot token provided
            throw new IllegalArgumentException("This bot needs at least 1 argument!");
        }


        ClientBuilder builder = new ClientBuilder(); // Creates a new client builder instance
        builder.withToken(token); // Sets the bot token for the client
        try {
            IDiscordClient client = builder.login(); // Builds the IDiscordClient instance and logs it in
            _client = client; // Creating the bot instance

        } catch (DiscordException e) { // Error occurred logging in
            System.err.println("Error occurred while logging in!");
            e.printStackTrace();
        }


    }
}
