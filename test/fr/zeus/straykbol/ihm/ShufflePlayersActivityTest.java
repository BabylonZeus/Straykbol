package fr.zeus.straykbol.ihm;

import android.widget.EditText;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created on 16/09/12 17:02 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ShufflePlayersActivityTest {
	private ShufflePlayersActivity activity;
	private TextView lblCurrentPlayer;
	private TextView lblTargetPlayer;

	@Before
	public void setUp() throws Exception {
		activity = new ShufflePlayersActivity();
		activity.onCreate(null);
		lblCurrentPlayer = (TextView) activity.findViewById(R.id.lblCurrentPlayer);
		lblTargetPlayer = (TextView) activity.findViewById(R.id.lblTargetPlayer);
	}
	@Test
	public void shouldShowCorrectIHMOnStart() {

	}
}
