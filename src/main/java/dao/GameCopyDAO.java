package dao;

import beans.GameCopy;
import dao.exceptions.DAOException;
import services.exceptions.ServiceException;

public interface GameCopyDAO {
    void addCopy(int idGame, String key) throws DAOException;
    int getAvailableGameCopyId(int idGame) throws DAOException;
}
