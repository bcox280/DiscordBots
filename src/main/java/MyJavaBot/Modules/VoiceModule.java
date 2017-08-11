package MyJavaBot.Modules;

import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.voice.VoiceChannelEvent;

public class VoiceModule extends AbstractModule implements IListener<VoiceChannelEvent> {
    @Override
    public void handle(VoiceChannelEvent voiceChannelEvent) {

    }
}
