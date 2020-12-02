package dao.impl;

import beans.Developer;
import dao.BlacklistDAO;
import dao.exceptions.DAOException;
import dao.exceptions.DAOForeignDependencyException;
import dao.exceptions.DAONotFoundException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlacklistDAOImpl implements BlacklistDAO {
    private static final String ADD_USER_SQL = "INSERT INTO blacklist (idUser,reason) SELECT users.id,? FROM users WHERE login=?";
    private static final String REMOVE_USER_SQL ="DELETE FROM blacklist WHERE idUser IN (SELECT users.id FROM users WHERE login=?)";
    private static final String GET_BAN_REASON = "SELECT reason from blacklist WHERE idUser=?";
    private static final String TBL_COLUMN_REASON = "reason";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void addUser(String login, String reason) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(ADD_USER_SQL);
            ps.setString(1,reason);
            ps.setString(2,login);
            if (ps.executeUpdate() == 0) {
                ps.close();
                throw new DAOForeignDependencyException("User not found");
            }
            ps.close();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding user to blacklist", e);
        } catch (SQLException e) {
            throw new DAOException("Error while adding user to blacklist", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public void removeUser(String login) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(REMOVE_USER_SQL);
            ps.setString(1,login);
            if (ps.executeUpdate() == 0) {
                ps.close();
                throw new DAOForeignDependencyException("User not found");
            }
            ps.close();
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while removing user from blacklist", e);
        } catch (SQLException e) {
            throw new DAOException("Error while removing user from blacklist", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }

    @Override
    public String checkForBan(int idUser) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;
        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(GET_BAN_REASON);
            ps.setInt(1,idUser);
            rs = ps.executeQuery();
            if (rs == null) {
                return null;
            }
            rs.next();

            if (rs.getRow() == 1) {
                String result =  rs.getString(TBL_COLUMN_REASON);
                rs.close();
                ps.close();
                return result;
            }
            return null;
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting user ban reason", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting user ban reason", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}
