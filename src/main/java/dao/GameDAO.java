package dao;

import beans.Game;
import dao.exceptions.DAOException;

import java.util.List;

public interface GameDAO {
    List<Game> findByDeveloper(int idDeveloper) throws DAOException;
    List<Game> findByGenre(int idGenre) throws DAOException;
    List<Game> list() throws DAOException;
    void addGame(int idGenre, int idDeveloper, String name, String description, float price) throws DAOException;
    void editGame(int idGame,int idGenre,int idDeveloper, String name, String description, float price) throws DAOException;
    void deleteGame(int id) throws DAOException;
}
