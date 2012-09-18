package fr.zeus.straykbol.ihm.shuffle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.tools.ShuffleUtility;
import fr.zeus.straykbol.tools.ActivityTools;
import fr.zeus.straykbol.tools.GenericTestingTools;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

/**
 * Created on 16/09/12 17:02 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ShufflePlayersActivityTest {
	private ShufflePlayersActivity activity;

	private TextView lblCurrentPlayer;
	private TextView lblTargetPlayer;
	private Button btnShowTarget;
	private Button btnShowNextPlayer;
	private static final String LIST_NAME = "liste";

	@Before
	public void setUp() throws Exception {
		activity = new ShufflePlayersActivity();
		activity.setIntent(ActivityTools.retrieveIntentFromArrayList(GenericTestingTools.createListOfPlayers(), LIST_NAME));
		activity.onCreate(null);
		lblCurrentPlayer = (TextView) activity.findViewById(R.id.lblCurrentPlayer);
		lblTargetPlayer = (TextView) activity.findViewById(R.id.lblTargetPlayer);
		btnShowTarget = (Button) activity.findViewById(R.id.btnShufflePlayersShowTarget);
		btnShowNextPlayer = (Button) activity.findViewById(R.id.btnShufflePlayersShowNextPlayer);
	}

	@Test
	public void shouldShowCorrectIHMOnStart_StateE1() {
		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), not(View.VISIBLE));

		assertThat(activity.getPlayersArbitrary().size(), is(6));
		assertThat(activity.getCurrentPlayer(), is(0));

		assertThat(lblCurrentPlayer.getText().toString(), is("Iluvatar"));
	}

	@Test
	public void shouldShowTarget_ActionA1_StateE2() {
		assertThat(btnShowTarget.performClick(), is(true));
		assertThat(activity.getCurrentPlayer(), is(0));

		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), is(View.VISIBLE));

		assertThat(lblCurrentPlayer.getText().toString(), is("Iluvatar"));
		assertThat(lblTargetPlayer.getText().toString(), is(ShuffleUtility.findNextElement(activity.getPlayersRandom(), "Iluvatar")));
	}

	@Test
	public void shouldShowNextPlayer_ActionA2_StateE1() {
		btnShowTarget.performClick();
		assertThat(btnShowNextPlayer.performClick(), is(true));
		assertThat(activity.getCurrentPlayer(), is(1));

		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), not(View.VISIBLE));

		assertThat(lblCurrentPlayer.getText().toString(), is("Manwë"));
	}
}
