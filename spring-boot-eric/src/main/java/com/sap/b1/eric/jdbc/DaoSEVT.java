package com.sap.b1.eric.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

@Repository
public class DaoSEVT {
	private final String SQL_SEVT_GET = "select \"SequenceID\", \"SourceDB\", \"Timestamp\", \"Status\", \"Retry\", \"ObjectType\", \"TransType\", \"FieldsInKe\", \"FieldNames\", \"FieldValue\", \"UserID\", \"USER_CODE\" from SEVT";
	private final String HANA_DB_DRIVER = "com.sap.db.jdbc.Driver";
	
	private String schema;
	
	@Value("${spring.datasource.driver-class-name}")
	private String DbDriver;
	
	private boolean isHANA()
	{
		return DbDriver.equalsIgnoreCase(HANA_DB_DRIVER);
	}
	
	public final void setSchema(String schema) {
		this.schema = schema;
	}
	
	public String getSchema()
	{
		if(isHANA())
		{
			return "set schema \"SBOCOMMON\"";
		}
		else
		{
			return "use \"SBO-COMMON\"";
		}
		
		//TODO: why below this.schema is null?
		//return "set schema \"" + this.schema+ "\"";
	}

	@Autowired
	DataSource dataSource;
	
	public List<SEVTRecord> getData() throws Exception{
		try(Connection conn = DataSourceUtils.doGetConnection(dataSource)){
			Statement stat = conn.createStatement();
			stat.execute(getSchema());
			ResultSet rs = stat.executeQuery(SQL_SEVT_GET);
			List<SEVTRecord> records = SEVTRecord.fromRecordSet(rs);
			rs.close();
			stat.close();
			return records;
		}
	}
}
