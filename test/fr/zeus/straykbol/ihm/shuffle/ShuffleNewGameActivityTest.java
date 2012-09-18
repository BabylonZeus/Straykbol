package fr.zeus.straykbol.ihm.shuffle;

import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.ihm.shuffle.ShuffleNewGameActivity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created on 09/09/2012 5:36 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ShuffleNewGameActivityTest {
	private ShuffleNewGameActivity activity;

	@Before
	public void setUp() throws Exception {
		activity = new ShuffleNewGameActivity();
		activity.onCreate(null);
	}

	@Test
	public void shouldReturnMenuName() {
		assertThat(activity.getMenuToInflate(), equalTo(R.menu.shuffle_newgame_menu));
	}
}
