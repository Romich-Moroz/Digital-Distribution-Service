package controllers.command;

import java.util.HashMap;

import controllers.command.impl.*;

public class CommandProvider {
    private final HashMap<String, Command> commands = new HashMap();


    public CommandProvider() {
        commands.put("authorize", new AuthorizeCommand());
        commands.put("register", new RegisterCommand());
        commands.put("authredirect", new AuthRedirect());
        commands.put("regredirect", new RegRedirect());
        commands.put("mainredirect", new MainRedirect());
        commands.put("logout", new LogoutCommand());
        commands.put("cateditredirect", new CatalogEditorRedirectCommand());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
