package fr.zeus.straykbol.db;

import android.test.AndroidTestCase;
import fr.zeus.straykbol.db.UserAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: babylonzeus
 * Date: 9/3/12
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserAdapterTest extends AndroidTestCase
{
	public static final String SAMPLE_NAME = "Name of marmotte";
	public static final String SAMPLE_FIRSTNAME = "Firstname of marmotte";
	public static final String SAMPLE_NICKNAME = "Marmotte";
	public static final String DB_NAME = "straykbolDb";
	private UserAdapter db;

	@Override
	protected void setUp() {
		getContext().deleteDatabase(DB_NAME);
		db = new UserAdapter(getContext()).openToWrite();
	}

	public void testOpenToWrite() {
		assertNotNull(db);
	}

	public void testAddUserIntoTable() {
		assertTrue(db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME) > 0);
	}

	public void testGetUserId() {
		db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		Integer res = db.getUserId(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		assertTrue(res > 0);
	}

	public void testGetNameFromId() {
		db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		Integer id = db.getUserId(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		assertEquals(db.getNameFromId(id), SAMPLE_NAME);
	}
}
