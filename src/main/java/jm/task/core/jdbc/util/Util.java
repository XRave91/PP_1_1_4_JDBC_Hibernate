package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private Connection conn ;

    public Util() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?" +
                "user=xrave&password=1.Abcdef");
    }
    public Connection getConnection() {
        return conn;
    }
}
