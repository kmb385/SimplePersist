package com.gmail.kmb385.session.interfaces;

public interface PersistenceSession {

	public void insert(Object obj);
	
	public void update(Object obj);
	
	public void delete(Object obj);
	
	public void findById(Object obj, int id);
}
