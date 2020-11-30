package services;


import beans.Genre;
import services.exceptions.ServiceException;

import java.util.List;

public interface GenreService {
    List<Genre> list() throws ServiceException;
}
