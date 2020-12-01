package dao.impl;

import beans.Genre;
import dao.OwnershipDAO;
import dao.exceptions.DAOException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnershipDAOImpl implements OwnershipDAO {
    private static final String ADD_OWNERSHIP_SQL = "INSERT INTO ownership (idUser,idGameCopy) VALUES(?,?)";

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
}
