package com.gmail.kmb385.session.internal.sql;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.gmail.kmb385.samples.Person;
import com.gmail.kmb385.session.internal.dictionary.DictionaryManagerImpl;
import com.gmail.kmb385.session.internal.dictionary.TableDefinition;

public class SqlUtilityTest {

	@Test
	public void createInsertStatementTest(){
		String expectedSql = "insert into PERSON (PERSON_ID,FIRST_NAME,LAST_NAME,AGE,DATE_OF_BIRTH,CREATED_DT,CREATED_BY) values (:PERSON_ID,:FIRST_NAME,:LAST_NAME,:AGE,:DATE_OF_BIRTH,:CREATED_DT,:CREATED_BY)";
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Person.class);
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Person.class.getSimpleName());
		
		OracleSqlUtility sqlUtility = new OracleSqlUtility();
		String actualSql = sqlUtility.createInsertStatement(tableDefinition);
		assertEquals(expectedSql, actualSql);
	}
	
	@Test
	public void createUpdateStatementTest(){
		String expectedSql = "update PERSON set PERSON_ID = :PERSON_ID,FIRST_NAME = :FIRST_NAME,LAST_NAME = :LAST_NAME,AGE = :AGE,DATE_OF_BIRTH = :DATE_OF_BIRTH,CREATED_DT = :CREATED_DT,CREATED_BY = :CREATED_BY where PERSON_ID = :PERSON_ID";
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Person.class);
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Person.class.getSimpleName());
		
		OracleSqlUtility sqlUtility = new OracleSqlUtility();
		String actualSql = sqlUtility.createUpdateStatement(tableDefinition);
		assertEquals(expectedSql, actualSql);
	}
	
	@Test
	public void createDeleteStatementTest(){
		String expectedSql = "delete from PERSON where PERSON_ID = :PERSON_ID";
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Person.class);
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Person.class.getSimpleName());
		
		OracleSqlUtility sqlUtility = new OracleSqlUtility();
		String actualSql = sqlUtility.createDeleteStatement(tableDefinition);
		assertEquals(expectedSql, actualSql);
	}
	
	@Test
	public void createFindByIdStatement(){
		String expectedSql = "select PERSON_ID,FIRST_NAME,LAST_NAME,AGE,DATE_OF_BIRTH,CREATED_DT,CREATED_BY from PERSON where PERSON_ID = :PERSON_ID";
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Person.class);
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Person.class.getSimpleName());
		
		OracleSqlUtility sqlUtility = new OracleSqlUtility();
		String actualSql = sqlUtility.createFindByIdStatement(tableDefinition);
		assertEquals(expectedSql, actualSql);
	}
}
