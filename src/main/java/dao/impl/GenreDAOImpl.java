package dao.impl;

import beans.Genre;
import dao.GenreDAO;
import dao.exceptions.DAOException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAOImpl implements GenreDAO {
    private static final String TBL_COLUMN_ID_GENRE = "id";
    private static final String TBL_COLUMN_GENRE = "genre";
    private static final String LIST_GENRES_SQL = "SELECT * FROM genres";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Genre> list() throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(LIST_GENRES_SQL);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }
            List<Genre> genres = new ArrayList<>();
            while (rs.next()) {
                Genre genre = new Genre(rs.getInt(TBL_COLUMN_ID_GENRE),rs.getString(TBL_COLUMN_GENRE));
                genres.add(genre);
            }
            rs.close();
            ps.close();
            return genres;
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting list of genres", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting list of genres", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}
