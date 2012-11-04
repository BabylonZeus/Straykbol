package fr.zeus.straykbol.ihm.utilities;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created on 09/09/2012 5:19 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ListManagerActivityTest {
	private ListManagerActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new ListManagerActivity();
		activity.onCreate(null);
	}

	@Test
	public void shouldRegisterMenuName() {
		assertThat(activity.getMenuToInflate(), equalTo(R.menu.list_manager_menu));
		activity.setMenuToInflate(666);
		assertThat(activity.getMenuToInflate(), equalTo(666));
	}

	@Test
	public void shouldRegisterContextMenuName() {
		assertThat(activity.getContextMenuToInflate(), equalTo(R.menu.list_manager_contextmenu));
		activity.setContextMenuToInflate(666);
		assertThat(activity.getContextMenuToInflate(), equalTo(666));
	}
}
