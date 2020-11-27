package dao.impl.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class ConnectionPool {
    private static final int DEFAULT_POOL_SIZE = 5;
    private BlockingQueue<Connection> availableConnections;
    private BlockingQueue<Connection> busyConnections;

    private final String driver;
    private final String url;
    private final String user;
    private final String pass;
    private int poolSize;

    private static final ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {
        DBResourceManager dbResourceManager = DBResourceManager.getInstance();
        this.driver = dbResourceManager.getValue(DBParameter.DB_DRIVER);
        this.url = dbResourceManager.getValue(DBParameter.DB_URL);
        this.user = dbResourceManager.getValue(DBParameter.DB_USER);
        this.pass = dbResourceManager.getValue(DBParameter.DB_PASSWORD);

        try {
            this.poolSize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DB_POOL_SIZE));
        } catch (NumberFormatException e) {
            poolSize = DEFAULT_POOL_SIZE;
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public void initConnectionPool() throws ConnectionPoolException {

        try {
            Class.forName(driver);
            busyConnections = new ArrayBlockingQueue<>(poolSize);
            availableConnections = new ArrayBlockingQueue<>(poolSize);

            for (int i = 0; i < poolSize; i++) {
                Connection connection = DriverManager.getConnection(url, user, pass);
                availableConnections.add(connection);
            }
        } catch (SQLException e) {
            throw new ConnectionPoolException("SQLException in ConnectionPool", e);
        } catch (ClassNotFoundException e) {
            throw  new ConnectionPoolException("Can't find database driver class", e);
        }

    }

    public  Connection takeConnection() throws ConnectionPoolException {
        Connection connection;
        try {
            connection = availableConnections.take();
            busyConnections.add(connection);
        } catch (InterruptedException e) {
            throw  new ConnectionPoolException("Error connecting to data source.", e);
        }
        return connection;
    }

    public void returnConnection(Connection connection) {
        if (busyConnections.remove(connection)) {
            availableConnections.add(connection);
        }
    }

    public void disposePool() {
        try {
            closeConnectionsQueue(busyConnections);
            closeConnectionsQueue(availableConnections);
        } catch (SQLException e) {

        }
    }
    private void closeConnectionsQueue(BlockingQueue<Connection> queue) throws SQLException {
        Connection connection;
        while ((connection = queue.poll()) != null) {
            if (!connection.getAutoCommit()) {
                connection.commit();
            }
            connection.close();
        }
    }
}
