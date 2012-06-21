package com.gmail.kmb385.session.internal.operations;

import com.gmail.kmb385.session.internal.operations.enums.OperationType;
import com.gmail.kmb385.session.internal.operations.interfaces.SessionOperation;

public class SessionOperationFactory {

	public static SessionOperation createOperation(OperationType operationType) {
		switch (operationType) {
		case INSERT:
			return new InsertOperation();
		case UPDATE:
			return new UpdateOperation();
		case DELETE:
			return new DeleteOperation();
		case FIND_BY_ID:
			return new FindByIdOperation();
		}
		throw new RuntimeException("Error session operation " + operationType.toString() + " not found.");
	}
}
