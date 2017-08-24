package MyJavaBot.Commands.MessageCommand;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IUser;

import java.util.List;

/**
 * Created by Blair on 21/07/2017.
 */
public class BanCommand extends TargetedCommand {


    public BanCommand(){
    }

    @Override
    public void parseTarget(String[] target) {

        List<IUser> userBan;
        if((userBan =_message.getMentions()).size()==1 && target.length > 2){



            _message.getGuild().banUser(userBan.get(0));

        }

    }
}
