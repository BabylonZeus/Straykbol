package fr.zeus.straykbol.ihm.shuffle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.zeus.straykbol.tools.ActivityTools.retrieveIntentFromArrayList;
import static fr.zeus.straykbol.tools.GenericTestingTools.createListOfPlayers;
import static fr.zeus.straykbol.tools.ShuffleUtility.findNextElement;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.StringContains.containsString;

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
	private TextView lblResults;
	private static final String LIST_NAME = "liste";

	@Before
	public void setUp() throws Exception {
		activity = new ShufflePlayersActivity();
		activity.setIntent(retrieveIntentFromArrayList(createListOfPlayers(), LIST_NAME)
				.putExtra("showResults", true));
		activity.onCreate(null);
		lblCurrentPlayer = (TextView) activity.findViewById(R.id.lblCurrentPlayer);
		lblTargetPlayer = (TextView) activity.findViewById(R.id.lblTargetPlayer);
		btnShowTarget = (Button) activity.findViewById(R.id.btnShufflePlayersShowTarget);
		btnShowNextPlayer = (Button) activity.findViewById(R.id.btnShufflePlayersShowNextPlayer);
		lblResults = (TextView) activity.findViewById(R.id.lblRamdomizedList);
	}

	@Test
	public void shouldShowCorrectIHMOnStart_StateE1() {
		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), not(View.VISIBLE));

		assertThat(activity.getPlayersArbitrary().size(), is(6));
		assertThat(activity.getCurrentPlayer(), is(0));

		assertThat(lblCurrentPlayer.getText().toString(), containsString("Iluvatar"));
	}

	@Test
	public void shouldShowTarget_ActionA1_StateE2() {
		assertThat(btnShowTarget.performClick(), is(true));
		assertThat(activity.getCurrentPlayer(), is(0));

		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), is(View.VISIBLE));

		assertThat(lblCurrentPlayer.getText().toString(), containsString("Iluvatar"));
		assertThat(lblTargetPlayer.getText().toString(), containsString(findNextElement(activity.getPlayersRandom(), "Iluvatar")));
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

		assertThat(lblCurrentPlayer.getText().toString(), containsString("Manwë"));
	}

	@Test
	public void shouldShowResultsOnOpening() {
		assertThat(lblResults.getVisibility(), is(View.VISIBLE));
	}
}
