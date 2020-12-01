package services.impl;

import dao.BlacklistDAO;
import dao.DAOFactory;
import dao.DeveloperDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.BlacklistService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

public class BlacklistServiceImpl implements BlacklistService {
    @Override
    public void addUser(String login, String reason) throws ServiceException {
        BlacklistDAO dao = DAOFactory.getInstance().getBlacklistDAO();
        try {
            dao.addUser(login,reason);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeUser(String login) throws ServiceException {
        BlacklistDAO dao = DAOFactory.getInstance().getBlacklistDAO();
        try {
            dao.removeUser(login);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
