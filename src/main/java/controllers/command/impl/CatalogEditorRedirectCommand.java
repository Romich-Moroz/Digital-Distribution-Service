package controllers.command.impl;

import controllers.command.Command;
import services.DeveloperService;
import services.GameService;
import services.GenreService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogEditorRedirectCommand implements Command {
    private static final String REQUEST_PARAMETER_GAMES = "gameslist";
    private static final String REQUEST_PARAMETER_GENRES = "genreslist";
    private static final String REQUEST_PARAMETER_DEVELOPERS = "developerslist";
    private static final String REDIRECT_COMMAND_EXCEPTION = "WEB-INF/views/catalogedit.jsp&message=exception";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceFactory factory = ServiceFactory.getInstance();
        GameService gameService = factory.getGameService();
        DeveloperService developerService = factory.getDeveloperService();
        GenreService genreService = factory.getGenreService();
        try {
            request.setAttribute(REQUEST_PARAMETER_GAMES,gameService.list());
            request.setAttribute(REQUEST_PARAMETER_GENRES,genreService.list());
            request.setAttribute(REQUEST_PARAMETER_DEVELOPERS,developerService.list());
        }
        catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION); //to avoid recursion redirect to page directly without command
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/catalogedit.jsp");
        dispatcher.forward(request, response);
    }
}
