package controllers.command.impl;

import beans.Game;
import controllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddToCartCommand implements Command {
    private static final String REQUEST_PARAMETER_SELECTED_GAME = "idGame";
    private static final String CATALOG_PAGE_SESSION_ATTRIBUTE = "catalog";
    private static final String CART_SESSION_ATTRIBUTE = "cart";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=storeredirect&message=addtocartsuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idGame = parseInt(request.getParameter(REQUEST_PARAMETER_SELECTED_GAME));
        HttpSession session = request.getSession();
        for(Game game : (List<Game>)session.getAttribute(CATALOG_PAGE_SESSION_ATTRIBUTE)) {
            if (game.getId() == idGame) {
                List<Game> cartGames = (List<Game>)session.getAttribute(CART_SESSION_ATTRIBUTE);
                if (cartGames == null) {
                    cartGames = new ArrayList<>();
                }
                cartGames.add(game);
                session.setAttribute(CART_SESSION_ATTRIBUTE,cartGames);
                break;
            }
        }
        response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
    }
}
