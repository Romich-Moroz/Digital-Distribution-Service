package services;

import beans.User;
import services.exceptions.ServiceException;

public interface UserService {
    User authorization (String login, String password) throws ServiceException;
    void registration (String login, String email, String password) throws ServiceException;
}
