package dao;

import dao.exceptions.DAOException;

public interface BlacklistDAO {
    void addUser(String login, String reason) throws DAOException;
    void removeUser(String login) throws DAOException;
    String checkForBan(int idUser) throws DAOException;
}
