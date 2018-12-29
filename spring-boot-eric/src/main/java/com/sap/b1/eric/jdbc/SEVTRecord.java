package com.sap.b1.eric.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class SEVTRecord {
	
	public static final String[] fieldList = {"SequenceID", "SourceDB", "Timestamp", "Status", "Retry", "ObjectType", "TransType", "FieldsInKe", "FieldNames", "FieldValue", "UserID", "USER_CODE"};
	
	private final int sequenceID;
	
	private final String sourceDB;
	
	private final String timeStamp;
	
	private final String status;
	
	private final int retry;
	
	private final String objectType;
	
	private final String transType;
	
	private final String fieldsInKey;
	
	private final String fieldNames;
	
	private final String fieldValue;
	
	private final String userID;
	
	public SEVTRecord(int sequenceID, String sourceDB, String timeStamp, String status, int retry,
			String objectType, String transType, String fieldsInKey, String fieldNames, String fieldValue, String userID,
			String userCode) {
		super();
		this.sequenceID = sequenceID;
		this.sourceDB = sourceDB;
		this.timeStamp = timeStamp;
		this.status = status;
		this.retry = retry;
		this.objectType = objectType;
		this.transType = transType;
		this.fieldsInKey = fieldsInKey;
		this.fieldNames = fieldNames;
		this.fieldValue = fieldValue;
		this.userID = userID;
		this.userCode = userCode;
	}

	private final String userCode;

	public final int getSequenceID() {
		return sequenceID;
	}

	public final String getSourceDB() {
		return sourceDB;
	}

	public final String getTimeStamp() {
		return timeStamp;
	}

	public final String getStatus() {
		return status;
	}

	public final int getRetry() {
		return retry;
	}

	public final String getObjectType() {
		return objectType;
	}

	public final String getTransType() {
		return transType;
	}

	public final String getFieldsInKey() {
		return fieldsInKey;
	}

	public final String getFieldNames() {
		return fieldNames;
	}

	public final String getFieldValue() {
		return fieldValue;
	}

	public final String getUserID() {
		return userID;
	}

	public final String getUserCode() {
		return userCode;
	}

	public static List<SEVTRecord> fromRecordSet(ResultSet rs) throws SQLException
	{
		List<SEVTRecord> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new SEVTRecord(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
					rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), 
					rs.getString(11), rs.getString(12)));
		}
		
		return list;
	}

}
