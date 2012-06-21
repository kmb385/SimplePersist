package com.gmail.kmb385.session.internal;

import org.junit.Test;

import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.samples.Person;
import com.gmail.kmb385.session.PersistenceSessionImpl;
import com.gmail.kmb385.session.interfaces.PersistenceSession;

public class PersistenceSessionImplTest {

	@Test
	public void insertPersonTest() {
		Person person = new Person();

		PersistenceSession ps = new PersistenceSessionImpl(ConnectionType.ORACLE_JDBC);
		ps.insert(person);
	}

	@Test
	public void updatePersonTest() {
		Person person = new Person();

		PersistenceSession ps = new PersistenceSessionImpl(ConnectionType.ORACLE_JDBC);
		ps.update(person);
	}

	@Test
	public void deletePersonTest() {
		Person person = new Person();

		PersistenceSession ps = new PersistenceSessionImpl(ConnectionType.ORACLE_JDBC);
		ps.delete(person);
	}

	@Test
	public void findByIdTest() {
		Person person = new Person();

		PersistenceSession ps = new PersistenceSessionImpl(ConnectionType.ORACLE_JDBC);
		ps.findById(person,1);
	}

}
