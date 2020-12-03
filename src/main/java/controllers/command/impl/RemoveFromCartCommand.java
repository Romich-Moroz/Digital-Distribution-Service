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

public class RemoveFromCartCommand implements Command {
    private static final String REQUEST_PARAMETER_SELECTED_GAME = "idGame";
    private static final String CATALOG_PAGE_SESSION_ATTRIBUTE = "catalog";
    private static final String CART_SESSION_ATTRIBUTE = "cart";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=cartredirect&message=delfromcartsuccess";
    private static final String REDIRECT_COMMAND_SUCCESS_NO_MSG = "controller?command=cartredirect";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idGame = parseInt(request.getParameter(REQUEST_PARAMETER_SELECTED_GAME));
        HttpSession session = request.getSession();
        for(Game game : (List<Game>)session.getAttribute(CATALOG_PAGE_SESSION_ATTRIBUTE)) {
            if (game.getId() == idGame) {
                List<Game> cartGames = (List<Game>)session.getAttribute(CART_SESSION_ATTRIBUTE);
                cartGames.remove(game);
                if (cartGames.size() == 0) {
                    session.removeAttribute(CART_SESSION_ATTRIBUTE);
                    response.sendRedirect(REDIRECT_COMMAND_SUCCESS_NO_MSG);
                }
                else {
                    session.setAttribute(CART_SESSION_ATTRIBUTE,cartGames);
                    response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
                }
                return;
            }
        }

    }
}
