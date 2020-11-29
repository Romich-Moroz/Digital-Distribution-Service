package controllers.command.impl;

import controllers.command.Command;
import services.GameService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogEditorRedirectCommand implements Command {
    private static final String REQUEST_PARAMETER_GAMES = "gameslist";
    private static final String REDIRECT_COMMAND_EXCEPTION = "WEB-INF/views/catalogedit.jsp&message=exception";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GameService service = ServiceFactory.getInstance().getGameService();
        try {
            request.setAttribute(REQUEST_PARAMETER_GAMES,service.list());
        }
        catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION); //to avoid recursion redirect to page directly without command
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/catalogedit.jsp");
        dispatcher.forward(request, response);
    }
}
