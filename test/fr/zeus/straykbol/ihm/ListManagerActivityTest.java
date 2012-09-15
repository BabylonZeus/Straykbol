package fr.zeus.straykbol.ihm;

import android.test.ActivityInstrumentationTestCase2;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.jayway.android.robotium.solo.Solo;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.tester.android.view.TestMenuItem;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created on 09/09/2012 5:19 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ListManagerActivityTest
{
	private ListManagerActivity activity;
    private EditText editTextId;


    @Before
	public void setUp() throws Exception
	{
		activity = new ListManagerActivity();
		activity.onCreate(null);
        editTextId = (EditText)activity.findViewById(R.id.txtListManagerActivityAdd);
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

}
