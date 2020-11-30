package services;

import beans.Game;
import services.exceptions.ServiceException;

import java.util.List;

public interface GameService {
    List<Game> findByDeveloper(int idDeveloper) throws ServiceException;
    List<Game> findByGenre(int idGenre) throws ServiceException;
    List<Game> list() throws ServiceException;
    void addGame(int idGenre,int idDeveloper, String name, String description, float price) throws ServiceException;
    void editGame(int idGame,int idGenre,int idDeveloper, String name, String description, float price) throws ServiceException;
    void deleteGame(int id) throws ServiceException;
}
