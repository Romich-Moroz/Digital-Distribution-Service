package services;

import beans.Game;
import services.exceptions.ServiceException;

import java.util.List;

public interface GameService {
    List<Game> list(boolean sellingOnly) throws ServiceException;
    List<Game> findByName(String name) throws ServiceException;
    void addGame(int idGenre,int idDeveloper, String name, String description, float price) throws ServiceException;
    void editGame(int idGame,int idGenre,int idDeveloper, String name, String description, float price) throws ServiceException;
    void deleteGame(int id) throws ServiceException;
}
