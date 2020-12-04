package controllers.command.impl;

import controllers.command.Command;
import services.BlacklistService;
import services.ServiceFactory;
import services.exceptions.ServiceException;
import services.exceptions.ServiceForeignDependencyException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToBlacklistCommand implements Command {
    private static final String REQUEST_PARAMETER_BAN_LOGIN = "login";
    private static final String REQUEST_PARAMETER_BAN_REASON = "reason";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=blacklistredirect&message=addexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=blacklistredirect&message=addsuccess";
    private static final String REDIRECT_COMMAND_ERROR = "controller?command=blacklistredirect&message=error";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter(REQUEST_PARAMETER_BAN_LOGIN);
        String reason = request.getParameter(REQUEST_PARAMETER_BAN_REASON);
        BlacklistService service = new ServiceFactory().getInstance().getBlacklistService();
        try {
            service.addUser(login,reason);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);

        } catch(ServiceForeignDependencyException e) {
            response.sendRedirect(REDIRECT_COMMAND_ERROR);
        }catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
