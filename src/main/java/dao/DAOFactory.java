package dao;

import dao.impl.*;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO sqlUserImpl = new UserDAOImpl();
    private final GameDAO sqlGameImpl = new GameDAOImpl();
    private final DeveloperDAO sqlDeveloperImpl = new DeveloperDAOImpl();
    private final GenreDAO sqlGenreImpl = new GenreDAOImpl();
    private final GameCopyDAO sqlGameCopyImpl = new GameCopyDAOImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() { return sqlUserImpl; }
    public GameDAO getGameDAO() {
        return sqlGameImpl;
    }
    public GenreDAO getGenreDAO() {
        return sqlGenreImpl;
    }
    public DeveloperDAO getDeveloperDAO() {
        return sqlDeveloperImpl;
    }
    public GameCopyDAO getGameCopyDAO() {
        return sqlGameCopyImpl;
    }
}
