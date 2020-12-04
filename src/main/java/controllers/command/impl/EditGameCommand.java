package controllers.command.impl;

import controllers.command.Command;
import services.GameService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class EditGameCommand implements Command {
    private static final String REQUEST_PARAMETER_GAME_NAME = "gameName";
    private static final String REQUEST_PARAMETER_GAME_DESC = "gameDesc";
    private static final String REQUEST_PARAMETER_GAME_PRICE = "gamePrice";
    private static final String REQUEST_PARAMETER_GAME_DEVELOPER = "developers";
    private static final String REQUEST_PARAMETER_GAME_GENRE = "genres";
    private static final String REQUEST_PARAMETER_ID_GAME = "games";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=cateditredirect&message=editexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=cateditredirect&message=editsuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idDeveloper = parseInt(request.getParameter(REQUEST_PARAMETER_GAME_DEVELOPER));
        int idGenre = parseInt(request.getParameter(REQUEST_PARAMETER_GAME_GENRE));
        int idGame = parseInt(request.getParameter(REQUEST_PARAMETER_ID_GAME));
        String name = request.getParameter(REQUEST_PARAMETER_GAME_NAME);
        String desc = request.getParameter(REQUEST_PARAMETER_GAME_DESC);
        float price = parseFloat(request.getParameter(REQUEST_PARAMETER_GAME_PRICE));

        GameService gameService = ServiceFactory.getInstance().getGameService();
        try {
            gameService.editGame(idGame,idGenre,idDeveloper,name,desc,price);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
