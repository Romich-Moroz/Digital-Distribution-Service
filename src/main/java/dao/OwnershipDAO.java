package dao;

import dao.exceptions.DAOException;

public interface OwnershipDAO {
    void addGameCopyOwnership(int idUser, int idGameCopy) throws DAOException;
}
