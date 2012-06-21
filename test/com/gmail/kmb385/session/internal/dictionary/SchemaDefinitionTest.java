package com.gmail.kmb385.session.internal.dictionary;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gmail.kmb385.samples.Order;

public class SchemaDefinitionTest {

	@Test
	public void addTableTest() {
		SchemaDefinition schemaDefinition = new SchemaDefinition();
		schemaDefinition.addTable(Order.class);
		
		TableDefinition tableDefinition = schemaDefinition.getTableDefinition("Order");
		assertNotNull(tableDefinition);
		assertEquals("Order", tableDefinition.getName());
	}
	
	@Test
	public void getTableDefinitionTest(){
		SchemaDefinition schemaDefinition = new SchemaDefinition();
		schemaDefinition.addTable(Order.class);
		
		TableDefinition tableDefinition = schemaDefinition.getTableDefinition("Order");
		assertNotNull(tableDefinition);
		assertEquals("Order", tableDefinition.getName());
	}
	
	@Test
	public void isTableDefinitionPresentTest(){
		SchemaDefinition schemaDefinition = new SchemaDefinition();
		schemaDefinition.addTable(Order.class);
		
		assertTrue(schemaDefinition.isTableDefinitionPresent("Order"));
		assertFalse(schemaDefinition.isTableDefinitionPresent("Not in there"));
	}

}
