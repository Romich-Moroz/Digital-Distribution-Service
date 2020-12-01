package services.impl;

import beans.GameCopy;
import dao.DAOFactory;
import dao.GameCopyDAO;
import dao.exceptions.DAOAlreadyExistsException;
import dao.exceptions.DAOException;
import dao.exceptions.DAONotFoundException;
import services.GameCopyService;
import services.exceptions.ServiceAlreadyExistsException;
import services.exceptions.ServiceException;
import services.exceptions.ServiceNotFoundException;

public class GameCopyServiceImpl implements GameCopyService {
    @Override
    public void addCopy(int idGame, String key) throws ServiceException {
        GameCopyDAO dao = DAOFactory.getInstance().getGameCopyDAO();
        try {
            dao.addCopy(idGame,key);
        }catch (DAOAlreadyExistsException e){
            throw new ServiceAlreadyExistsException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public int getAvailableGameCopyId(int idGame) throws ServiceException {
        GameCopyDAO dao = DAOFactory.getInstance().getGameCopyDAO();
        try {
            return dao.getAvailableGameCopyId(idGame);
        }catch (DAONotFoundException e){
            throw new ServiceNotFoundException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
