package fr.zeus.straykbol.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created on 03/09/2012 9:48 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class UserAdapter {
	private UserOpenHelper dbHelper;
	private SQLiteDatabase db;

	private Context context;

	public UserAdapter(Context c) {
		context = c;
	}

	public void close() {
		dbHelper.close();
	}

	public UserAdapter openToWrite() throws android.database.SQLException {
		dbHelper = new UserOpenHelper(context);
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public long addUser(String name, String firstname, String nickname) {
		ContentValues content = new ContentValues();
		content.put("name", name);
		content.put("firstname", firstname);
		content.put("nickname", nickname);
		return db.insert("users", null, content);
	}

	public Integer getUserId(String name, String firstname, String nickname) {
		Cursor c = db.query(true, "users", new String[]{"id"}, "name=\"" + name + "\"", null, null, null, null, null);
		if (c.getCount() > 1) {
			return -1;
		}
		c.moveToNext();
		return c.getInt(0);
	}

	public String getNameFromId(Integer id) {
		Cursor c = db.query(true, "users", new String[]{"name"}, "id=" + id + "", null, null, null, null, null);
		if (c.getCount() > 1) {
			return null;
		}
		c.moveToNext();
		return c.getString(0);
	}
}
