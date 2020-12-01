package controllers.command.impl;

import controllers.command.Command;
import services.BlacklistService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveFromBlacklistCommand implements Command {
    private static final String REQUEST_PARAMETER_BAN_LOGIN = "login";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=blacklistredirect&message=delexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=blacklistredirect&message=delsuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(REQUEST_PARAMETER_BAN_LOGIN);
        BlacklistService service = new ServiceFactory().getInstance().getBlacklistService();
        try {
            service.removeUser(login);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
