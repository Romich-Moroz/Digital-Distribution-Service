package dao.impl;

import beans.*;
import dao.exceptions.DAOAlreadyExistsException;
import dao.exceptions.DAOException;
import dao.GameDAO;
import dao.exceptions.DAOForeignDependencyException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("DuplicatedCode")
public class GameDAOImpl implements GameDAO {
    private static final String TBL_COLUMN_ID_GAME = "idGame";
    private static final String TBL_COLUMN_ID_GENRE = "idGenre";
    private static final String TBL_COLUMN_ID_DEVELOPER = "idDeveloper";
    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_GENRE = "genre";
    private static final String TBL_COLUMN_DEVELOPER = "developer";
    private static final String TBL_COLUMN_DESCRIPTION = "description";
    private static final String TBL_COLUMN_PRICE = "price";
    private static final String TBL_COLUMN_IS_SELLING = "isSelling";
    private static final String TBL_COLUMN_SOLD_COPIES = "sold";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String LIST_GAMES_SQL =    "SELECT games.id AS idGame, developers.id AS idDeveloper, genres.id AS idGenre, genre, developer, name, description, price, isSelling " +
                                                    "FROM games " +
                                                    "INNER JOIN genres ON games.idgenre=genres.id " +
                                                    "INNER JOIN developers ON games.iddeveloper=developers.id " +
                                                    "ORDER BY name";

    private static final String FIND_GAMES_BY_DEVELOPER_SQL =   "SELECT games.id AS idGame, developers.id AS idDeveloper, genres.id AS idGenre, genre, developer, name, description, price, isSelling " +
                                                                "FROM games " +
                                                                "INNER JOIN genres ON games.idgenre=genres.id " +
                                                                "INNER JOIN developers ON games.iddeveloper=developers.id " +
                                                                "WHERE developers.id=? ORDER BY name";
    private static final String FIND_GAMES_BY_GENRE_SQL =   "SELECT games.id AS idGame, developers.id AS idDeveloper, genres.id AS idGenre, genre, developer, name, description, price, isSelling " +
                                                            "FROM games " +
                                                            "INNER JOIN genres ON games.idgenre=genres.id " +
                                                            "INNER JOIN developers ON games.iddeveloper=developers.id " +
                                                            "WHERE genres.id=? ORDER BY name";

    private static final String DELETE_GAME_SQL = "DELETE FROM games WHERE id=?";

    private static final String REMOVE_GAME_SQL = "UPDATE games SET isSelling=0 WHERE id=?";
    private static final String OWNERSHIP_CHECK_SQL =   "SELECT COUNT(ownership.idUser) AS sold " +
                                                        "FROM ownership,gamecopy " +
                                                        "WHERE ownership.idgamecopy=gamecopy.id AND gamecopy.idGame=?";

    private static final String ADD_GAME_SQL = "INSERT INTO games (idGenre,idDeveloper,name,description,price) VALUES(?,?,?,?,?)";

    private static final String UPDATE_GAME_SQL = "UPDATE games SET idGenre=?,idDeveloper=?,name=?,description=?,price=?,isSelling=? WHERE games.id=?";

    @Override
    public List<Game> findByDeveloper(int idDeveloper) throws DAOException {
        return getGames(idDeveloper, FIND_GAMES_BY_DEVELOPER_SQL);
    }

    @Override
    public List<Game> findByGenre(int idGenre) throws DAOException {
        return getGames(idGenre, FIND_GAMES_BY_GENRE_SQL);
    }

    @Override
    public List<Game> list() throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(LIST_GAMES_SQL);

            return getGames(ps);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting list of games", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting list of games", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }


    private List<Game> getGames(int index, String sql) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,index);
            return getGames(ps);
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting list of games", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting list of games", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    private List<Game> getGames(PreparedStatement ps) throws SQLException {
        ResultSet rs;
        rs = ps.executeQuery();

        if (rs == null) {
            return null;
        }
        List<Game> games = new ArrayList<>();
        while (rs.next()) {
            Genre genre = new Genre(rs.getInt(TBL_COLUMN_ID_GENRE),rs.getString(TBL_COLUMN_GENRE));
            Developer developer = new Developer(rs.getInt(TBL_COLUMN_ID_DEVELOPER),rs.getString(TBL_COLUMN_DEVELOPER));
            Game game = new Game(rs.getInt(TBL_COLUMN_ID_GAME),genre,developer,rs.getString(TBL_COLUMN_NAME),
                                 rs.getString(TBL_COLUMN_DESCRIPTION),rs.getFloat(TBL_COLUMN_PRICE),rs.getBoolean(TBL_COLUMN_IS_SELLING));
            games.add(game);
        }
        rs.close();
        ps.close();
        return games;
    }

    @Override
    public void addGame(int idGenre, int idDeveloper, String name, String description, float price) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(ADD_GAME_SQL);
            ps.setInt(1, idGenre);
            ps.setInt(2, idDeveloper);
            ps.setString(3, name);
            ps.setString(4, description);
            ps.setFloat(5, price);
            ps.executeUpdate();
            ps.close();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding new Game", e);
        } catch (SQLException e) {
            throw new DAOAlreadyExistsException("Error game already exists", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public void editGame(int idGame,int idGenre,int idDeveloper, String name, String description, float price) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(UPDATE_GAME_SQL);
            ps.setInt(1, idGenre);
            ps.setInt(2, idDeveloper);
            ps.setString(3, name);
            ps.setString(4, description);
            ps.setFloat(5, price);
            ps.setInt(6,1);
            ps.setInt(7,idGame);
            ps.executeUpdate();
            ps.close();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while editing Game", e);
        } catch (SQLException e) {
            throw new DAOException("Error while editing game", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public void deleteGame(int id) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(OWNERSHIP_CHECK_SQL);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if (rs == null) {
                throw new DAOException("Can't retrieve sold copies");
            }

            rs.next();

            if (rs.getRow() == 1) {
                int soldCopies = rs.getInt(TBL_COLUMN_SOLD_COPIES);
                if (soldCopies == 0) {
                    ps = con.prepareStatement(DELETE_GAME_SQL);
                }
                else {
                    ps = con.prepareStatement(REMOVE_GAME_SQL);
                }
                ps.setInt(1,id);
                ps.executeUpdate();
                if (soldCopies > 0) {
                    throw new DAOForeignDependencyException("Can't delete element with foreign dependency, updating instead");
                }
            }
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while deleting game", e);
        } catch (SQLException e) {
            throw new DAOException("Error while deleting game", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

}
