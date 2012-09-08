package fr.zeus.straykbol.ihm;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import com.xtremelabs.robolectric.shadows.ShadowActivity;
import com.xtremelabs.robolectric.shadows.ShadowIntent;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created on 05/09/2012 10:59 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class StraykbolActivityTest
{
	private StraykbolActivity activity;

	private Button pressMeButton;
	private TextView results;

	private Button btnShuffleLaunchActivity;

	@Before
	public void setUp() throws Exception {
		activity = new StraykbolActivity();
		activity.onCreate(null);

		pressMeButton = (Button) activity.findViewById(R.id.button);
		results = (TextView) activity.findViewById(R.id.textview);

		btnShuffleLaunchActivity = (Button) activity.findViewById(R.id.btnShuffleLaunchActivity);
	}

	@Test
	public void shouldUpdateResultsWhenButtonIsClicked() throws Exception {
		pressMeButton.performClick();
		String resultsText = results.getText().toString();
		assertThat(resultsText, equalTo("Meuh"));
	}

	@Test
	public void shouldOpenShuffleLaunchActivity() {
		btnShuffleLaunchActivity.performClick();
		ShadowActivity shadowActivity = shadowOf(activity);
		Intent startedIntent = shadowActivity.getNextStartedActivity();
		ShadowIntent shadowIntent = shadowOf(startedIntent);
		assertThat(shadowIntent.getComponent().getClassName(), equalTo(MainShuffleActivity.class.getName()));
	}
}
