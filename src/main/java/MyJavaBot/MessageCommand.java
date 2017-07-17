package MyJavaBot;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;

/**
 * Created by Blair on 17/07/2017.
 */
public abstract class MessageCommand extends BaseCommand{

    protected IMessage _message;
    protected IChannel _channel;
    protected MessageReceivedEvent _mEvent;

    public MessageCommand(MessageReceivedEvent mEvent){

        super(mEvent);
        _mEvent = mEvent;
        _message = mEvent.getMessage();
        _channel = mEvent.getChannel();

    }


}
