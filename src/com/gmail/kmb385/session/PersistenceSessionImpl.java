package com.gmail.kmb385.session;

import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;
import com.gmail.kmb385.session.abstracts.AbstractPersistenceSession;
import com.gmail.kmb385.session.interfaces.PersistenceSession;
import com.gmail.kmb385.session.internal.dictionary.interfaces.DictionaryManager;
import com.gmail.kmb385.session.internal.operations.enums.OperationType;
import com.gmail.kmb385.session.internal.sql.interfaces.SqlUtility;

public class PersistenceSessionImpl extends AbstractPersistenceSession implements PersistenceSession {
	
	ConnectionBuilder connectionBuilder;
	SqlUtility sqlUtility;
	DictionaryManager dictionaryManager;
	
	public PersistenceSessionImpl(ConnectionType connectionType){
		super(connectionType);
	}
	
	@Override
	public void insert(Object obj) {
		this.performOperation(OperationType.INSERT, obj);
	}

	@Override
	public void update(Object obj) {
		this.performOperation(OperationType.UPDATE, obj);
	}

	@Override
	public void delete(Object obj) {
		this.performOperation(OperationType.DELETE, obj);
	}

	@Override
	public void findById(Object obj, int id) {
		this.performOperation(OperationType.FIND_BY_ID, obj);
	}

}
