package controllers.command.impl;

import controllers.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements Command {
    private static final String REDIRECT_COMMAND = "controller?command=mainredirect";
    private static final String USER_SESSION_ATTR = "user";
    private static final String REQUEST_PARAMETER_GAMES = "gameslist";
    private static final String REQUEST_PARAMETER_GENRES = "genreslist";
    private static final String REQUEST_PARAMETER_DEVELOPERS = "developerslist";
    private static final String SEARCH_SESSION_ATTRIBUTE = "searchRequest";
    private static final String CATALOG_PAGE_SESSION_ATTRIBUTE = "catalog";
    private static final String CART_SESSION_ATTRIBUTE = "cart";
    private static final String GAMES_SESSION_ATTRIBUTE = "ownedgames";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(USER_SESSION_ATTR);
        session.removeAttribute(REQUEST_PARAMETER_GAMES);
        session.removeAttribute(REQUEST_PARAMETER_GENRES);
        session.removeAttribute(REQUEST_PARAMETER_DEVELOPERS);
        session.removeAttribute(CATALOG_PAGE_SESSION_ATTRIBUTE);
        session.removeAttribute(SEARCH_SESSION_ATTRIBUTE);
        session.removeAttribute(CART_SESSION_ATTRIBUTE);
        session.removeAttribute(GAMES_SESSION_ATTRIBUTE);

        response.sendRedirect(REDIRECT_COMMAND);
    }
}
