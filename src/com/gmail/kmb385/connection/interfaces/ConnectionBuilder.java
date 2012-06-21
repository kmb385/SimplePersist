package com.gmail.kmb385.connection.interfaces;

import java.sql.Connection;

public interface ConnectionBuilder {
	
	public Connection getConnection();
	
	public void closeConnection(Connection connection);
	
}
