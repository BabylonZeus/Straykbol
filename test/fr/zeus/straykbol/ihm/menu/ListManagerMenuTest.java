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
public class ListManagerMenuTest {

	@Test
	public void shouldShowAddItemInMenu() {
		assertThat(MenuTools.getText_From_StringBuilt_MenuItemIndex(
				R.menu.list_manager_menu, 0), equalTo("Ajouter un item"));
	}

	@Test
	public void shouldShowRemoveItemInMenu() {
		assertThat(MenuTools.getText_From_StringBuilt_MenuItemIndex(
				R.menu.list_manager_menu, 1), equalTo("Supprimer cet item"));
	}

	@Test
	public void shouldShowCreateListInMenu() {
		assertThat(MenuTools.getText_From_StringBuilt_MenuItemIndex(
				R.menu.list_manager_menu, 2), equalTo("Créer liste"));
	}
}
