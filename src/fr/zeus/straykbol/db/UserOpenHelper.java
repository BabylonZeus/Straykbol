package fr.zeus.straykbol.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: babylonzeus
 * Date: 8/31/12
 * Time: 12:05 AM
 * To change this template use File | Settings | File Templates.
 */
public class UserOpenHelper extends SQLiteOpenHelper
{
	private static final int DATABASE_VERSION = 1;
	private static final String DICTIONARY_TABLE_CREATE =
			"CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
			"name TEXT, firstname TEXT, nickname TEXT);";

	UserOpenHelper(Context context) {
		super(context, "straykbolDb", null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DICTIONARY_TABLE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
	{
		//To change body of implemented methods use File | Settings | File Templates.
	}
}
