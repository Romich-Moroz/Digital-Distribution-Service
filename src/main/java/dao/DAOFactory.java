package dao;

import dao.impl.gameDAOImpl;
import dao.impl.userDAOImpl;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new userDAOImpl();
    private final GameDAO sqlGameImpl = new gameDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return sqlUserImpl;
    }

    public  GameDAO getGameDAO() {
        return sqlGameImpl;
    }
}
