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

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(USER_SESSION_ATTR);
        session.removeAttribute(REQUEST_PARAMETER_GAMES);
        session.removeAttribute(REQUEST_PARAMETER_GENRES);
        session.removeAttribute(REQUEST_PARAMETER_DEVELOPERS);
        response.sendRedirect(REDIRECT_COMMAND);
    }
}
