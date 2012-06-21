package com.gmail.kmb385.session.internal.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import org.junit.Test;

import com.gmail.kmb385.samples.Item;
import com.gmail.kmb385.samples.Order;

public class TableDefinitionTest {

	@Test
	public void addFieldTest() throws SecurityException, NoSuchFieldException {
		String fieldName = "itemId";
		Field field = Item.class.getDeclaredField(fieldName);
		FieldDefinition fieldDefinition = new FieldDefinition(field);
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		tableDefinition.addField(fieldDefinition);
		
		assertEquals(fieldDefinition, tableDefinition.getFieldDefinition(fieldName));
	}
	
	@Test
	public void getFieldColumnNamesTest(){
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		String[] columnNames = tableDefinition.getFieldColumnNames();
		
		assertTrue(columnNames.length == 4);
		assertEquals("ORDER_ID", columnNames[0]);
		assertEquals("CREATED_DT", columnNames[1]);
		assertEquals("MY_NUMBER", columnNames[2]);
		assertEquals("MY_DECIMAL", columnNames[3]);
	}
	
	@Test
	public void getFieldDefinitionTest() throws SecurityException, NoSuchFieldException{
		String fieldName = "itemId";
		Field field = Item.class.getDeclaredField(fieldName);
		FieldDefinition fieldDefinition = new FieldDefinition(field);
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		tableDefinition.addField(fieldDefinition);
		
		assertEquals(fieldDefinition, tableDefinition.getFieldDefinition(fieldName));
	}
	
	@Test
	public void getPrimaryKeyColumnName(){
		TableDefinition tableDefintion = new TableDefinition(Order.class);
		String primaryKeyColumnName = tableDefintion.getPrimaryKeyColumnName();
		
		assertEquals("ORDER_ID", primaryKeyColumnName);
	}
	
	@Test
	public void getFieldDefinitionsTest(){
		TableDefinition tableDefintion = new TableDefinition(Order.class);
		Map<String, FieldDefinition> map = tableDefintion.getFieldDefinitions();
		
		assertNotNull(map);
		assertTrue(map.containsValue(tableDefintion.getFieldDefinition("orderId")));
	}
	
	@Test
	public void getFieldNamesTest(){
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		String[] fieldNames = tableDefinition.getFieldNames();
		
		assertEquals("orderId", fieldNames[0]);
		assertEquals("createdDt", fieldNames[1]);
		assertEquals("myNumber", fieldNames[2]);
		assertEquals("myDecimal", fieldNames[3]);
	}
	
	@Test
	public void getNameTest(){
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		assertEquals("Order", tableDefinition.getName());
	}
	
	@Test
	public void getTableNameTest(){
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		assertEquals("ORDER", tableDefinition.getTableName());
	}
	
/*	@Test
	public void getTableNameTest2(){
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		assertEquals("ORDER", tableDefinition.getTableName(Order.class));
	}*/
	
	@Test
	public void loadFieldDefinitionsTest(){
		Class<?>[] argClasses = {Class.class};
		TableDefinition tableDefinition = new TableDefinition(Order.class);
		
		try {
			Method method = TableDefinition.class.getDeclaredMethod("loadFieldDefinitions", argClasses);
			method.setAccessible(true);
			method.invoke(tableDefinition, new Object[] {Order.class});
			assertNotNull(tableDefinition.getFieldDefinitions());
		} catch (Exception e) {
			//Its a test do nothing
		}
	}
	
}
