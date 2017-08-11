package MyJavaBot.Commands.VoiceCommand;

import MyJavaBot.Commands.BaseCommand;
import MyJavaBot.Commands.Commands;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.util.audio.events.AudioPlayerEvent;

public class AudioCommand extends BaseCommand {


    public AudioCommand(Event event){

        super(event);
    }
    @Override
    public void execute() {

    }

    @Override
    public void errorOccured(Commands command) {

    }
}
