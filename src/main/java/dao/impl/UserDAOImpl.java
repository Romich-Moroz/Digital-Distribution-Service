package dao.impl;

import beans.AccessType;
import dao.exceptions.DAOException;
import dao.UserDAO;
import beans.User;
import dao.exceptions.DAOAlreadyExistsException;
import dao.exceptions.DAOInvalidDataException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final String TBL_COLUMN_ID_USER = "idUser";
    private static final String TBL_COLUMN_ID_ACCESS = "idAccess";
    private static final String TBL_COLUMN_ACCESS_TYPE = "accesstype";
    private static final String TBL_COLUMN_LOGIN = "login";
    private static final String TBL_COLUMN_EMAIL = "email";
    private static final String TBL_COLUMN_PASSWORD = "password";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String INSERT_USER_SQL = "INSERT INTO Users(login,email,password) VALUES(?,?,?)";
    private static final String LOGIN_SQL = "SELECT users.id AS idUser,login,password,email,accessrights.id AS idAccess,accesstype " +
                                            "FROM users " +
                                            "INNER JOIN accessrights ON users.idaccessrights=accessrights.id " +
                                            "WHERE login = ? and password = ?";

    public User authorization(String login, String password) throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(LOGIN_SQL);
            ps.setString(1, login);
            ps.setString(2, getMD5Hash(password));

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }

            rs.next();

            if (rs.getRow() == 1) {
                AccessType access = new AccessType(rs.getInt(TBL_COLUMN_ID_ACCESS),rs.getString(TBL_COLUMN_ACCESS_TYPE));
                User user = new User(rs.getInt(TBL_COLUMN_ID_USER),access, rs.getString(TBL_COLUMN_LOGIN), rs.getString(TBL_COLUMN_EMAIL), rs.getString(TBL_COLUMN_PASSWORD));
                rs.close();
                ps.close();
                return user;
            }
            else throw new DAOInvalidDataException("Invalid user data");
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while authorize User", e);
        } catch (SQLException e) {
            throw new DAOException("Error while authorize User", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }


    private static String getMD5Hash(String password) throws DAOException {
        byte[] passwordToHash = password.getBytes();
        MessageDigest md;
        try {
           md = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e) {
            throw new DAOException(e);
        }
        md.update(passwordToHash);
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        return sb.toString();
    }

    public void registration(String login, String email, String password) throws DAOException {
        PreparedStatement ps;
        Connection con = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(INSERT_USER_SQL);
            ps.setString(1, login);
            ps.setString(2, email);
            ps.setString(3, getMD5Hash(password));
            ps.executeUpdate();
            ps.close();

        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while adding new User", e);
        } catch (SQLException e) {
            throw new DAOAlreadyExistsException("Error while adding new User", e);
        } finally {
            connectionPool.returnConnection(con);
        }


    }
}
