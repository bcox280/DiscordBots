package MyJavaBot;

import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Blair on 17/07/2017.
 */
public abstract class BaseCommand {

    protected Event _event;
    protected boolean _error = false;

    public BaseCommand(Event event){

        _event = event;

    }
    public abstract void execute();
    public abstract void errorOccured();


}
