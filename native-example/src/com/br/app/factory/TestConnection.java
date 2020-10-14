package com.br.app.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
	public void testConnection() throws SQLException {
	    Connection connection = new ConnectionFactory().getConn();
	    System.out.println("JDBC Connection OK!");
	    connection.close();
	}
}
