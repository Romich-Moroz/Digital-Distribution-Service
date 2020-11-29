package dao;

import beans.User;
import dao.exceptions.DAOException;

public interface UserDAO {
    User authorization (String login, String password) throws DAOException;
    void registration (String login, String email, String password) throws DAOException;
}
