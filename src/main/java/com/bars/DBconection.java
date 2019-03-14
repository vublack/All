package com.bars;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconection {
    public static void main (String[] args) throws ClassNotFoundException, SQLException {
//        Задаем параметры подключения: URL, имя пользователя и пароль
        String url = "jdbc:oracle:thin:@10.10.17.41:1521:BARS01";
        String userName = "bars";
        String password = "barsbars";

//        Регистриуем драйвер с помощью статического инициализатора
        // Register JDBC driver (JDBC driver name and Database URL)
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;
        }
//        RC_DB_URL=jdbc:oracle:thin:@10.10.17.41:1521:BARS01
//        RC_DB_USERNAME=bars
//        RC_DB_PASSWORD=barsbars

//        Создаем подключение, передавая в getConnection() параметры
        try(Connection conn = DriverManager.getConnection(url, userName, password)) {
            System.out.println("Connection successful");
        }
    }
}
