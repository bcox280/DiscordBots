package MyJavaBot.Commands.MessageCommand;

import MyJavaBot.Commands.Commands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.util.MessageBuilder;

import java.util.Random;
/**
 * Created by Blair on 21/07/2017.
 */
public class D20Command extends MessageCommand {

    protected static final Commands cmd = Commands.D20;

    public D20Command() {



    }

    public void execute() {

            if(_message.getContent().length() == 4){

                Random rand = new Random();
                int  n = rand.nextInt(20) + 1;
                switch(n){
                    case 1:

                        new MessageBuilder(_mEvent.getClient()).appendContent("Critical Failure!").withChannel(_channel).build();
                        break;

                    case 20:

                        new MessageBuilder(_mEvent.getClient()).appendContent("Critical Success!").withChannel(_channel).build();
                        break;

                    default:


                        break;


                }
                new MessageBuilder(_mEvent.getClient()).appendContent("Rolled a " + n).withChannel(_channel).build();


            }else{

                _error = true;


            }

            if (_error){

                errorOccured(Commands.D20);

            }


    }
}
