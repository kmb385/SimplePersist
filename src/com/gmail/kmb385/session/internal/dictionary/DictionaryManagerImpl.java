package com.gmail.kmb385.session.internal.dictionary;

import com.gmail.kmb385.session.internal.dictionary.interfaces.DictionaryManager;


public class DictionaryManagerImpl implements DictionaryManager {

	private SchemaDefinition schemaDefinition = new SchemaDefinition();

	public TableDefinition getTableDefinition(String name) {
		return this.schemaDefinition.getTableDefinition(name);
	}


	public void loadTableDefinition(Class<?> clazz) {
		this.schemaDefinition.addTable(clazz);
	}
}
