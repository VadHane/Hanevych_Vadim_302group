package lab5.database;

import lab5.types.ConnectionString;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase implements AutoCloseable {
    private Connection connection;

    public DataBase(ConnectionString connectionString) throws Exception {
        try {
            connection = DriverManager.getConnection(connectionString.getUrl(), connectionString.getUsername(), connectionString.getPassword());
        } catch (Exception exception) {
            throw new Exception("Trying connection to database ended with errors. Connection did not create.");
        }

        initDatabase();
    }

    public void setData(String query) throws Exception {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    public ResultSet getData(String query) throws Exception {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }
    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (Exception exception) {
            throw new Exception("Closing of connection ended with exceptions: " + exception.getMessage());
        }
    }

    private void initDatabase() throws Exception {
        try {
            setData("CREATE TABLE if not exists Persons (" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "address TEXT NOT NULL, " +
                    "name TEXT NOT NULL, " +
                    "surname TEXT NOT NULL);"
            );

            setData("CREATE TABLE if not exists Books (" +
                    "id INTEGER AUTO_INCREMENT PRIMARY KEY, " +
                    "genre INT NOT NULL," +
                    "title TEXT NOT NULL, " +
                    "description TEXT NOT NULL, " +
                    "pages INT NOT NULL, " +
                    "FOREIGN KEY (author) REFERENCES Persons(id));"
            );
        } catch (Exception exception) {
            throw new Exception("Connecting was created, but initializing of database ended with errors.");

        }
    }
}
