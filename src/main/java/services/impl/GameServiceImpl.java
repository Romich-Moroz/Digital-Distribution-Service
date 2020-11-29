package services.impl;

import beans.Game;
import dao.DAOFactory;
import dao.GameDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOInvalidDataException;
import services.GameService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceInvalidDataException;

import java.util.List;

public class GameServiceImpl implements GameService {
    @Override
    public List<Game> find(String criteria) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            return dao.find(criteria);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Game> list() throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            return dao.list();
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addGame(Game game) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            dao.addGame(game);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void editGame(Game game) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            dao.editGame(game);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteGame(int id) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            dao.deleteGame(id);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
