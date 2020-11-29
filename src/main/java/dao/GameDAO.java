package dao;

import beans.Game;
import dao.exceptions.DAOException;
import services.exceptions.ServiceException;

import java.util.List;

public interface GameDAO {
    List<Game> find(String criteria) throws DAOException;
    List<Game> list() throws DAOException;
    void addGame(Game game) throws DAOException;
    void editGame(Game game) throws DAOException;
    void deleteGame(int id) throws DAOException;
}
