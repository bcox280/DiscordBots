package MyJavaBot.Commands.VoiceCommand;

import MyJavaBot.Commands.BaseCommand;
import MyJavaBot.Commands.Commands;
import sx.blah.discord.api.events.Event;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.impl.events.guild.voice.user.UserSpeakingEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IVoiceChannel;
import sx.blah.discord.util.audio.events.AudioPlayerEvent;

import static org.apache.commons.lang3.StringUtils.join;

public class AudioCommand extends BaseCommand {


    UserSpeakingEvent _uevent;

    public AudioCommand( ){


    }

    public void execute() {




    }

    @Override
    public void errorOccured(Commands command) {

    }
}
