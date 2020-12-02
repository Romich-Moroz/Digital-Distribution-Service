package services;

import beans.OwnedGame;
import services.exceptions.ServiceException;

import java.util.List;

public interface OwnershipService {
    void addGameCopyOwnership(int idUser, int idGameCopy) throws ServiceException;
    List<OwnedGame> getOwnedGames(int idUser) throws ServiceException;
}
