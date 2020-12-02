package dao;

import beans.OwnedGame;
import beans.Ownership;
import dao.exceptions.DAOException;
import services.exceptions.ServiceException;

import java.util.List;

public interface OwnershipDAO {
    void addGameCopyOwnership(int idUser, int idGameCopy) throws DAOException;
    List<OwnedGame> getOwnedGames(int idUser) throws DAOException;
}
