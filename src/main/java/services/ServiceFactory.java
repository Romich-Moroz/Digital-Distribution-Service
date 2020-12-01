package services;

import beans.Blacklist;
import services.impl.*;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserService userService = new UserServiceImpl();
    private final GameService gameService = new GameServiceImpl();
    private final GenreService genreService = new GenreServiceImpl();
    private final DeveloperService developerService = new DeveloperServiceImpl();
    private final GameCopyService gameCopyService = new GameCopyServiceImpl();
    private final BlacklistService blacklistService = new BlacklistServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return userService;
    }

    public GameService getGameService() { return gameService; }
    public GenreService getGenreService() { return genreService; }
    public DeveloperService getDeveloperService() { return developerService; }
    public GameCopyService getGameCopyService() { return gameCopyService; }
    public BlacklistService getBlacklistService() { return blacklistService; }
}
