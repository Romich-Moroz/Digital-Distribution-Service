package dao;

import beans.Game;
import dao.exceptions.DAOException;

import java.util.List;

public interface GameDAO {
    List<Game> find(String criteria) throws DAOException;
}
