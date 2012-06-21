package com.gmail.kmb385.session.internal.operations.interfaces;

import com.gmail.kmb385.session.abstracts.AbstractPersistenceSession;

public interface SessionOperation {

	public void perform(AbstractPersistenceSession session, Object obj);
	
}
