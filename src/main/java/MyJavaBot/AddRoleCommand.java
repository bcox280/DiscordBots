package MyJavaBot;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageBuilder;

/**
 * Created by Blair on 17/07/2017.
 */
public class AddRoleCommand extends MessageCommand{



    private boolean _addedRole = false;

    public AddRoleCommand(MessageReceivedEvent mEvent){

        super(mEvent);

    }

    @Override
    public void execute() {

        if (_message.getMentions().size() >  0){


            String[] words = _message.getContent().split(" ");
            IUser user = _message.getMentions().get(0);


            if(_mEvent.getGuild().getUsers().contains(user)) {

                if (words.length > 2) {

                    String roleName = words[2]; //Only allows 1 word role names
                    System.out.println(words[2]);
                    for (IRole iR : _mEvent.getGuild().getRolesByName(roleName)) {

                        _addedRole = true;
                        user.addRole(iR);
                        new MessageBuilder(_mEvent.getClient()).appendContent("Added Role " + words[2] + " to " + user.getName()).withChannel(_channel).build();

                    }
                    if(!_addedRole){
                        _error = true;
                    }
                } else {

                    _error = true;
                    new MessageBuilder(_mEvent.getClient()).appendContent("Please Specify Role").withChannel(_channel).build();

                }
            }

        }else{

            _error = true;
            new MessageBuilder(_mEvent.getClient()).appendContent("User Not Found, Please Mention User").withChannel(_channel).build();

        }
        if(_error){


            new MessageBuilder(_mEvent.getClient()).appendContent("Proper Usage: !add <MentionedUser> <Role>").withChannel(_channel).build();

        }

    }

    @Override
    public void errorOccured() {

    }
}
