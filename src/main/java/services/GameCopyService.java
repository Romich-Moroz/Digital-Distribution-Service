package services;

import services.exceptions.ServiceException;

public interface GameCopyService {
    void addCopy(int idGame, String key) throws ServiceException;
}
