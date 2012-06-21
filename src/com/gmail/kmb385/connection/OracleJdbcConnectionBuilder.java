package com.gmail.kmb385.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gmail.kmb385.configuration.ConfigurationFactory;
import com.gmail.kmb385.configuration.interfaces.JdbcConfiguration;
import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;

public class OracleJdbcConnectionBuilder implements ConnectionBuilder {
	
	public OracleJdbcConnectionBuilder() {

	}

	public Connection getConnection() {
		JdbcConfiguration configuration = (JdbcConfiguration) ConfigurationFactory
				.createConfiguration(ConnectionType.ORACLE_JDBC);
		Connection connection = null;
		try {
			Class.forName(configuration.getDriverName());
			connection = DriverManager.getConnection(configuration.getConnectionUrl(), configuration.getUserName(),
					configuration.getPassword());
		} catch (SQLException e) {
			throw new RuntimeException("Error: Could not connect to Oracle Database with URL"
					+ configuration.getConnectionUrl());
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Error: Oracle Database Driver could not be found.  Please add the library.");
		}
		return connection;
	}


	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error: Could not close database connection.");
		}
	}

}
