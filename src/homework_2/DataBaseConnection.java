package homework_2;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DataBaseConnection {

    private static final String URL;

    private static final String NAME;

    private static final String PASSWORD;

    static  {

        Properties properties = new Properties();

        try (FileInputStream fileInputStream = new FileInputStream("src/resources/db.properties")) {

            properties.load(fileInputStream);

            URL = properties.getProperty("database.url");
            NAME = properties.getProperty("database.name");
            PASSWORD = properties.getProperty("database.password");

        }  catch (IOException e) {

                throw new RuntimeException(e);

        }

    }

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, NAME, PASSWORD);

    }

}
