package dao;

import beans.User;
import dao.exceptions.DAOException;
import dao.exceptions.DAOExistsException;

public interface UserDAO {
    User authorization (String login, String password) throws DAOException;
    void registration (String login, String email, String password) throws DAOException;
}
