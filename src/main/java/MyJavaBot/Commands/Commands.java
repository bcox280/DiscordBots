package MyJavaBot.Commands;

/**
 * Created by Blair on 12/07/2017.
 * This enum has a few functionalities, it allows for the command Name, what the command needed to access it,
 * and its usage which is used for error messages, may add a description later on when
 * listing all commands
 */
public enum Commands {
    ROLES("roles","!roles <MentionedUser> or !roles", "Lists Roles for a Server or a User"),
    ADDROLES("add","!add <MentionedUser> <Role>", "Adds a Mentioned User to a Role"),
    CREATEROLES("createrole", "!createRole <RoleName>", "Creates a new Role"),
    LISTCOMMANDS("commands", "!commands", "Lists all Commands");

    private String commandName;
    private String commandUsage;
    private String commandDescription;

    Commands(String name, String usage, String description){

        commandName = name;
        commandUsage = usage;
        commandDescription = description;

    }
    @Override
    public String toString(){


        return ("!" + commandName);//Outputs the way to access the command

    }

    public String usage(){

        return commandUsage;//Outputs the description

    }

    public String description(){

        return commandDescription;

    }
}
