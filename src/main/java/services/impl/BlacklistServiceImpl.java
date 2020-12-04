package services.impl;

import dao.BlacklistDAO;
import dao.DAOFactory;
import dao.exceptions.DAOException;
import dao.exceptions.DAOForeignDependencyException;
import dao.exceptions.DAOInvalidDataException;
import services.BlacklistService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceForeignDependencyException;
import services.exceptions.ServiceInvalidDataException;

public class BlacklistServiceImpl implements BlacklistService {
    @Override
    public void addUser(String login, String reason) throws ServiceException {
        BlacklistDAO dao = DAOFactory.getInstance().getBlacklistDAO();
        try {
            dao.addUser(login,reason);
        }catch (DAOForeignDependencyException e){
            throw  new ServiceForeignDependencyException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void removeUser(String login) throws ServiceException {
        BlacklistDAO dao = DAOFactory.getInstance().getBlacklistDAO();
        try {
            dao.removeUser(login);
        }catch (DAOForeignDependencyException e){
            throw  new ServiceForeignDependencyException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public String checkForBan(int idUser) throws ServiceException {
        BlacklistDAO dao = DAOFactory.getInstance().getBlacklistDAO();
        try {
            return dao.checkForBan(idUser);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
