package fr.zeus.straykbol.ihm;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import com.xtremelabs.robolectric.tester.android.view.TestMenuItem;
import fr.zeus.straykbol.R;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created on 16/09/12 11:44 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class StraykbolActivityIntegTest
{
	private StraykbolActivity activity;


	@Before
	public void setUp() throws Exception {
		activity = new StraykbolActivity();
		activity.onCreate(null);
	}

	@Test
	public void shouldClickMenu_And_ShowAboutText() {
		MenuItem item = new TestMenuItem(R.id.menuitem_about_main);
		assertThat(activity.onOptionsItemSelected(item), equalTo(true));
	}

	@Test
	public void shouldClickMenu_And_OpenAboutActivity() {
		MenuItem item = new TestMenuItem(R.id.menuitem_about_main);
		activity.onOptionsItemSelected(item);

		Intent startedIntent = shadowOf(activity).getNextStartedActivity();;
		Assert.assertThat(shadowOf(startedIntent).getComponent().getClassName(),
				equalTo(AboutActivity.class.getName()));
	}
}
