package com.clientname.projectname.genricutil.DataBaseUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection conn;

	public void getConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			conn = DriverManager.getConnection("url", "username", "pass");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeConnection() {
		try {
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public ResultSet executeSelectQuery(String query) {
		ResultSet resultSet = null;
		try {

			Statement stat = conn.createStatement();
			resultSet = stat.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public int executeNonSelectQuery(String query) {
		int executeUpdate = 0;
		try {
			Statement stat = conn.createStatement();
			executeUpdate = stat.executeUpdate(query);
			return executeUpdate;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return executeUpdate;
	}
}
