package com.gmail.kmb385.configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.gmail.kmb385.configuration.interfaces.JdbcConfiguration;

public class JdbcConfigurationTest {

	@Test
	public void testSimpleJDBCConfiguration() {
		JdbcConfiguration configuration = new JdbcConfigurationImpl("test.properties");
		assertNotNull(configuration);
		assertEquals("password", configuration.getPassword());
		assertEquals("user", configuration.getUserName());
		assertEquals("oracle.jdbc.driver.OracleDriver", configuration.getDriverName());
		assertEquals("jdbc:oracle:thin:@localhost:1542:XE", configuration.getConnectionUrl());
		assertEquals("test", configuration.getMode());
	}

}
  	