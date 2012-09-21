package fr.zeus.straykbol.db;

import android.app.Activity;
import android.content.Context;
import android.test.AndroidTestCase;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created on 03/09/2012 9:41 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class UserAdapterTest {
	public static final String SAMPLE_NAME = "Name of marmotte";
	public static final String SAMPLE_FIRSTNAME = "Firstname of marmotte";
	public static final String SAMPLE_NICKNAME = "Marmotte";
	public static final String DB_NAME = "straykbolDb";
	private UserAdapter db;
	private Context context;

	@Before
	public void setUp() {
		context = new Activity();
		context.deleteDatabase(DB_NAME);
		db = new UserAdapter(context).openToWrite();
	}

	@Test
	public void testOpenToWrite() {
		assertThat(db, notNullValue());
	}

	@Test
	public void testAddUserIntoTable() {
		assertThat(db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME) > 0, is(true));
	}

	@Test
	public void testGetUserId() {
		db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		Integer res = db.getUserId(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		assertThat(res > 0, is(true));
	}

	@Test
	public void testGetNameFromId() {
		db.addUser(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		Integer id = db.getUserId(SAMPLE_NAME, SAMPLE_FIRSTNAME, SAMPLE_NICKNAME);
		assertThat(db.getNameFromId(id), is(SAMPLE_NAME));
	}
}
