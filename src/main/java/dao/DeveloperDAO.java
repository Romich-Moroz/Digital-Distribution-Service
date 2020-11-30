package dao;

import beans.Developer;
import dao.exceptions.DAOException;

import java.util.List;

public interface DeveloperDAO {
    List<Developer> list() throws DAOException;
}
