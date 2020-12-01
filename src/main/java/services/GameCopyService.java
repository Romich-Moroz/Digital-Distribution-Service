package services;

import beans.GameCopy;
import services.exceptions.ServiceException;

public interface GameCopyService {
    void addCopy(int idGame, String key) throws ServiceException;
    int getAvailableGameCopyId(int idGame) throws ServiceException;
}
