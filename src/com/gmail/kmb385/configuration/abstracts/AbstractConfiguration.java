package com.gmail.kmb385.configuration.abstracts;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractConfiguration {

	private static final String MODE = "mode";

	private static final String CONFIG_FILE = "simple-persist.properties";

	private Properties properties = new Properties();
	
	public AbstractConfiguration(){
		this.loadProperties(CONFIG_FILE);
	}

	public AbstractConfiguration(String configurationFileName){
		this.loadProperties(configurationFileName);
	}
	
	protected void loadProperties(String configurationFileName) {
		try {
			// load the properties file
			properties.load(ClassLoader.getSystemResourceAsStream(configurationFileName));
		} catch (IOException ex) {
			throw new RuntimeException("Error: Properties file " + configurationFileName + " not found.");
		}catch(Exception ex){
			ex.printStackTrace();
			throw new RuntimeException("Error: Properties file " + configurationFileName + " not found.");
			
		}
	}

	public String getMode() {
		return this.getProperty(MODE);
	}

	protected String getProperty(String propertyName) {
		String property = properties.getProperty(propertyName);
		if (property == null) {
			throw new RuntimeException("Error: Property not found: " + propertyName + ". Please specify property in "
					+ CONFIG_FILE + ".");
		}
		return property;
	}
}
