package MyJavaBot.Commands.MessageCommand;

import MyJavaBot.Commands.Commands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.MessageBuilder;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.EnumSet;

/**
 * Created by Blair on 17/07/2017.
 * This Commands Class will handle the creation of Roles in the discord server
 *
 */
public class CreateRoleCommand extends TargetedCommand{

    public static Commands cmd = Commands.CREATEROLES;
    public CreateRoleCommand(){



    }

    @Override
    public void parseTarget(String[] target) {

        int size = target.length;

        Color color;
        switch(size){
            case 3:

                try {
                    Field field = Class.forName("java.awt.Color").getField(target[1]);
                    color = (Color)field.get(null);
                    IRole role = _message.getGuild().createRole();
                    role.changeColor(color);
                    role.changeName(target[2]);
                    EnumSet<Permissions> perm = EnumSet.of(Permissions.READ_MESSAGES, Permissions.SEND_MESSAGES, Permissions.READ_MESSAGE_HISTORY, Permissions.ADD_REACTIONS);
                    role.changePermissions(perm);
                    new MessageBuilder(_mEvent.getClient()).appendContent("New Role " + target[2] + " Added" ).withChannel(_channel).build();
                } catch (Exception e) {
                    color = null; // Not defined
                    _error = true ;
                    new MessageBuilder(_mEvent.getClient()).appendContent("Not a used color").withChannel(_channel).build();
                }

                break;

            case 4:
                try {
                    Field field = Class.forName("java.awt.Color").getField(target[1]);
                    color = (Color)field.get(null);
                    IRole role2 = _message.getGuild().createRole();
                    role2.changeColor(color);
                    role2.changeName(target[2]);
                    EnumSet<Permissions> perm;
                    if(target[3].toLowerCase().equals("y") || target[3].toLowerCase().equals("yes")){

                        perm = EnumSet.allOf(Permissions.class);


                    }else{

                        perm = EnumSet.of(Permissions.READ_MESSAGES, Permissions.SEND_MESSAGES, Permissions.READ_MESSAGE_HISTORY, Permissions.ADD_REACTIONS);

                    }
                    role2.changePermissions(perm);
                    new MessageBuilder(_mEvent.getClient()).appendContent("New Role " + target[2] + " Added" ).withChannel(_channel).build();
                } catch (Exception e) {
                    color = null; // Not defined
                    _error = true ;
                    new MessageBuilder(_mEvent.getClient()).appendContent("Not a used color").withChannel(_channel).build();
                }

                break;

            default:
                new MessageBuilder(_mEvent.getClient()).appendContent("Improper Usage").withChannel(_channel).build();
                _error = true;
                break;
        }
        if(_error) {
            errorOccured(Commands.CREATEROLES);
        }

    }
}
