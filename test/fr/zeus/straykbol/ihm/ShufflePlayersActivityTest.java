package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import fr.zeus.straykbol.R;
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
		activity.onCreate(null);
		lblCurrentPlayer = (TextView) activity.findViewById(R.id.lblCurrentPlayer);
		lblTargetPlayer = (TextView) activity.findViewById(R.id.lblTargetPlayer);
		btnShowTarget = (Button) activity.findViewById(R.id.btnShufflePlayersShowTarget);
		btnShowNextPlayer = (Button) activity.findViewById(R.id.btnShufflePlayersShowNextPlayer);
	}
	@Test
	public void shouldShowCorrectIHMOnStart() {
		assertThat(lblCurrentPlayer.getVisibility(), is(View.VISIBLE));
		assertThat(lblTargetPlayer.getVisibility(), not(View.VISIBLE));
		assertThat(btnShowTarget.getVisibility(), is(View.VISIBLE));
		assertThat(btnShowNextPlayer.getVisibility(), not(View.VISIBLE));

		//ToDo : injecter une liste de 6 dans players et tester le changement des lbl et txt
		/*ShadowIntent shIntent = Robolectric.shadowOf(new Intent());
		shIntent.setClass(ShufflePlayersActivity.class, ShufflePlayersActivity.class);
		ShadowActivity shActivity = Robolectric.shadowOf(new Activity()).startActivity();
		activity.setIntent(ActivityTools.retrieveIntentFromArrayList(GenericTestingTools.createListOfPlayers(), LIST_NAME));
		assertThat(activity.getPlayers().size(), is(6));*/
	}
}
