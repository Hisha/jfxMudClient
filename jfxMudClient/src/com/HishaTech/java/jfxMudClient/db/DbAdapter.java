package com.HishaTech.java.jfxMudClient.db;

import java.io.File;

import com.almworks.sqlite4java.SQLiteConnection;
import com.almworks.sqlite4java.SQLiteException;
import com.almworks.sqlite4java.SQLiteStatement;

public class DbAdapter {

	private static SQLiteConnection db;

	public DbAdapter() {
		db = new SQLiteConnection(new File(DbConstants.DB_NAME));
	}

	/**
	 *
	 * This method will open a connection to the database file. If the file
	 * doesn't exist it will be made. If the file does exist, the version will
	 * be checked and the database will be updated if needed.
	 *
	 * @return db (SQLiteConnection)
	 */
	public SQLiteConnection open() {

		File file = new File(DbConstants.DB_NAME);

		if (file.exists()) {

			System.out.println("Database Exists!!");

			try {
				db.open();
				UpgradeDbVersion();
			} catch (SQLiteException e) {
				System.out.println(e.toString());
			}

			return db;

		} else {

			try {
				db.open(true);
				createDB();
			} catch (SQLiteException e) {
				System.out.println(e.toString());
			}

			return db;

		}

	}

	/**
	 *
	 * This method will dispose of the existing SQLiteConnection.
	 *
	 */
	public void close() {

		db.dispose();

	}

	/**
	 *
	 * This method will create the various tables in the database.
	 *
	 */
	private void createDB() {

		try {

			db.exec(DbConstants.Begin);

			SQLiteStatement createMUD = db
					.prepare(DbConstants.CREATE_MUD_TABLE);

			createMUD.step();

			SQLiteStatement createCONNECTION = db
					.prepare(DbConstants.CREATE_CONNECTION_TABLE);

			createCONNECTION.step();

			SQLiteStatement createALIAS = db
					.prepare(DbConstants.CREATE_ALIAS_TABLE);
		
			createALIAS.step();

			db.exec(DbConstants.Commit);

			createMUD.dispose();
			createCONNECTION.dispose();
			createALIAS.dispose();

			SetDbVersion();

			System.out.println("Database Created!.");

		} catch (SQLiteException e) {

			System.out.println(e.toString());

		}

	}

	/**
	 *
	 * This method will check to see if the database is up to date, if not it
	 * will wipe the data and run the createDB method.
	 *
	 */
	private void UpgradeDbVersion() {

		if (!DbUpToDate()) {

			System.out.println("Database Out of Date.");

			try {

				db.exec("PRAGMA writable_schema = 1;");
				db.exec("delete from sqlite_master where type in ('table', 'index', 'trigger')");
				db.exec("PRAGMA writable_schema = 0;");
				db.exec("VACUUM;");
				createDB();

			} catch (Exception e) {

				System.out.println(e.toString());

			}

		}

	}

	/**
	 *
	 * This method will check the current database version verses the database
	 * version in the code.
	 *
	 * @return UpToDate (boolean)
	 */
	private boolean DbUpToDate() {

		boolean UpToDate = false;
		int dbVersion = GetDbVersion();

		if (dbVersion >= DbConstants.DB_VERSION) {

			UpToDate = true;
			System.out.println("Database Up to Date.");

		}

		return UpToDate;

	}

	/**
	 *
	 * This method will request the current database user version.
	 *
	 * @return dbVersion (int)
	 */
	private int GetDbVersion() {

		int dbVersion = 0;
		SQLiteStatement checkVer;

		try {

			checkVer = db.prepare("PRAGMA user_version;");

			while (checkVer.step()) {

				long dbVersionLong = checkVer.columnLong(0);
				dbVersion = (int) dbVersionLong;

			}

			System.out.println("Database version: " + dbVersion);

		} catch (SQLiteException e) {

			System.out.println(e.toString());

		}

		return dbVersion;

	}

	/**
	 *
	 * This method will update the database user version.
	 */
	private void SetDbVersion() {

		try {

			db.exec("PRAGMA user_version=" + DbConstants.DB_VERSION);

		} catch (SQLiteException e) {

			System.out.println(e.toString());

		}

		System.out
				.println("Database version set to: " + DbConstants.DB_VERSION);

	}

}
