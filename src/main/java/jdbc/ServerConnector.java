package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Class for establishing a connection with MySQL database
 *
 * @author Alesia Skarakhod
 */
public class ServerConnector {

    private static ServerConnector instance;
    private static Connection connection;

    /**
     * The method for connecting to the MySQL server by properties
     * readable from the connection.properties file
     */
    private ServerConnector() {

        PropertyReader propertyReader = new PropertyReader();
        Properties properties = propertyReader.getProperties("connection.properties");

        Connection conn = null;

        try {
            Class.forName(properties.getProperty("driver"));

            try {
                conn = DriverManager.getConnection(
                        properties.getProperty("url"),
                        properties.getProperty("username"),
                        properties.getProperty("password")
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = conn;
    }

    /**
     * The static method, returns a single instance of the class,
     * checking whether it was not created before
     * (object creation at the first method call)
     *
     * @return instance
     */
    public static ServerConnector getInstance() {
        if (instance == null) {
            instance = new ServerConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
