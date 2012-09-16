package fr.zeus.straykbol.ihm;

import android.widget.Button;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created on 08/09/2012 10:30 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class MainShuffleActivityTest {
	private MainShuffleActivity activity;
	private Button btnNewGame;

	@Before
	public void setUp() throws Exception {
		activity = new MainShuffleActivity();
		activity.onCreate(null);
		btnNewGame = (Button) activity.findViewById(R.id.btnShuffleLaunchNewGameActivity);
	}

	@Test
	public void shouldOpenShuffleNewGameActivity() {
		btnNewGame.performClick();
		ShadowIntent shadowIntent = shadowOf(shadowOf(activity).getNextStartedActivity());
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(ShuffleNewGameActivity.class.getName()));
	}
}
