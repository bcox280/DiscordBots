package MyJavaBot.Commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageBuilder;

import java.util.List;

/**
 * Created by Blair on 17/07/2017.
 * This Commands will list out all roles for a given server or for a given user, but not more than one
 * This command has nothing to do with the creation of roles
 */
public class RoleListCommand extends MessageCommand{

    public RoleListCommand(MessageReceivedEvent mEvent){

        super(mEvent);//Call Parent Constructor
    }

    @Override
    public void execute() {



        if(_mEvent.getMessage().getMentions().size() == 1){//Checks if there is 1 mention in the command

            for(IUser IU: _mEvent.getMessage().getMentions()){

                outputRoles(IU.getRolesForGuild(_mEvent.getGuild()));//Puts it in the method to output all the roles

            }

        }else if (_mEvent.getMessage().getMentions().size() < 1 && _mEvent.getMessage().getContent().length() <  8) { // Only calls if their are no mentions, just the command

            outputRoles(_mEvent.getGuild().getRoles());//Calls the output of all roles on where the message occures


        }else{

            _error = true;//Else if these cases arent correct, usage mustnt be correct
        }

        if(_error){

            //Calls the errorOccured method if an error occured, check the parent MessageCommand to check usage
            errorOccured(Commands.ROLES);

        }

    }

    private void outputRoles(List<IRole> listofRoles){ // To refactor the code, so both guild and user can use the same method

        String RoleList = "";
        for (IRole iR : listofRoles ) {

            RoleList += iR.getName() + "\t";

        }

        new MessageBuilder(_mEvent.getClient()).appendContent(RoleList).withChannel(_channel).build();

    }
}
