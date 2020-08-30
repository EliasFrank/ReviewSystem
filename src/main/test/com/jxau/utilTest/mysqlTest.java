package com.jxau.utilTest;

import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;

public class mysqlTest {
    public static void main(String[] args) {
        Connection connection = MySQLConnection.getConnection();

        System.out.println(connection);

        MySQLConnection.close(connection);
    }
}
