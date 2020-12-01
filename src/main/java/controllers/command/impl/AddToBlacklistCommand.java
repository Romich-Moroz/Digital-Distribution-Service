package controllers.command.impl;

import controllers.command.Command;
import services.BlacklistService;
import services.GameService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class AddToBlacklistCommand implements Command {
    private static final String REQUEST_PARAMETER_BAN_LOGIN = "login";
    private static final String REQUEST_PARAMETER_BAN_REASON = "reason";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=blacklistredirect&message=addexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=blacklistredirect&message=addsuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(REQUEST_PARAMETER_BAN_LOGIN);
        String reason = request.getParameter(REQUEST_PARAMETER_BAN_REASON);
        BlacklistService service = new ServiceFactory().getInstance().getBlacklistService();
        try {
            service.addUser(login,reason);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
