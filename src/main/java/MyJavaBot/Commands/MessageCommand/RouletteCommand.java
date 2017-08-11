package MyJavaBot.Commands.MessageCommand;

import MyJavaBot.Commands.Commands;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.util.MessageBuilder;

import java.util.Random;
/**
 * Created by Blair on 21/07/2017.
 */
public class RouletteCommand extends TargetedCommand {

    public static Commands cmd = Commands.ROULETTE;

    public RouletteCommand(MessageReceivedEvent mEvent) {

        super(mEvent);

    }

    @Override
    public void parseTarget(String[] target) {


        if(_message.getMentions().size() == 1){
            roulette(_message.getMentions().get(0));


        }else if(target.length == 1 && target[0].length() == 9){
            roulette(_message.getAuthor());





        }else{

            _error = true;

        }

        if (_error){


            errorOccured(Commands.ROULETTE);

        }

    }
    private void roulette( IUser user){
        new MessageBuilder(_mEvent.getClient()).appendContent("The Chamber is loaded and spun").withChannel(_channel).build();
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        if(n == 1){

            new MessageBuilder(_mEvent.getClient()).appendContent(user.mention() + " Shot himself/herself").withChannel(_channel).build();

        }else{

            new MessageBuilder(_mEvent.getClient()).appendContent(user.mention() + " Survived the Roulette").withChannel(_channel).build();

        }



    }
}
