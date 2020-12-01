package services.impl;

import dao.DAOFactory;
import dao.GenreDAO;
import dao.OwnershipDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.OwnershipService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

public class OwnershipServiceImpl implements OwnershipService {

    @Override
    public void addGameCopyOwnership(int idUser, int idGameCopy) throws ServiceException {
        OwnershipDAO dao = DAOFactory.getInstance().getOwnershipDAO();
        try {
            dao.addGameCopyOwnership(idUser,idGameCopy);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
