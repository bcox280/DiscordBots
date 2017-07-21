package MyJavaBot.Commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Blair on 21/07/2017.
 */
public class BanCommand extends TargetedCommand {


    public BanCommand(MessageReceivedEvent mEvent) {
        super(mEvent);
    }

    @Override
    public void parseTarget(String[] target) {

    }
}
