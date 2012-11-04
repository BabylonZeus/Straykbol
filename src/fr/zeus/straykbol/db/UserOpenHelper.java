package fr.zeus.straykbol.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created on 31/08/2012 12:05 AM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class UserOpenHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String USERS_TABLE_NAME = "users";
	public static final String DICTIONARY_TABLE_CREATE =
			"CREATE TABLE " + USERS_TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
					"name TEXT, firstname TEXT, nickname TEXT);";

	UserOpenHelper(Context context) {
		super(context, "straykbolDb", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		if (!existsUsersTable())
			db.execSQL(DICTIONARY_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	public Boolean existsUsersTable()
	{
		return existsTable(USERS_TABLE_NAME);
	}

	public Boolean existsTable(String tableName) {
		Cursor cursor = this.getReadableDatabase().rawQuery("select DISTINCT tbl_name from sqlite_master where tbl_name = '" + tableName + "'", null);
		if(cursor != null) {
			if(cursor.getCount() > 0) {
				cursor.close();
				return true;
			}
			cursor.close();
		}
		return false;
	}
}
