package controllers.command.impl;

import controllers.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SearchCommand implements Command {
    private static final String REQUEST_PARAMETER_SEARCH = "gameName";
    private static final String SEARCH_SESSION_ATTRIBUTE = "searchRequest";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=storeredirect";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String searchRequest = request.getParameter(REQUEST_PARAMETER_SEARCH);
        HttpSession session = request.getSession();
        session.setAttribute(SEARCH_SESSION_ATTRIBUTE,searchRequest);
        response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
    }
}
