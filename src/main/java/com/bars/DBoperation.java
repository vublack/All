package com.bars;
import java.sql.*;

public class DBoperation {
    Connection conn = null;
    public void setupDBconection (String dbName) throws SQLException {
//        Задаем параметры подключения: URL, имя пользователя и пароль
        String url = ConfigProperties.getTestProperty(dbName+"_DB_URL");
        String userName = ConfigProperties.getTestProperty(dbName+"_DB_USERNAME");
        String password = ConfigProperties.getTestProperty(dbName+"_DB_PASSWORD");

//        Регистриуем драйвер с помощью статического инициализатора
        // Register JDBC driver (JDBC driver name and Database URL)
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
//        Создаем подключение, передавая в getConnection() параметры
        conn = DriverManager.getConnection(url, userName, password);
        System.out.println("Connection successful");
        if (conn == null) {
            System.out.println("Нет соединения с БД!");
            System.exit(0);
        }
    }
    public void closeConn() {
        try {
            conn.close();
        } catch (SQLException var23) {
            var23.printStackTrace();
            System.out.println("all");
        }
    }
/*
    public String selectFromDB (String sqlScript, String columnLabel) throws SQLException {
        String selectStringValue = null;

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlScript);
            while(resultSet.next()){
                selectStringValue = resultSet.getString(columnLabel);
                System.out.println(selectStringValue);
            }
        return selectStringValue;
    }
    */

    public String selectFromDB (String sqlScript, String columnLabel) throws SQLException {
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlScript);
        String selectStringValue = null;
        while (resultSet.next()) {
            selectStringValue = resultSet.getString(columnLabel);
            System.out.println(selectStringValue);
        }
        return selectStringValue;
    }
}
