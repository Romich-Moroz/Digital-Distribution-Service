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
        commands.put("deletegame", new DeleteGameCommand());
        commands.put("addgame", new AddGameCommand());
        commands.put("editgame", new EditGameCommand());
        commands.put("addKeys", new AddKeysCommand());
        commands.put("blacklistredirect", new BlacklistRedirect());
        commands.put("addtoblacklist", new AddToBlacklistCommand());
        commands.put("removefromblacklist", new RemoveFromBlacklistCommand());
        commands.put("storeredirect",new StoreRedirect());
        commands.put("search",new SearchCommand());
        commands.put("addtocart",new AddToCartCommand());
        commands.put("cartredirect",new CartRedirect());
        commands.put("delfromcart",new RemoveFromCartCommand());
        commands.put("purchase",new PurchaseCommand());
        commands.put("gamesredirect",new GamesRedirect());
        commands.put("changelocale",new ChangeLocaleCommand());
    }

    public Command getCommand(String commandName) {
        return commands.get(commandName);
    }
}
