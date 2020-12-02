package services;

import beans.GameCopy;
import services.exceptions.ServiceException;

import java.util.List;

public interface GameCopyService {
    void addCopy(int idGame, String key) throws ServiceException;
    int getAvailableGameCopyId(int idGame) throws ServiceException;
}
