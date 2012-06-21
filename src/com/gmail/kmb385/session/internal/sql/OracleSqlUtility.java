package com.gmail.kmb385.session.internal.sql;

import com.gmail.kmb385.session.internal.dictionary.TableDefinition;
import com.gmail.kmb385.session.internal.sql.interfaces.SqlUtility;
import com.gmail.kmb385.util.ArrayUtil;

public class OracleSqlUtility implements SqlUtility{
	
	@Override
	public String createInsertStatement(TableDefinition tableDefinition) {
		String[] fieldColumnNames = tableDefinition.getFieldColumnNames();
		String csvColumnNames = ArrayUtil.joinArray(fieldColumnNames, ",");
		String csvPrefixColumnNames = ArrayUtil.joinArray(ArrayUtil.prefixArray(fieldColumnNames, ":"),",");
				
		StringBuilder sb = new StringBuilder();
		sb.append("insert into ").append(tableDefinition.getTableName()).append(" (");
		sb.append(csvColumnNames);
		sb.append(") values (");
		sb.append(csvPrefixColumnNames);
		sb.append(")");
		return sb.toString();
	}
	
	@Override
	public String createUpdateStatement(TableDefinition tableDefinition) {
		String[] fieldColumnNames = tableDefinition.getFieldColumnNames();
		String[] prefixedColumnNames = ArrayUtil.prefixArray(fieldColumnNames, " = :");
		String[] setStatements = ArrayUtil.suffixArray(fieldColumnNames, prefixedColumnNames);
		String setClause = ArrayUtil.joinArray(setStatements, ",");
		String whereClause = this.createPrimaryKeyWhereClause(tableDefinition);
				
		StringBuilder sb = new StringBuilder();
		sb.append("update ").append(tableDefinition.getTableName()).append(" set ");
		sb.append(setClause);
		sb.append(" where ").append(whereClause);
		return sb.toString();
	}

	@Override
	public String createDeleteStatement(TableDefinition tableDefinition) {
		String whereClause = this.createPrimaryKeyWhereClause(tableDefinition);
		
		StringBuilder sb = new StringBuilder();
		sb.append("delete from ").append(tableDefinition.getTableName()).append(" where ");
		sb.append(whereClause);
		return sb.toString();
	}

	@Override
	public String createFindByIdStatement(TableDefinition tableDefinition) {
		String[] fieldColumnNames = tableDefinition.getFieldColumnNames();
		String csvColumnNames = ArrayUtil.joinArray(fieldColumnNames, ",");
		String whereClause = this.createPrimaryKeyWhereClause(tableDefinition);
		
		StringBuilder sb = new StringBuilder();
		sb.append("select ").append(csvColumnNames).append(" from ");
		sb.append(tableDefinition.getTableName()).append(" where ");
		sb.append(whereClause);
		return sb.toString();
	}
	
	private String createPrimaryKeyWhereClause(TableDefinition tableDefinition){
		String primaryKeyColumnName = tableDefinition.getPrimaryKeyColumnName();
		return primaryKeyColumnName + " = :" + primaryKeyColumnName;
	}

}
