package com.gmail.kmb385.connection;

import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;

public class ConnectionBuilderFactory {

	public static ConnectionBuilder createConnection(ConnectionType connectionType){
		switch (connectionType) {
		case ORACLE_JDBC:
			 return new OracleJdbcConnectionBuilder();
		case ORACLE_JNDI:
			return new OracleJndiConnectionBuilder();
		default:
			break;
		}
		throw new RuntimeException("Error: Could not find connection builder for connection type");
	}

}
