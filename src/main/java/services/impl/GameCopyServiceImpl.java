package services.impl;

import dao.DAOFactory;
import dao.GameCopyDAO;
import dao.exceptions.DAOAlreadyExistsException;
import dao.exceptions.DAOException;
import services.GameCopyService;
import services.exceptions.ServiceAlreadyExistsException;
import services.exceptions.ServiceException;

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
}
