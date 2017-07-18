package MyJavaBot.Commands;

import sx.blah.discord.api.events.Event;

/**
 * Created by Blair on 18/07/2017.
 */
public abstract class TargetedCommand extends BaseCommand{

    public TargetedCommand(Event event){

        super(event);

    }

    @Override
    public final void execute() {


    }

    public abstract void parseTarget(String[] target);
}
