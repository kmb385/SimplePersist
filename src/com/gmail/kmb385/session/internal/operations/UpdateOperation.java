package com.gmail.kmb385.session.internal.operations;

import com.gmail.kmb385.session.abstracts.AbstractPersistenceSession;
import com.gmail.kmb385.session.internal.dictionary.TableDefinition;
import com.gmail.kmb385.session.internal.operations.interfaces.SessionOperation;

public class UpdateOperation implements SessionOperation {

	@Override
	public void perform(AbstractPersistenceSession session, Object obj) {
		TableDefinition tableDefinition = session.dictionaryManager.getTableDefinition(obj.getClass().getSimpleName());
		String statement = session.sqlUtility.createUpdateStatement(tableDefinition);
		System.out.println(statement);
	}

}
