package controllers.command.impl;

import controllers.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeLocaleCommand implements Command {
    private static final String REDIRECT_COMMAND = "controller?command=mainredirect";
    private static final String LAST_REDIRECT_ATTRIBUTE = "lastRedirect";
    private static final String LOCALE_SESSION_ATTRIBUTE = "locale";
    private static final String LOCALE_REQUEST_ATTRIBUTE = "locale";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute(LOCALE_SESSION_ATTRIBUTE, request.getParameter(LOCALE_REQUEST_ATTRIBUTE));

        if (session.getAttribute(LAST_REDIRECT_ATTRIBUTE) != null)
        {
            response.sendRedirect(session.getAttribute(LAST_REDIRECT_ATTRIBUTE).toString());
        }
        else {
            response.sendRedirect(REDIRECT_COMMAND);
        }
    }
}
