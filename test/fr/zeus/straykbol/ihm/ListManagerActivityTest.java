package fr.zeus.straykbol.ihm;

import android.content.Intent;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import com.xtremelabs.robolectric.tester.android.view.TestMenu;
import com.xtremelabs.robolectric.tester.android.view.TestMenuItem;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.clickOn;
import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created on 09/09/2012 5:19 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ListManagerActivityTest
{
	private ListManagerActivity activity;

	@Before
	public void setUp() throws Exception
	{
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

	@Test
	public void shouldCreateOneItem() {
		TestMenu mainMenu = new TestMenu(activity);
		shadowOf(new MenuInflater(activity)).inflate(R.menu.list_manager_menu, mainMenu);
		TestMenuItem aboutItem = mainMenu.findMenuItem("@string/menu_item_list_manager_add_item");
		System.out.println("Valeur : " + aboutItem.getTitle());
		assertThat("Ajouter un item1", aboutItem, notNullValue());
		//clickOn(aboutItem);
	}
}
