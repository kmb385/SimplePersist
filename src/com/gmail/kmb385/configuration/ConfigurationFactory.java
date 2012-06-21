package com.gmail.kmb385.configuration;

import com.gmail.kmb385.configuration.abstracts.AbstractConfiguration;
import com.gmail.kmb385.connection.enums.ConnectionType;

public class ConfigurationFactory {

	public static AbstractConfiguration createConfiguration(ConnectionType type) {
		
		switch (type) {
		case ORACLE_JDBC:
			return new JdbcConfigurationImpl();
		case ORACLE_JNDI:
			return new JndiConfigurationImpl();
		default:
			break;
		}
		
		throw new RuntimeException("Error: Unrecongized Connection Type.");
	}	
}
