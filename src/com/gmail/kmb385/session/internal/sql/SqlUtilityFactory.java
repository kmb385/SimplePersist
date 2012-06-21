package com.gmail.kmb385.session.internal.sql;

import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.session.internal.sql.interfaces.SqlUtility;

public class SqlUtilityFactory {

	public static SqlUtility createSqlUtility(ConnectionType connectionType){
		switch (connectionType) {
		case ORACLE_JDBC:
		case ORACLE_JNDI:
			return new OracleSqlUtility();
		default:
			break;
		}
		throw new RuntimeException("Error: No SQL utility found for ConnectionType " + connectionType.toString());
	}
}
