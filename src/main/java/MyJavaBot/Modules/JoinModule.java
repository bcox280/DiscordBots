package MyJavaBot.Modules;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MissingPermissionsException;

import java.util.List;

/**
 * Created by Blair on 12/07/2017.
 */
public class JoinModule extends AbstractModule implements IListener<UserJoinEvent> {


    @Override
    public void handle(UserJoinEvent event){


        try {

            IUser user = event.getUser();
            IGuild guild = event.getGuild();
            List<IRole> roleList = guild.getRolesByName("Unassigned");

            for(IRole i: roleList){



                    user.addRole(i);
                    break;

                }



        } catch (DiscordException e) { // DiscordException thrown. Many possibilities. Use getErrorMessage() to see what went wrong.
            System.err.print(e.getErrorMessage()); // Print the error message sent by Discord
            e.printStackTrace();
        } catch (MissingPermissionsException e) { // MissingPermissionsException thrown. The bot doesn't have permission to send the message!
            System.err.print("Missing permissions for channel!");
            e.printStackTrace();
        }

    }
}