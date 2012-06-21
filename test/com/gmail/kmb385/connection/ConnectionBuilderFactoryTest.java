package com.gmail.kmb385.connection;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;

public class ConnectionBuilderFactoryTest {

	@Test
	public void test() {
		for(ConnectionType connectionType: ConnectionType.values()){
			ConnectionBuilder connectionBuilder = ConnectionBuilderFactory.createConnection(connectionType);
			assertNotNull(connectionBuilder);
		}
	}

}
