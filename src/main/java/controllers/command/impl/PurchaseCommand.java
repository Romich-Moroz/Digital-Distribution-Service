package controllers.command.impl;

import beans.Game;
import beans.User;
import controllers.command.Command;
import services.GameCopyService;
import services.OwnershipService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PurchaseCommand implements Command {
    private static final String CART_SESSION_ATTRIBUTE = "cart";
    private static final String USER_SESSION_ATTR = "user";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=gamesredirect&message=purexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=gamesredirect&message=pursuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        List<Game> cartGames = (List<Game>)session.getAttribute(CART_SESSION_ATTRIBUTE);
        ServiceFactory factory = ServiceFactory.getInstance();
        OwnershipService ownershipService = factory.getOwnershipService();
        GameCopyService gameCopyService = factory.getGameCopyService();
        boolean flag = false;
        int userId = ((User)session.getAttribute(USER_SESSION_ATTR)).getId();
        for (Game game : cartGames) {
            try {
                int copyId = gameCopyService.getAvailableGameCopyId(game.getId());
                ownershipService.addGameCopyOwnership(userId,copyId);
            } catch (ServiceException e) {
                flag = true;
            }
        }
        session.removeAttribute(CART_SESSION_ATTRIBUTE);
        if (flag) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
        else response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
    }
}
