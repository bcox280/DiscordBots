package MyJavaBot.Modules;

import MyJavaBot.Commands.*;
import MyJavaBot.Modules.AbstractModule;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

/**
 * Created by Blair on 12/07/2017.
 */
public class MessageModule extends AbstractModule implements IListener<MessageReceivedEvent> {

    @Override
    public void handle(MessageReceivedEvent mEvent){


        IMessage message = mEvent.getMessage(); // Gets the message from the event object NOTE: This is not the content of the message, but the object itself
        IChannel channel = message.getChannel(); // Gets the channel in which this message was sent.
        try {
            // Builds (sends) and new message in the channel that the original [message was sent with the content of the original message.

            if(message.getContent().toLowerCase().startsWith(Commands.ADDROLES.toString())){//TODO some sort of refactoring? simple command usage, so executing every command wont require millions of lines

                new AddRoleCommand(mEvent).execute();

            }
            else if(message.getContent().toLowerCase().startsWith(Commands.CREATEROLES.toString())){

                new CreateRoleCommand(mEvent).execute();

            }else if(message.getContent().toLowerCase().startsWith(Commands.ROLES.toString())){

                new RoleListCommand(mEvent).execute();

            }else if(message.getContent().toLowerCase().startsWith(Commands.LISTCOMMANDS.toString())){

                new CommandsCommand(mEvent).execute();

            }


        } catch (RateLimitException e) { // RateLimitException thrown. The bot is sending messages too quickly!
            System.err.print("Sending messages too quickly!");
            e.printStackTrace();
        } catch (DiscordException e) { // DiscordException thrown. Many possibilities. Use getErrorMessage() to see what went wrong.
            System.err.print(e.getErrorMessage()); // Print the error message sent by Discord
            e.printStackTrace();
        } catch (MissingPermissionsException e) { // MissingPermissionsException thrown. The bot doesn't have permission to send the message!
            System.err.print("Missing permissions for channel!");
            e.printStackTrace();
        }

    }
    private void commandCheck(Commands command){



    }
}
