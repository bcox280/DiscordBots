package MyJavaBot.Commands;

import sx.blah.discord.api.events.Event;

/**
 * Created by Blair on 17/07/2017.
 */
public abstract class BaseCommand {
    public static  Commands _cmd;
    public static boolean _admin = false;
    protected Event _event;
    protected boolean _error = false;


    public BaseCommand(){



    }
    public abstract void errorOccured(Commands command);




}
