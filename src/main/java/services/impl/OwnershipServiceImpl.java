package services.impl;

import beans.OwnedGame;
import beans.Ownership;
import dao.DAOFactory;
import dao.OwnershipDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.OwnershipService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

import java.util.List;

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

    @Override
    public List<OwnedGame> getOwnedGames(int idUser) throws ServiceException {
        OwnershipDAO dao = DAOFactory.getInstance().getOwnershipDAO();
        try {
            return dao.getOwnedGames(idUser);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
