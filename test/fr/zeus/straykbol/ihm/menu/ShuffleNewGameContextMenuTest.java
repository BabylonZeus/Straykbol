package fr.zeus.straykbol.ihm.menu;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.tools.MenuTools;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created on 16/09/12 11:56 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ShuffleNewGameContextMenuTest {

	@Test
	public void shouldShowAddItemInMenu() {
		assertThat(MenuTools.getText_From_StringBuilt_MenuItemIndex(
				R.menu.list_manager_contextmenu, 0), equalTo("Supprimer cet item"));
	}
}
