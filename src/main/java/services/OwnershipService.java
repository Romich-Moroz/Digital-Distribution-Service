package services;

import services.exceptions.ServiceException;

public interface OwnershipService {
    void addGameCopyOwnership(int idUser, int idGameCopy) throws ServiceException;
}
