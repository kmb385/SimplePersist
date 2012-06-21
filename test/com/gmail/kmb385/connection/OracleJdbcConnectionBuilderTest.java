package com.gmail.kmb385.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;

public class OracleJdbcConnectionBuilderTest {

	@Test
	public void getConnectionTest() {
		ConnectionBuilder connectionBuilder = new OracleJdbcConnectionBuilder();
		Connection connection = connectionBuilder.getConnection();
		assertNotNull(connection);
		try {
			assertNotNull(connection.createStatement());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connectionBuilder.closeConnection(connection);
	}
	
	@Test(expected = SQLException.class)
	public void closeConnectionTest() throws SQLException{
		ConnectionBuilder connectionBuilder = new OracleJdbcConnectionBuilder();
		Connection connection = connectionBuilder.getConnection();
		connectionBuilder.closeConnection(connection);
		
		connection.createStatement();
	}

}
