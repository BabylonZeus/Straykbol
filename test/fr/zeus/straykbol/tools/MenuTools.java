package fr.zeus.straykbol.tools;

import android.view.Menu;
import android.view.MenuInflater;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.shadows.ShadowMenuInflater;
import com.xtremelabs.robolectric.tester.android.view.TestMenu;
import fr.zeus.straykbol.ihm.ListManagerActivity;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;

/**
 * Created on 16/09/12 14:04 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
public class MenuTools {
	public static String getText_From_StringBuilt_MenuItemIndex(int resourceMenuId, int menuItemIndex) {
		Menu menu = new TestMenu();
		ShadowActivity shactivity = shadowOf(new ListManagerActivity());
		ShadowMenuInflater shadowMenuInflater = shadowOf(new MenuInflater(shactivity.getApplicationContext()));
		shadowMenuInflater.inflate(resourceMenuId, menu);
		return shactivity.getString(
				shactivity.getResources().getIdentifier(
						menu.getItem(menuItemIndex).getTitle().toString().split("/")[1],
						"string",
						null
				)
		);
	}
}
