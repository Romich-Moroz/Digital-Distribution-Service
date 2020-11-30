package controllers.command.impl;

import controllers.command.Command;
import services.GameService;
import services.ServiceFactory;
import services.exceptions.ServiceException;
import services.exceptions.ServiceForeignDependencyException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

public class DeleteGameCommand implements Command {
    private static final String REQUEST_PARAMETER_GAMES = "games";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=cateditredirect&message=delexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=cateditredirect&message=delsuccess";
    private static final String REDIRECT_COMMAND_PARTIAL_SUCCESS = "controller?command=cateditredirect&message=delpartsuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int gameId = parseInt(request.getParameter(REQUEST_PARAMETER_GAMES));
        GameService service = ServiceFactory.getInstance().getGameService();
        try {
            service.deleteGame(gameId);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceForeignDependencyException e) {
            response.sendRedirect(REDIRECT_COMMAND_PARTIAL_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
