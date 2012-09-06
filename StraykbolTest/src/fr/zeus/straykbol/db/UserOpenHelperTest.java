package fr.zeus.straykbol.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.test.AndroidTestCase;
import fr.zeus.straykbol.db.UserOpenHelper;

/**
 * Created with IntelliJ IDEA.
 * User: babylonzeus
 * Date: 8/31/12
 * Time: 12:02 AM
 * To change this template use File | Settings | File Templates.
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
