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
public class MainMenuTest
{
	@Test
	public void shouldShowAboutInMenu() {
		assertThat(MenuTools.getText_From_StringBuilt_MenuItemIndex(
				R.menu.main_menu, 0), equalTo("A propos de"));
	}
}
