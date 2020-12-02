package controllers.command.impl;

import beans.User;
import controllers.command.Command;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GamesRedirect implements Command {
    private static final String GAMES_SESSION_ATTRIBUTE = "ownedgames";
    private static final String USER_SESSION_ATTRIBUTE = "user";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = ((User)session.getAttribute(USER_SESSION_ATTRIBUTE)).getId();
        try {
            session.setAttribute(GAMES_SESSION_ATTRIBUTE, ServiceFactory.getInstance().getOwnershipService().getOwnedGames(userId));
        }catch (ServiceException e) {
            throw new ServletException("Failed to get owned games list",e);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/games.jsp");
        dispatcher.forward(request, response);
    }
}
