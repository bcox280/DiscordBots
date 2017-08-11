package MyJavaBot.Commands.MessageCommand;

import MyJavaBot.Commands.BaseCommand;
import MyJavaBot.Commands.Commands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.MessageBuilder;

/**
 * Created by Blair on 17/07/2017.
 */
public abstract class MessageCommand extends BaseCommand {

    protected IMessage _message;
    protected IChannel _channel;
    protected MessageReceivedEvent _mEvent;

    public MessageCommand(MessageReceivedEvent mEvent){

        super(mEvent);
        _mEvent = mEvent;
        _message = mEvent.getMessage();
        _channel = mEvent.getChannel();

    }

    public void errorOccured(Commands command) {

        new MessageBuilder(_mEvent.getClient()).appendContent("Proper Usage: " + command.usage()).withChannel(_channel).build();

    }


}
