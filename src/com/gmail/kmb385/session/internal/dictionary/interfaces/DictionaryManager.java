package com.gmail.kmb385.session.internal.dictionary.interfaces;

import com.gmail.kmb385.session.internal.dictionary.TableDefinition;

public interface DictionaryManager {
	
	public TableDefinition getTableDefinition(String name);

	public void loadTableDefinition(Class<?> clazz);
	
}
