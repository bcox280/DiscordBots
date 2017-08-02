package MyJavaBot.Modules;

import MyJavaBot.Commands.*;
import MyJavaBot.Modules.AbstractModule;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blair on 12/07/2017.
 */
public class MessageModule extends AbstractModule implements IListener<MessageReceivedEvent> {


    private MessageReceivedEvent _mEvent;

    @Override
    public void handle(MessageReceivedEvent mEvent) {


        boolean admin = false;
        _mEvent = mEvent;
        IMessage message = mEvent.getMessage(); // Gets the message from the event object NOTE: This is not the content of the message, but the object itself
        IChannel channel = message.getChannel(); // Gets the channel in which this message was sent.
        try {

            String msg = (message.getContent().toLowerCase());

            for(IRole iR: message.getAuthor().getRolesForGuild(message.getGuild())) {

                if (iR.getName().toLowerCase().equals("admin")) {

                    admin = true;

                }
            }
            if(admin) {
                adminCommands(msg);
            }
            admin = false;


            userCommands(msg);

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

    private void commandCheck(Commands command) {


    }

    private void adminCommands(String msg) {
        BaseCommand cmd = null;
        if (msg.startsWith(Commands.ADDROLES.toString())) {//TODO some sort of refactoring? simple command usage, so executing every command wont require millions of lines

            cmd = new AddRoleCommand(_mEvent);

        } else if (msg.startsWith(Commands.CREATEROLES.toString())) {

            cmd = new CreateRoleCommand(_mEvent);

        }else if (msg.startsWith(Commands.DELROLE.toString())) {

            cmd = new DelRoleCommand(_mEvent);

        }
        if (cmd != null) {
            cmd.execute();
        }

    }

    private void userCommands(String msg) {

        BaseCommand cmd = null;
        if (msg.startsWith(Commands.LISTCOMMANDS.toString())) {

            cmd = new CommandsCommand(_mEvent);

        } else if (msg.startsWith(Commands.DEFINE.toString())) {

            cmd = new DefineCommand(_mEvent);

        }else if (msg.startsWith(Commands.ROULETTE.toString())) {

                cmd = new RouletteCommand(_mEvent);

        } else if (msg.startsWith(Commands.D20.toString())) {

                cmd = new D20Command(_mEvent);

        } else if (msg.startsWith(Commands.BAN.toString())) {

                cmd = new BanCommand(_mEvent);

        } else if (msg.startsWith(Commands.ROLES.toString())) {

            cmd = new RoleListCommand(_mEvent);


        }
        if (cmd != null) {
            cmd.execute();
        }

        }
    }

