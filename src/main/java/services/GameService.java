package services;

import beans.Developer;
import beans.Game;
import dao.exceptions.DAOException;
import services.exceptions.ServiceException;

import java.util.List;

public interface GameService {
    List<Game> find(String criteria) throws ServiceException;
    List<Game> list() throws ServiceException;
    void addGame(Game game) throws ServiceException;
    void editGame(Game game) throws ServiceException;
    void deleteGame(int id) throws ServiceException;
}
