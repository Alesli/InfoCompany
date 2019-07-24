package jdbc;

import java.io.IOException;
import java.util.Properties;

/**
 * Class for reading data from a connection.properties file when connecting to a database
 *
 * @author Alesia Skarakhod
 */
class PropertyReader {

    Properties getProperties(String fileName) {

        Properties properties = new Properties();

        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("property/" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
