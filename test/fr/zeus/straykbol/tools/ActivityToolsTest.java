package fr.zeus.straykbol.tools;

import android.content.Intent;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

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

}
