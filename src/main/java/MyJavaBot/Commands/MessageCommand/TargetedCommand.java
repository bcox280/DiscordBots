package MyJavaBot.Commands.MessageCommand;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Blair on 18/07/2017.
 */
public abstract class TargetedCommand extends MessageCommand{

    public TargetedCommand(MessageReceivedEvent mEvent){

        super(mEvent);

    }

    @Override
    public final void execute() {

        String content = _message.getContent();
        String[] targets = content.split(" ");
        parseTarget(targets);

    }

    public abstract void parseTarget(String[] target);
}
