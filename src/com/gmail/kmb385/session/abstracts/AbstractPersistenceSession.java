package com.gmail.kmb385.session.abstracts;

import java.sql.Connection;
import java.sql.SQLException;

import com.gmail.kmb385.connection.ConnectionBuilderFactory;
import com.gmail.kmb385.connection.enums.ConnectionType;
import com.gmail.kmb385.connection.interfaces.ConnectionBuilder;
import com.gmail.kmb385.session.internal.dictionary.DictionaryManagerImpl;
import com.gmail.kmb385.session.internal.dictionary.interfaces.DictionaryManager;
import com.gmail.kmb385.session.internal.operations.SessionOperationFactory;
import com.gmail.kmb385.session.internal.operations.enums.OperationType;
import com.gmail.kmb385.session.internal.operations.interfaces.SessionOperation;
import com.gmail.kmb385.session.internal.sql.NamedParameterStatement;
import com.gmail.kmb385.session.internal.sql.SqlUtilityFactory;
import com.gmail.kmb385.session.internal.sql.interfaces.SqlUtility;

public abstract class AbstractPersistenceSession {
	public ConnectionBuilder connectionBuilder;
	public SqlUtility sqlUtility;
	public DictionaryManager dictionaryManager;
	
	public AbstractPersistenceSession(ConnectionType connectionType){
		this.connectionBuilder = ConnectionBuilderFactory.createConnection(connectionType);
		this.sqlUtility = SqlUtilityFactory.createSqlUtility(connectionType);
		this.dictionaryManager = new DictionaryManagerImpl();
	}
	
	public void performOperation(OperationType operationType, Object obj){
		SessionOperation operation = SessionOperationFactory.createOperation(operationType);
		this.dictionaryManager.loadTableDefinition(obj.getClass());
		operation.perform(this, obj);
	}
	
	public NamedParameterStatement createNamedParameterStatement(Connection connection, String sqlStatement){
		try {
			return new NamedParameterStatement(connection, sqlStatement);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error: Named parameter state could not be created");
		}
	}
}
