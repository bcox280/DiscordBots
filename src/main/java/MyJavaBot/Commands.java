package MyJavaBot;

/**
 * Created by Blair on 12/07/2017.
 */
public enum Commands {
    ROLES("roles"),
    ADDROLES("add");

    private String commandName;

    Commands(String name){

        commandName=name;

    }
    @Override
    public String toString(){


        return ("!" + commandName);

    }
}
