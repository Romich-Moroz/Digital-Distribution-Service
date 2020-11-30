package dao.impl;

import beans.Developer;
import dao.DeveloperDAO;
import dao.exceptions.DAOException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDAOImpl implements DeveloperDAO {
    private static final String TBL_COLUMN_ID_DEVELOPER = "id";
    private static final String TBL_COLUMN_DEVELOPER = "developer";
    private static final String LIST_DEVELOPERS_SQL = "SELECT * FROM developers";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public List<Developer> list() throws DAOException {
        PreparedStatement ps;
        Connection con = null;
        ResultSet rs = null;

        try {
            con = connectionPool.takeConnection();
            ps = con.prepareStatement(LIST_DEVELOPERS_SQL);

            rs = ps.executeQuery();

            if (rs == null) {
                return null;
            }
            List<Developer> developers = new ArrayList<>();
            while (rs.next()) {
                Developer developer = new Developer(rs.getInt(TBL_COLUMN_ID_DEVELOPER),rs.getString(TBL_COLUMN_DEVELOPER));
                developers.add(developer);
            }
            rs.close();
            ps.close();
            return developers;
        } catch (ConnectionPoolException e) {
            throw new DAOException("Error in Connection pool while getting list of developers", e);
        } catch (SQLException e) {
            throw new DAOException("Error while getting list of developers", e);
        } finally {
            connectionPool.returnConnection(con);
        }
    }
}
