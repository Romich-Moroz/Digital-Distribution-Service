package services.impl;

import beans.User;
import dao.exceptions.DAOException;
import dao.DAOFactory;
import dao.UserDAO;
import dao.exceptions.DAOAlreadyExistsException;
import dao.exceptions.DAOInvalidDataException;
import services.exceptions.ServiceException;
import services.UserService;
import services.exceptions.ServiceInvalidDataException;
import services.exceptions.ServiceAlreadyExistsException;

public class UserServiceImpl implements UserService {

    @Override
    public User authorization(String login, String password) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();

        try {
            return dao.authorization(login, password);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void registration(String login, String email, String password) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        UserDAO dao = factory.getUserDAO();

        try {
            dao.registration(login,email,password);
        } catch (DAOAlreadyExistsException e) {
            throw new ServiceAlreadyExistsException(e);
        }
        catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
