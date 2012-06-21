package com.gmail.kmb385.configuration;

import com.gmail.kmb385.configuration.abstracts.AbstractConfiguration;
import com.gmail.kmb385.configuration.interfaces.JdbcConfiguration;

public class JdbcConfigurationImpl extends AbstractConfiguration implements JdbcConfiguration {
	
	protected static final String DRIVER_NAME = "driver";
	protected static final String USERNAME = "username";
	protected static final String PASSWORD = "password";
	protected static final String DATABASE_SERVER = "database-server";
	protected static final String PORT = "port";
	protected static final String SID = "sid";
	/*protected static final String JNDI_NAME = "jndi-name";*/
	
	public JdbcConfigurationImpl(){
		super();
	}

	public JdbcConfigurationImpl(String configurationFileName){
		super(configurationFileName);
	}

	@Override
	public String getConnectionUrl() {
		return "jdbc:oracle:thin:@" + super.getProperty(DATABASE_SERVER) + ":" + super.getProperty(PORT) + ":"
				+ super.getProperty(SID);
	}

	@Override
	public String getPassword() {
		return super.getProperty(PASSWORD);
	}

	@Override
	public String getUserName() {
		return super.getProperty(USERNAME);
	}

	@Override
	public String getDriverName() {
		return super.getProperty(DRIVER_NAME);
	}

}
