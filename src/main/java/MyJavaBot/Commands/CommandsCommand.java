package MyJavaBot.Commands;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MessageBuilder;

/**
 * Created by Blair on 17/07/2017.
 */
public class CommandsCommand extends MessageCommand {


    public CommandsCommand(MessageReceivedEvent mEvent){

        super(mEvent);

    }
    @Override
    public void execute() {

        String commandString = "";
        if(_mEvent.getMessage().getContent().length() == 9) {
            for (Commands com : Commands.values()) {

                commandString += com.usage() + ":\t" + com.description() + "\n";

            }
            new MessageBuilder(_mEvent.getClient()).appendContent(commandString).withChannel(_channel).build();
        }else{
            errorOccured(Commands.LISTCOMMANDS);
        }

    }

}
