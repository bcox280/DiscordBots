package MyJavaBot.Commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Blair on 17/07/2017.
 * This Commands Class will handle the creation of Roles in the discord server
 *
 */
public class CreateRoleCommand extends MessageCommand{

    public CreateRoleCommand(MessageReceivedEvent mEvent){

        super(mEvent);

    }

    @Override
    public void execute() {

    }
}
