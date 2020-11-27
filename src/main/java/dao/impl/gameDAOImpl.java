package dao.impl;

import beans.Game;
import dao.exceptions.DAOException;
import dao.GameDAO;

import java.util.List;

public class gameDAOImpl implements GameDAO {
    @Override
    public List<Game> find(String criteria) throws DAOException {
        return null;
    }
}
