package com.HishaTech.java.jfxMudClient.db;

public class DbConstants {

	// ** Overall Database Related ** //
	public final static String DB_NAME = "jfxMudClient.db";
	public final static int DB_VERSION = 1;
	public final static String Begin = "BEGIN TRANSACTION;";
	public final static String Commit = "COMMIT;";

	// ** Mud Table Related ** //
	public final static String DATABASE_MUD_TABLE = "mud_table";
	public final static String MUD_rowId = "_id";
	public final static String MUD_Name = "name";
	public final static String MUD_Description = "description";
	public final static String MUD_IPAddress = "ip_address";
	public final static String MUD_Port = "port";
	public final static String MUD_TABLE_SELECTALL = MUD_rowId + "," + MUD_Name
			+ "," + MUD_Description + "," + MUD_IPAddress + "," + MUD_Port;
	public final static String CREATE_MUD_TABLE = "CREATE TABLE if NOT EXISTS "
			+ DATABASE_MUD_TABLE + " (" + MUD_rowId
			+ " integer primary key not null," + MUD_Name
			+ " varchar(50) not null," + MUD_Description
			+ " varchar(2500) not null," + MUD_IPAddress
			+ " varchar(50) not null," + MUD_Port + " varchar(7) not null"
			+ ");";

	// ** Connection Table Related ** //
	public final static String DATABASE_CONNECTION_TABLE = "connection_table";
	public final static String CONNECTION_rowId = "_id";
	public final static String CONNECTION_mudId = "mudid";
	public final static String CONNECTION_UserName = "username";
	public final static String CONNECTION_Password = "password";
	public final static String CONNECTION_TABLE_SELECTALL = CONNECTION_rowId
			+ "," + CONNECTION_mudId + "," + CONNECTION_UserName + ","
			+ CONNECTION_Password;
	public final static String CREATE_CONNECTION_TABLE = "CREATE TABLE if NOT EXISTS "
			+ DATABASE_CONNECTION_TABLE
			+ " ("
			+ CONNECTION_rowId
			+ " integer primary key not null,"
			+ CONNECTION_mudId
			+ " integer not null,"
			+ CONNECTION_UserName
			+ "varchar(50) not null,"
			+ CONNECTION_Password
			+ "varchar(50) not null" + ");";

	// ** Alias Table Related ** //
	public final static String DATABASE_ALIAS_TABLE = "alias_table";
	public final static String ALIAS_rowId = "_id";
	public final static String ALIAS_connectionId = "connectionid";
	public final static String ALIAS_From = "from";
	public final static String ALIAS_To = "to";
	public final static String ALIAS_TABLE_SELECTALL = ALIAS_rowId + ","
			+ ALIAS_connectionId + "," + ALIAS_From + "," + ALIAS_To;
	public final static String CREATE_ALIAS_TABLE = "CREATE TABLE if NOT EXISTS "
			+ DATABASE_ALIAS_TABLE
			+ " ("
			+ ALIAS_rowId
			+ " integer primary key not null,"
			+ ALIAS_connectionId
			+ " integer not null,"
			+ ALIAS_From
			+ "varchar(50) not null,"
			+ ALIAS_To + "varchar(250) not null" + ");";

}
