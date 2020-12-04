package dao;

import beans.OwnedGame;
import dao.exceptions.DAOException;

import java.util.List;

public interface OwnershipDAO {
    void addGameCopyOwnership(int idUser, int idGameCopy) throws DAOException;
    List<OwnedGame> getOwnedGames(int idUser) throws DAOException;
}
