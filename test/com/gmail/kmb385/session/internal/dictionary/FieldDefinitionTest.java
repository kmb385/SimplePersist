package com.gmail.kmb385.session.internal.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Field;

import org.junit.Test;

import com.gmail.kmb385.samples.Order;

public class FieldDefinitionTest {

	@Test
	public void getNameTest() throws SecurityException, NoSuchFieldException {
		String name = "orderId";
		Field field = Order.class.getDeclaredField(name);
		FieldDefinition fieldDefinition = new FieldDefinition(field);
		
		assertNotNull(fieldDefinition.getName());
		assertEquals(name, fieldDefinition.getName());
	}
	
	@Test
	public void getColumnNameTest() throws Exception, NoSuchFieldException {
		String columnName = "ORDER_ID";
		Field field = Order.class.getDeclaredField("orderId");
		FieldDefinition fieldDefinition = new FieldDefinition(field);
		
		assertNotNull(fieldDefinition.getColumnName());
		assertEquals(columnName, fieldDefinition.getColumnName());
	}
	
	@Test
	public void getTypeTest() throws SecurityException, NoSuchFieldException {
		String type = "int";
		Field field = Order.class.getDeclaredField("orderId");
		FieldDefinition fieldDefinition = new FieldDefinition(field);

		assertNotNull(fieldDefinition.getType());
		assertEquals(type, fieldDefinition.getType());
	}
	
	@Test
	public void isPrimaryKeyTest() throws SecurityException, NoSuchFieldException {
		boolean isPrimaryKey = true;
		Field field = Order.class.getDeclaredField("orderId");
		FieldDefinition fieldDefinition = new FieldDefinition(field);

		
		assertNotNull(fieldDefinition.isPrimaryKey());
		assertEquals(isPrimaryKey, fieldDefinition.isPrimaryKey());
	}
	
}
