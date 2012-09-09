package fr.zeus.straykbol.ihm;

import android.view.MenuItem;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.tester.android.view.TestMenuItem;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created on 09/09/2012 5:36 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ShuffleNewGameActivityTest
{
	private ShuffleNewGameActivity activity;

	@Before
	public void setUp() throws Exception
	{
		activity = new ShuffleNewGameActivity();
		activity.onCreate(null);
	}

	@Test
	public void shouldReturnMenuName() {
		assertThat(activity.getMenuToInflate(), equalTo(R.menu.shuffle_newgame_menu));
	}

	/*@Test
	public void shouldReturnMenuLabelForAddPlayer() {
		MenuItem item = new TestMenuItem() {
			public int getItemId() {
				return R.id.menuitem_list_manager_add_item;
			}
		};

		activity.onOptionsItemSelected(item);

		ShadowActivity shadowActivity = shadowOf(activity);
		MenuItem item2 = (MenuItem)shadowActivity.findViewById(R.id.menuitem_list_manager_add_item);
		System.out.print(item2.getTitle());
	}*/
}
