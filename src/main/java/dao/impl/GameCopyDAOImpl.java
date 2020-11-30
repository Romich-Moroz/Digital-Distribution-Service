package dao.impl;

import dao.GameCopyDAO;
import dao.exceptions.DAOException;
import dao.impl.connection.ConnectionPool;
import dao.impl.connection.ConnectionPoolException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GameCopyDAOImpl implements GameCopyDAO {
    private static final String TBL_COLUMN_ID_GAME = "idGame";
    private static final String TBL_COLUMN_KEY = "gameKey";

    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private static final String ADD_GAME_COPY_SQL = "INSERT INTO gamecopy (idGame,gameKey) VALUES(?,?)";

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
}
