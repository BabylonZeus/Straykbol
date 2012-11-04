package fr.zeus.straykbol.tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.LinearLayout;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static fr.zeus.straykbol.tools.ActivityTools.printViewMainParameters;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.hamcrest.core.StringContains.containsString;

/**
 * Created on 16/09/12 17:57 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class ActivityToolsTest {
	public static final String LIST_NAME = "liste";

	@Test
	public void shouldRetrieveArrayListFromIntent() {
		ArrayList<String> players = GenericTestingTools.createListOfPlayers();
		Intent intent = new Intent();
		intent.putStringArrayListExtra(LIST_NAME, players);

		assertThat(ActivityTools.retrieveArrayListFromIntent(intent, LIST_NAME), sameInstance(players));
	}

	@Test
	public void shouldRetrieveIntentFromArrayList() {
		ArrayList<String> players = GenericTestingTools.createListOfPlayers();
		assertThat(ActivityTools.retrieveIntentFromArrayList(players, LIST_NAME).getStringArrayListExtra(LIST_NAME), sameInstance(players));
	}

	@Test
	public void shouldPrintViewParameters () {
		Context x = shadowOf(new Activity()).getApplicationContext();
		LinearLayout l = new LinearLayout(x);
		Button btn = new Button(x);
		btn.setLayoutParams(new LinearLayout.LayoutParams(100, 50));
		btn.setId(R.id.btnShufflePlayersShowNextPlayer);
		l.addView(btn);
		String p = printViewMainParameters(btn);
		System.out.println("p = " + p);
		assertThat(p, containsString("width=")); //ToDo: pourquoi width reste à 0 ?
	}

}
