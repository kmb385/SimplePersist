package com.gmail.kmb385.session.internal.dictionary;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.gmail.kmb385.annotations.Table;

public class TableDefinition {

	private String name;
	private String tableName;
	private Map<String, FieldDefinition> fieldDefinitions = new LinkedHashMap<String, FieldDefinition>();

	protected TableDefinition(String name) {
		this.name = name;
	}

	protected TableDefinition(Class<?> clazz) {
		this.name = clazz.getSimpleName();
		this.tableName = this.getTableName(clazz);
		this.loadFieldDefinitions(clazz);
	}

	public String getTableName() {
		return tableName;
	}
	
	public String[] getFieldNames() {
		Map<String, FieldDefinition> map = this.getFieldDefinitions();
		return map.keySet().toArray(new String[map.size()]);
	}

	public String[] getFieldColumnNames() {
		List<String> list = new LinkedList<String>();
		for (FieldDefinition fieldDefinition : this.fieldDefinitions.values()) {
			list.add(fieldDefinition.getColumnName());
		}
		return list.toArray(new String[list.size()]);
	}
	
	public String getPrimaryKeyColumnName(){
		for (FieldDefinition fieldDefinition : this.fieldDefinitions.values()) {
			if(fieldDefinition.isPrimaryKey()){
				return fieldDefinition.getColumnName();
			}
		}
		throw new RuntimeException("Error: No primary key found for TableDefinition " + name);
	}
	

	protected String getName() {
		return name;
	}

	protected Map<String, FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	protected void addField(FieldDefinition fieldDefinition) {
		fieldDefinitions.put(fieldDefinition.getName(), fieldDefinition);
	}

	protected FieldDefinition getFieldDefinition(String fieldName) {
		return fieldDefinitions.get(fieldName);
	}

	private String getTableName(Class<? extends Object> clazz) {
		Table tableAnnotation = clazz.getAnnotation(Table.class);
		if (tableAnnotation != null) {
			return tableAnnotation.name();
		}
		throw new RuntimeException("ERROR: Class " + clazz.getName() + " does not contain @Table annotation.");
	}

	private void loadFieldDefinitions(Class<?> clazz) {
		for (Field field : clazz.getDeclaredFields()) {
			this.addField(new FieldDefinition(field));
		}
	}
}
