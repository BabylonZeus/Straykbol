package fr.zeus.straykbol.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.HashMap;
import java.util.Map;

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

	public Integer getUserIdByName(String name) {
		Cursor c = db.query(true, "users", new String[]{"id"}, "name=\"" + name + "\"", null, null, null, null, null);
		if (c.getCount() > 1) {
			return -1;
		}
		c.moveToNext();
		return c.getInt(0);
	}
	public Integer getUserIdByNickname(String nickname)
	{
		Cursor c = db.query(true, "users", new String[]{"id"}, "nickname=\"" + nickname + "\"", null, null, null, null, null);
		if (c.getCount() > 1) {
			return -1;
		}
		c.moveToNext();
		return c.getInt(0);
	}

	public Map<String, String> getUserById(Integer id) {
		Cursor c = db.query(true, "users", new String[]{"name", "firstname", "nickname"},
				"id=" + id + "", null, null, null, null, null);
		if (c.getCount() > 1) {
			return null;
		}
		c.moveToNext();
		Map<String, String> user = new HashMap<>();
		user.put("name", c.getString(0));
		user.put("firstname", c.getString(1));
		user.put("nickname", c.getString(2));
		return user;
	}

}
