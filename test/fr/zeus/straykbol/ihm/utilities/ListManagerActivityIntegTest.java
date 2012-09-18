package fr.zeus.straykbol.ihm.utilities;

import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.tester.android.view.TestMenuItem;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.ihm.utilities.ListManagerActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;

/**
 * Created on 16/09/12 11:44 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ListManagerActivityIntegTest
{
	private ListManagerActivity activity;
	private EditText editTextId;


	@Before
	public void setUp() throws Exception {
		activity = new ListManagerActivity();
		activity.onCreate(null);
		editTextId = (EditText) activity.findViewById(R.id.txtListManagerActivityAdd);
	}

	@Test
	public void shouldClickMenu_And_ShowEditText() {
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		MenuItem item = new TestMenuItem(R.id.menuitem_list_manager_add_item);
		assertThat(activity.onOptionsItemSelected(item), equalTo(true));
		assertThat(editTextId.hasFocus(), equalTo(true));
		assertThat(editTextId.getVisibility(), equalTo(View.VISIBLE));
	}

	@Test
	public void shouldClickMenu_And_CreateOneItem() {
		assertThat(activity.getListItems().size(), equalTo(0));
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		MenuItem item = new TestMenuItem(R.id.menuitem_list_manager_add_item);
		assertThat(activity.onOptionsItemSelected(item), equalTo(true));
		assertThat(editTextId.hasFocus(), equalTo(true));
		assertThat(editTextId.getVisibility(), equalTo(View.VISIBLE));
		editTextId.setText("toto");
		editTextId.onKeyUp(KeyEvent.KEYCODE_ENTER, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		assertThat(activity.getListItems().size(), equalTo(1));
	}

    @Test
    public void shouldClickMenu_CreateItem_DeleteItem() {
		assertThat(activity.getListItems().size(), equalTo(0));
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		assertThat(activity.onOptionsItemSelected(new TestMenuItem(R.id.menuitem_list_manager_add_item)), equalTo(true));
		assertThat(editTextId.hasFocus(), equalTo(true));
		assertThat(editTextId.getVisibility(), equalTo(View.VISIBLE));
		editTextId.setText("toto");
		editTextId.onKeyUp(KeyEvent.KEYCODE_ENTER, new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		assertThat(activity.getListItems().size(), equalTo(1));

		assertThat(activity.onOptionsItemSelected(new TestMenuItem(R.id.menuitem_list_manager_delete_item)), equalTo(true));
		assertThat(editTextId.getVisibility(), not(View.VISIBLE));
		assertThat(activity.getListItems().size(), equalTo(0));
	}

	@Test
	public void shouldFinishActivity_on_CreatingList() {
		activity.onOptionsItemSelected(new TestMenuItem(R.id.menuitem_list_manager_create_list));
		assertThat(activity.isFinishing(), is(true));
	}
}
