package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class SQLConnectionCreator {
    private static final String HOST = "localhost";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";
    private static final String PORT = "3306";
    private static final String DB_NAME = "users";

    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");//1 - неименованная строковая константа
        // 2 - ты посчитал, сколько раз у тебя будет выполнять этот оператор, который должен выполняться только один раз?
        Connection connection = DriverManager.getConnection("jdbc:mysql://"+ HOST +":"+ PORT +"/"+
                        DB_NAME+"?autoReconnect=true&useSSL=false", LOGIN, PASSWORD);
        return connection;
    }

    private SQLConnectionCreator() {
    }
}
