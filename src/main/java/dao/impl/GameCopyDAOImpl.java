package dao.impl;

import dao.GameCopyDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAONotFoundException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameCopyDAOImpl implements GameCopyDAO {
    private static final String TBL_COLUMN_ID_COPY = "idCopy";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String ADD_GAME_COPY_SQL = "INSERT INTO gamecopy (idGame,gameKey) VALUES(?,?)";

    private static final String GET_AVAILABLE_COPY_ID_SQL = "SELECT id as idCopy from gamecopy WHERE idGame=? AND id NOT IN (SELECT idGameCopy from ownership) LIMIT 1";

    @Override
    public void addCopy(int idGame, String key) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(ADD_GAME_COPY_SQL);
            ps.setInt(1, idGame);
            ps.setString(2, key);
            ps.executeUpdate();
            ps.close();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding new GameCopy", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding new GameCopy", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public int getAvailableGameCopyId(int idGame) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_AVAILABLE_COPY_ID_SQL);
            ps.setInt(1, idGame);
            rs = ps.executeQuery();
            if (rs == null) {
                throw new DAONotFoundException("No copies available");
            }
            rs.next();

            if (rs.getRow() == 1) {
                int result =  rs.getInt(TBL_COLUMN_ID_COPY);
                rs.close();
                ps.close();
                return result;
            }
            else throw new DAONotFoundException("Error available copy not found");

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting copy", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting copy", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}
