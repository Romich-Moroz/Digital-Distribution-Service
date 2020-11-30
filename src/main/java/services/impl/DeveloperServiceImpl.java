package services.impl;

import beans.Developer;
import dao.DAOFactory;
import dao.DeveloperDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.DeveloperService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

import java.util.List;

public class DeveloperServiceImpl implements DeveloperService {
    @Override
    public List<Developer> list() throws ServiceException {
        DeveloperDAO dao = DAOFactory.getInstance().getDeveloperDAO();
        try {
            return dao.list();
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
