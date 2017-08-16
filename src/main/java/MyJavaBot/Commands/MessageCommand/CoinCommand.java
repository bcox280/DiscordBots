package MyJavaBot.Commands.MessageCommand;

import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MessageBuilder;

import java.util.Random;

public class CoinCommand extends MessageCommand{

    public CoinCommand(MessageReceivedEvent mEvent) {
        super(mEvent);
    }

    @Override
    public void execute() {

        Random rand = new Random();
        int  n = rand.nextInt(2) + 1;
        if(n == 1){

            new MessageBuilder(_mEvent.getClient()).appendContent("Heads").withChannel(_channel).build();

        }else{

            new MessageBuilder(_mEvent.getClient()).appendContent("Tails").withChannel(_channel).build();

        }


    }
}
