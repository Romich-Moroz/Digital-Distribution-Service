package controllers.command.impl;

import controllers.command.Command;
import services.exceptions.ServiceException;
import services.ServiceFactory;
import services.UserService;
import services.exceptions.ServiceUserAlreadyExistsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements Command {
    private static final String REQUEST_PARAMETER_LOGIN = "login";
    private static final String REQUEST_PARAMETER_PASSWORD = "pass";
    private static final String REQUEST_PARAMETER_EMAIL = "email";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=mainredirect&message=regsuccess";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=regredirect&message=regexception";
    private static final String REDIRECT_COMMAND_EXISTS = "controller?command=regredirect&message=regexists";

    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter(REQUEST_PARAMETER_LOGIN);
        String password = request.getParameter(REQUEST_PARAMETER_PASSWORD);
        String email = request.getParameter(REQUEST_PARAMETER_EMAIL);

        UserService service = ServiceFactory.getInstance().getUserService();

        try {
            service.registration(login,email,password);
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        }
        catch (ServiceUserAlreadyExistsException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXISTS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }


    }
}
