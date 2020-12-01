package controllers.command.impl;

import controllers.command.Command;
import services.GameService;
import services.ServiceFactory;
import services.exceptions.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class StoreRedirect implements Command {
    private static final String SEARCH_SESSION_ATTRIBUTE = "searchRequest";
    private static final String CATALOG_PAGE_SESSION_ATTRIBUTE = "catalog";
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String gameName = (String)session.getAttribute(SEARCH_SESSION_ATTRIBUTE);
        GameService service = ServiceFactory.getInstance().getGameService();
        try {
            if (gameName == null) {
                session.setAttribute(CATALOG_PAGE_SESSION_ATTRIBUTE,service.list(true));
            }
            else {
                session.setAttribute(CATALOG_PAGE_SESSION_ATTRIBUTE,service.findByName(gameName));
            }
        } catch (ServiceException e) {
            throw new ServletException("Service is not available");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/store.jsp");
        dispatcher.forward(request, response);
    }
}
