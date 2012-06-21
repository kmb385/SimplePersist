package com.gmail.kmb385.configuration;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.gmail.kmb385.connection.enums.ConnectionType;

public class ConfigurationFactoryTest {

	@Test
	public void createConfigurationTest() {
		for(ConnectionType connectionType : ConnectionType.values()){
			assertNotNull(ConfigurationFactory.createConfiguration(connectionType));
		}
	}

}
