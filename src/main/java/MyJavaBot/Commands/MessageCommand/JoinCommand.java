package MyJavaBot.Commands.MessageCommand;

import MyJavaBot.Commands.Commands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageBuilder;

import static jdk.nashorn.internal.objects.NativeArray.join;


public class JoinCommand extends MessageCommand{

    public JoinCommand() {

    }

    IMessage message = _mEvent.getMessage();
    IUser user = message.getAuthor();
    IGuild guild = message.getGuild();

    public void execute() {

        if (user.getVoiceStateForGuild(guild).getChannel() != null ){

                user.getVoiceStateForGuild(guild).getChannel().join();
        }else{


            new MessageBuilder(_mEvent.getClient()).appendContent("You are not in a voice channel").withChannel(_channel).build();
            errorOccured(Commands.JOIN);

        }

    }
}
