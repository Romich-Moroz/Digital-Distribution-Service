package services.impl;

import beans.Genre;
import dao.DAOFactory;
import dao.GenreDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.GenreService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

import java.util.List;

public class GenreServiceImpl implements GenreService {
    @Override
    public List<Genre> list() throws ServiceException {
        GenreDAO dao = DAOFactory.getInstance().getGenreDAO();
        try {
            return dao.list();
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
