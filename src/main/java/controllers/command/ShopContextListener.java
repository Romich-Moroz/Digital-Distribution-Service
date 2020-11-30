package controllers.command;

import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;
import services.ServiceFactory;
import services.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ShopContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            ConnectionPool.getInstance().initConnectionPool();

        } catch (ConnectionPoolException e) {
            try {
                throw new ControllerRuntimeException(e);
            } catch (ControllerRuntimeException controllerRuntimeException) {
                controllerRuntimeException.printStackTrace();
            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ConnectionPool.getInstance().disposePool();
    }
}
