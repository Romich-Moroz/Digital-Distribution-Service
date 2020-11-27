package controllers.command.impl;

import controllers.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutCommand implements Command {
    private static final String REDIRECT_COMMAND = "controller?command=mainredirect";
    private static final String USER_SESSION_ATTR = "user";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(USER_SESSION_ATTR);
        response.sendRedirect(REDIRECT_COMMAND);
    }
}
