package dao;

import beans.Genre;
import dao.exceptions.DAOException;

import java.util.List;

public interface GenreDAO {
    List<Genre> list() throws DAOException;
}
