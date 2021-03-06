package fr.zeus.straykbol.ihm.shuffle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.tools.GenericTestingTools;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created on 08/09/2012 10:30 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class MainShuffleActivityTest {
	private MainShuffleActivity activity;
	private Button btnNewGame;
	private Button btnShuffleGame;
	private Button btnManagePlayers;
	Intent intent;

	@Before
	public void setUp() throws Exception {
		activity = new MainShuffleActivity();
		activity.onCreate(null);
		btnNewGame = (Button) activity.findViewById(R.id.btnShuffleLaunchNewGameActivity);
		btnShuffleGame = (Button) activity.findViewById(R.id.btnShuffleLaunchShufflePlayersActivity);
		btnManagePlayers = (Button) activity.findViewById(R.id.btnShuffleLaunchManagePlayersActivity);

		ArrayList<String> listItems = GenericTestingTools.createListOfPlayers();
		intent = new Intent();
		intent.putStringArrayListExtra(MainShuffleActivity.LIST_NAME, listItems);
	}

	@Test
	public void shouldOpenShuffleNewGameActivity() {
		btnNewGame.performClick();
		ShadowIntent shadowIntent = shadowOf(shadowOf(activity).getNextStartedActivity());
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(ShuffleNewGameActivity.class.getName()));
	}

	@Test
	public void shouldNotShowShuffleButton_on_EmptyGame() {
		assertThat(activity.getPlayers(), nullValue());
		assertThat(btnShuffleGame.getVisibility(), not(View.VISIBLE));
	}

	@Test
	public void shouldShowShuffleButton_on_NonEmptyGame() {
		assertThat(activity.getPlayers(), nullValue());
		activity.onActivityResult(MainShuffleActivity.REQUEST_LIST_MANAGER, Activity.RESULT_OK, intent);
		assertThat(btnShuffleGame.getVisibility(), is(View.VISIBLE));
	}

	@Test
	public void shouldOpenShufflePlayersActivity() {
		activity.onActivityResult(MainShuffleActivity.REQUEST_LIST_MANAGER, Activity.RESULT_OK, intent);
		((CheckBox)activity.findViewById(R.id.chkShowResults)).setChecked(true);
		btnShuffleGame.performClick();
		ShadowIntent shadowIntent = shadowOf(shadowOf(activity).getNextStartedActivity());
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(ShufflePlayersActivity.class.getName()));
		assertThat(shadowIntent.getExtras().getBoolean("showResults"), org.hamcrest.core.Is.is(true));
	}

	@Test
	public void shouldOpenManagePlayersActivity() {
		activity.onActivityResult(MainShuffleActivity.REQUEST_LIST_MANAGER, Activity.RESULT_OK, intent);
		btnManagePlayers.performClick();
		ShadowIntent shadowIntent = shadowOf(shadowOf(activity).getNextStartedActivity());
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(ShuffleManagePlayersActivity.class.getName()));
	}
}
