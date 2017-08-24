package MyJavaBot.Modules;

import MyJavaBot.Commands.VoiceCommand.AudioCommand;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.voice.VoiceChannelEvent;
import sx.blah.discord.handle.impl.events.guild.voice.user.UserSpeakingEvent;

public class VoiceModule extends AbstractModule implements IListener<UserSpeakingEvent> {
    @Override
    public void handle(UserSpeakingEvent usEvent) {

        AudioCommand cmd = new AudioCommand();
        cmd.execute();

    }
}
