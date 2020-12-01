package services;

import services.exceptions.ServiceException;

public interface BlacklistService  {
    void addUser(String login, String reason) throws ServiceException;
    void removeUser(String login) throws ServiceException;
}
