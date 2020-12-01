package dao;

import dao.exceptions.DAOException;

public interface GameCopyDAO {
    void addCopy(int idGame, String key) throws DAOException;
    int getAvailableGameCopyId(int idGame) throws DAOException;
}
