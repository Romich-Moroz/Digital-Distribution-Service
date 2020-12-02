package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controllers.command.Command;
import controllers.command.CommandProvider;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String PARAMETER_COMMAND = "command";
    private static final String LAST_REDIRECT_ATTRIBUTE = "lastRedirect";

    private final CommandProvider provider = new CommandProvider();
    private final Logger logger;

    public Controller() {
        super();
        logger = Logger.getLogger(this.getClass());

        PropertyConfigurator.configure(this.getClass().getClassLoader().getResource("log4j.properties"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(PARAMETER_COMMAND);
        Command command = provider.getCommand(commandName);
        try {
            command.execute(request, response);
        }
        catch (Exception e) {
            logger.debug(e);
        }
        request.getSession(true).setAttribute(LAST_REDIRECT_ATTRIBUTE, request.getRequestURI() + "?" + request.getQueryString());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
