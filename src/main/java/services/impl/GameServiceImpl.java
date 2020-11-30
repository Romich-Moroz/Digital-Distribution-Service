package services.impl;

import beans.Game;
import dao.DAOFactory;
import dao.GameDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOForeignDependencyException;
import dao.exceptions.DAOInvalidDataException;
import services.GameService;
import services.exceptions.ServiceException;
import services.exceptions.ServiceForeignDependencyException;
import services.exceptions.ServiceInvalidDataException;

import java.util.List;

public class GameServiceImpl implements GameService {

    @Override
    public List<Game> findByDeveloper(int idDeveloper) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            return dao.findByDeveloper(idDeveloper);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Game> findByGenre(int idGenre) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            return dao.findByGenre(idGenre);
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
    public void addGame(int idGenre, int idDeveloper, String name, String description, float price) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            dao.addGame(idDeveloper,idGenre,name,description,price);
        }catch (DAOInvalidDataException e){
            throw  new ServiceInvalidDataException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void editGame(int idGame,int idGenre,int idDeveloper, String name, String description, float price) throws ServiceException {
        DAOFactory factory = DAOFactory.getInstance();
        GameDAO dao = factory.getGameDAO();

        try {
            dao.editGame(idGame,idGenre,idDeveloper,name,description,price);
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
        }catch (DAOForeignDependencyException e) {
            throw  new ServiceForeignDependencyException(e);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
