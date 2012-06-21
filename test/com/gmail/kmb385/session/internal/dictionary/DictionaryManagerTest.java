package com.gmail.kmb385.session.internal.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.kmb385.samples.Order;
import com.gmail.kmb385.session.internal.dictionary.DictionaryManagerImpl;

public class DictionaryManagerTest {

	@Test
	public void loadTableDefinitionTest() {
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Order.class);
		
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Order.class.getSimpleName());
		
		assertNotNull(tableDefinition);
		assertEquals("Order", tableDefinition.getName());
	}
	
	@Test
	public void getTableDefinitionTest(){
		DictionaryManagerImpl dictionaryManager = new DictionaryManagerImpl();
		dictionaryManager.loadTableDefinition(Order.class);
		
		TableDefinition tableDefinition = dictionaryManager.getTableDefinition(Order.class.getSimpleName());
		
		assertNotNull(tableDefinition);
		assertEquals("Order", tableDefinition.getName());
	}

}
