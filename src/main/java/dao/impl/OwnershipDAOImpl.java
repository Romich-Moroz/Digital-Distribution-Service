package dao.impl;

import beans.*;
import dao.OwnershipDAO;
import dao.exceptions.DAOException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OwnershipDAOImpl implements OwnershipDAO {
    private static final String TBL_COLUMN_DEVELOPER = "developer";
    private static final String TBL_COLUMN_NAME = "name";
    private static final String TBL_COLUMN_DATE = "date";
    private static final String TBL_COLUMN_KEY = "gamekey";
    private static final String ADD_OWNERSHIP_SQL = "INSERT INTO ownership (idUser,idGameCopy) VALUES(?,?)";
    private static final String GET_OWNERSHIPS_BY_USER_ID_SQL = "SELECT developer,name,gamekey,date " +
                                                                "FROM ownership " +
                                                                "INNER JOIN gamecopy ON gamecopy.id=ownership.idgamecopy " +
                                                                "INNER JOIN games ON gamecopy.idgame = games.id " +
                                                                "INNER JOIN developers ON games.iddeveloper = developers.id " +
                                                                "WHERE iduser=? ORDER BY date DESC";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void addGameCopyOwnership(int idUser, int idGameCopy) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(ADD_OWNERSHIP_SQL);
            ps.setInt(1,idUser);
            ps.setInt(2,idGameCopy);
            ps.executeUpdate();
            ps.close();
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding ownership", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding ownership", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public List<OwnedGame> getOwnedGames(int idUser) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_OWNERSHIPS_BY_USER_ID_SQL);
            ps.setInt(1,idUser);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            List<OwnedGame> ownerships = new ArrayList<>();
            while (rs.next()) {
                ownerships.add(new OwnedGame(rs.getString(TBL_COLUMN_NAME),
                                rs.getString(TBL_COLUMN_DEVELOPER),
                                rs.getString(TBL_COLUMN_KEY),
                                rs.getString(TBL_COLUMN_DATE)));
            }
            rs.close();
            ps.close();
            return ownerships;
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding ownership", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding ownership", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}
