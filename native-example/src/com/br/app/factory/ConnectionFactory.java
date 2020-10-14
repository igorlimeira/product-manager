package com.br.app.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionFactory {
	private static ConnectionFactory db;
	private Connection conn;
	private PreparedStatement ps;
	protected ResultSet rs;

	public ConnectionFactory() {

	}
	
	public static ConnectionFactory getConnectionFactory() {
		if (db == null) {
			db = new ConnectionFactory();
		}
		return db;
	}
	public int executeUpdate(String sql) {
		int result = -1;
		if (getConn() == null) {
			return result;
		}
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int executeUpdate(String sql, Object[] obj) {
		int result = -1;
		if (getConn() == null) {
			return result;
		}
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			result = ps.executeUpdate();
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultSet executeQuery(String sql) {
		if (getConn() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet executeQuery(String sql, Object[] obj) {
		if (getConn() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	public boolean exeute(String sql) {
		if (getConn() == null) {
			return false;
		}
		try {
			Statement statement = conn.createStatement();
			statement.execute(sql);
			statement.close();
			return true;
		} catch (SQLException e) {
//			e.printStackTrace();
			return false;
		}
	}

	protected Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				System.out.println("Conexão com o banco aberta!");
				conn = DriverManager.getConnection("jdbc:mysql://dbdev.crkb0f0v3qft.sa-east-1.rds.amazonaws.com:3306/DBDEV", "admin", "admin142536");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
			System.out.println("Conexão com o banco encerrada!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	protected ResultSet rs;
//	
//	public ConnectionFactory() {
//		init();
//	}
//	
//	private void init() {
//	}
//
//	public Connection getConnection() {
//		try {
//			return DriverManager.getConnection(
//					"jdbc:mysql://dbdev.crkb0f0v3qft.sa-east-1.rds.amazonaws.com:3306/DBDEV", "admin", "admin142536");
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	protected void destroy() {
//		try {
//			if (rs != null) {
//				rs.close();
//			}
//		} catch (SQLException se) {
//			se.printStackTrace();
//		}
//	}
}
