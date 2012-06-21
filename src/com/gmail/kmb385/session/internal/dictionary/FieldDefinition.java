package com.gmail.kmb385.session.internal.dictionary;

import java.lang.reflect.Field;

import com.gmail.kmb385.annotations.Column;
import com.gmail.kmb385.annotations.PrimaryKey;

public class FieldDefinition {

	private String name;
	private String type;
	private String columnName;
	private boolean primaryKey = false;

	protected FieldDefinition(Field field){
		if (field.isAnnotationPresent(Column.class)) {
			Column columnAnnotation = field.getAnnotation(Column.class);
			boolean isPrimaryKey = field.isAnnotationPresent(PrimaryKey.class);
			
			this.name = field.getName();
			this.columnName = columnAnnotation.name();
			this.type = field.getType().getSimpleName();
			this.primaryKey = isPrimaryKey;
		}else{
			throw new RuntimeException("Error: Field " + field.getName() + " does not contain @Column annotation");
		}

	}

	protected String getName() {
		return name;
	}

	protected String getType() {
		return type;
	}

	protected String getColumnName() {
		return columnName;
	}

	protected boolean isPrimaryKey() {
		return primaryKey;
	}

}
