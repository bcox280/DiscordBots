package MyJavaBot.Commands;

import MyJavaBot.Commands.MessageCommand.*;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;

/**
 * Created by Blair on 12/07/2017.
 * This enum has a few functionalities, it allows for the command Name, what the command needed to access it,
 * and its usage which is used for error messages, may add a description later on when
 * listing all commands
 */
public enum Commands {
    //Roles
    ROLES("roles","!roles <MentionedUser> or !roles", "Lists Roles for a Server or a User", new RoleListCommand()),
    ADDROLES("add","!add <MentionedUser> <Role>", "Adds a Mentioned User to a Role", new AddRoleCommand()),
    CREATEROLES("createrole", "!createRole <Color> <RoleName> <Admin?>", "Creates a new Role", new CreateRoleCommand()),
    DEFINE("define", "!define <Word>", "Defines a Given Word", new DefineCommand()),
    DELROLE("delrole", "!delRole <RoleName>", "Deletes a given role", new DelRoleCommand()),
    CHANGEPERMISSIONS("chgperm", "!chgPerm <User> <Perm> or !ChgPerm <Role> <Perm>",
            "Changes permissions for a given role or user", new RoleListCommand()), //TODO placeholder
    //Banning
    BAN("ban","!ban <User> <Reason>","Bans a user for a reason",new BanCommand()),
    //Fun Commands
    ROULETTE("roulette", "!roulette <User>  or !roulette", "Russian Roulette" +
            " on yourself or another user" , new RouletteCommand()),
    D20("d20", "!d20", "Rolls a d20" , new D20Command()),
    JOIN("join", "!join", "Joins the channel a user is in" , new JoinCommand()),//TODO
    FLIP("flip", "!flip", "Flips a coin" , new CoinCommand()),
    //Main
    LISTCOMMANDS("commands", "!commands", "Lists all Commands" , new CommandsCommand());

    private String commandName;
    private String commandUsage;
    private String commandDescription;
    private MessageCommand _mCmd;

    Commands(String name, String usage, String description, MessageCommand mCmd){

        _mCmd = mCmd;
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

    public MessageCommand getCommand(){

        return _mCmd;

    }

    public String description(){

        return commandDescription;

    }
}
