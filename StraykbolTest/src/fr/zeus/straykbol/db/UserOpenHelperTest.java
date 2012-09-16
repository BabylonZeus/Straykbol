package fr.zeus.straykbol.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;

/**
 * Created on 31/08/2012 12:02 AM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class UserOpenHelperTest extends AndroidTestCase {
	private SQLiteOpenHelper dbHelper;
	private SQLiteDatabase db;

	@Override
	protected void setUp() {
		getContext().deleteDatabase("straykbolDb");
		dbHelper = new UserOpenHelper(getContext());
		db = dbHelper.getWritableDatabase();
	}

	public void testExistenceOfUserTable() {
		Cursor c = db.rawQuery("select * from users", null);
		assertEquals(0, c.getCount());
	}
}
