package com.wordpress.ctwart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private Connection connection;
	private Statement statement;

	public Database() {
		connect();
		createStructure();
	}

	private void createStructure() {
		DatabaseMetaData metaData;
		try {
			metaData = connection.getMetaData();
			ResultSet resultSet = metaData.getTables(null, null, "categories",
					null);

			if (!resultSet.next()) {
				statement = connection.createStatement();
				statement.executeUpdate(getStructureData());
				statement.close();
			}

			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getStructureData() {
		String createStatement = null;
		try {
			createStatement = new String(Files.readAllBytes(Paths
					.get("data/database-structure.sql")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return createStatement;
	}

	private void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:data.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addTestData() {
		String createStatement = null;
		try {
			createStatement = new String(Files.readAllBytes(Paths
					.get("data/database-test-data.sql")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			statement = connection.createStatement();
			statement.executeUpdate(createStatement);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
