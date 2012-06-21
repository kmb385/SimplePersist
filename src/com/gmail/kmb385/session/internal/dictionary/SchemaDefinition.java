package com.gmail.kmb385.session.internal.dictionary;

import java.util.LinkedHashMap;
import java.util.Map;

public class SchemaDefinition {

	private Map<String, TableDefinition> tableDefinitions = new LinkedHashMap<String,TableDefinition>();
	
	protected SchemaDefinition(){
		
	}
	
	protected void addTable(Class<?> clazz){
		String className = clazz.getSimpleName();

		if (!this.isTableDefinitionPresent(className)) {
			TableDefinition tableDefinition = new TableDefinition(clazz);
			this.tableDefinitions.put(tableDefinition.getName(), tableDefinition);
		}
	}
	
	protected TableDefinition getTableDefinition(String name){
		if (this.isTableDefinitionPresent(name)) {
			return this.tableDefinitions.get(name);
		}
		throw new RuntimeException("Error: Table Definition for " + name + " is not available.");
	}
	
	protected boolean isTableDefinitionPresent(String name){
		return tableDefinitions.containsKey(name);
	}
}
