package services;

import beans.Developer;
import services.exceptions.ServiceException;

import java.util.List;

public interface DeveloperService {
    List<Developer> list() throws ServiceException;
}
