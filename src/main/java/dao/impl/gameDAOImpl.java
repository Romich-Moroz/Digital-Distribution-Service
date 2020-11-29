package dao.impl;

import beans.*;
import dao.exceptions.DAOException;
import dao.GameDAO;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class gameDAOImpl implements GameDAO {
    private static final String TBL_COLUMN_ID_GAME = "idGame";
    private static final String TBL_COLUMN_ID_GENRE = "idGenre";
    private static final String TBL_COLUMN_ID_DEVELOPER = "idDeveloper";
    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_GENRE = "genre";
    private static final String TBL_COLUMN_DEVELOPER = "developer";
    private static final String TBL_COLUMN_DESCRIPTION = "description";
    private static final String TBL_COLUMN_PRICE = "price";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String LIST_GAMES_SQL =    "SELECT games.id AS idGame, developers.id AS idDeveloper, genres.id AS idGenre, genre, developer, name, description, price " +
                                                    "FROM games " +
                                                    "INNER JOIN genres ON games.idgenre=genres.id " +
                                                    "INNER JOIN developers ON games.iddeveloper=developers.id";


    @Override
    public List<Game> find(String criteria) throws DAOException {
        return null;
    }

    @Override
    public List<Game> list() throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(LIST_GAMES_SQL);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }
            List<Game> games = new ArrayList<>();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt(TBL_COLUMN_ID_GENRE),rs.getString(TBL_COLUMN_GENRE));
                Developer developer = new Developer(rs.getInt(TBL_COLUMN_ID_DEVELOPER),rs.getString(TBL_COLUMN_DEVELOPER));
                Game game = new Game(rs.getInt(TBL_COLUMN_ID_GAME),genre,developer,rs.getString(TBL_COLUMN_NAME),
                                     rs.getString(TBL_COLUMN_DESCRIPTION),rs.getFloat(TBL_COLUMN_PRICE));
                games.add(game);
            }
            rs.close();
            ps.close();
            return games;
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while authorize User", e);
        } catch (SQLException e) {
            throw new DAOException("Error while authorize User", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public void addGame(Game game) throws DAOException {

    }

    @Override
    public void editGame(Game game) throws DAOException {

    }

    @Override
    public void deleteGame(int id) throws DAOException {

    }

}
