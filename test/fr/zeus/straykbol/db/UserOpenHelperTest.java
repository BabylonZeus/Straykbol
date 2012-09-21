package fr.zeus.straykbol.db;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created on 31/08/2012 12:02 AM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class UserOpenHelperTest {
	private SQLiteOpenHelper dbHelper;
	private SQLiteDatabase db;
	private Context context;

	@Before
	public void setUp() {
		context = new Activity();
		context.deleteDatabase("straykbolDb");
		dbHelper = new UserOpenHelper(context);
		db = dbHelper.getWritableDatabase();
	}

	@Test
	public void testExistenceOfUserTable() {
		Cursor c = db.rawQuery("select * from users", null);
		assertThat(c.getCount(), equalTo(0));
	}
}
