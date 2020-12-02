package controllers.command.impl;

import beans.User;
import controllers.command.Command;
import services.ServiceFactory;
import services.UserService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizeCommand implements Command {
    private static final String REQUEST_PARAMETER_LOGIN = "login";
    private static final String REQUEST_PARAMETER_PASSWORD = "pass";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=mainredirect";
    private static final String REDIRECT_COMMAND_ERROR = "controller?command=authredirect&message=logerror";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=authredirect&message=logexception";
    private static final String REDIRECT_COMMAND_BANNED = "controller?command=authredirect&message=logbanned";
    private static final String USER_SESSION_ATTR = "user";

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter(REQUEST_PARAMETER_LOGIN);
        String password = request.getParameter(REQUEST_PARAMETER_PASSWORD);

        UserService service = ServiceFactory.getInstance().getUserService();
        HttpSession session = request.getSession(true);

        try {
            User user = service.authorization(login,password);
            String reason = ServiceFactory.getInstance().getBlacklistService().checkForBan(user.getId());
            if (reason == null) {
                session.setAttribute(USER_SESSION_ATTR, user);
                response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
            }
            else {
                response.sendRedirect(REDIRECT_COMMAND_BANNED);
            }
        } catch (ServiceInvalidDataException e) {
            response.sendRedirect(REDIRECT_COMMAND_ERROR);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }

    }
}
