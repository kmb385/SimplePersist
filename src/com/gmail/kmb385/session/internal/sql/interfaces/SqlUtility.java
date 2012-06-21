package com.gmail.kmb385.session.internal.sql.interfaces;

import com.gmail.kmb385.session.internal.dictionary.TableDefinition;

public interface SqlUtility {

	public String createFindByIdStatement(TableDefinition tableDefinition);
	
	public String createInsertStatement(TableDefinition tableDefinition);
	
	public String createUpdateStatement(TableDefinition tableDefinition);
	
	public String createDeleteStatement(TableDefinition tableDefinition);
	
	
}
