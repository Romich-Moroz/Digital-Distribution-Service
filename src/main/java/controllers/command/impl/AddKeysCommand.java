package controllers.command.impl;

import controllers.command.Command;
import services.GameCopyService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;


public class AddKeysCommand implements Command {
    private static final String REQUEST_PARAMETER_KEYS = "gameKeys";
    private static final String REQUEST_PARAMETER_ID_GAME = "games";
    private static final String REDIRECT_COMMAND_EXCEPTION = "controller?command=cateditredirect&message=addkeysexception";
    private static final String REDIRECT_COMMAND_SUCCESS = "controller?command=cateditredirect&message=addkeyssuccess";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keys = request.getParameter(REQUEST_PARAMETER_KEYS);
        int idGame = parseInt(request.getParameter(REQUEST_PARAMETER_ID_GAME));

        GameCopyService service = ServiceFactory.getInstance().getGameCopyService();
        try {
            for(String key : keys.split("\\r?\\n")) {
                service.addCopy(idGame,key);
            }
            response.sendRedirect(REDIRECT_COMMAND_SUCCESS);
        } catch (ServiceException e) {
            response.sendRedirect(REDIRECT_COMMAND_EXCEPTION);
        }
    }
}
