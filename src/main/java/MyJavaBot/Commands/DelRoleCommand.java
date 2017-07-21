package MyJavaBot.Commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IRole;

import java.util.List;

/**
 * Created by Blair on 21/07/2017.
 */
public class DelRoleCommand extends TargetedCommand{

    public DelRoleCommand(MessageReceivedEvent mEvent) {

        super(mEvent);

    }

    @Override
    public void parseTarget(String[] target) {

        List<IRole> roleList;
        if(target.length == 2){

            if(( (roleList = _message.getGuild().getRolesByName(target[1])).size())>0){

                for(IRole iR: roleList){

                    iR.delete();

                }


            }

        }else{

            _error = true;

        }

        if(_error){

            errorOccured(Commands.DELROLE);

        }
    }

}
