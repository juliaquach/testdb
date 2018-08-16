package com.mycompany.app;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/testdb?useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) {

        String user = "testuser";
        String password = "password";

        try {

            Connection conn = DriverManager.getConnection(DB_URL, user, password);
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE if NOT EXISTS animalsILike(name TEXT, animal TEXT)");
            statement.execute("INSERT INTO animalsILike (name, animal) VALUES('Julia', 'Dog')");
            statement.execute("INSERT INTO animalsILike (name, animal) VALUES ('Mandy', 'Fox')");
            statement.execute("INSERT INTO animalsILike (name, animal) VALUES ('Doan', 'Meerkat')");
            statement.execute("INSERT INTO animalsILike (name, animal) VALUES ('Melissa', 'None')");
            System.out.println("Code Successfully Ran");

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Something went wrong...");
        }
    }

}

