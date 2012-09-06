package fr.zeus.straykbol;

import android.widget.Button;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: babylonzeus
 * Date: 9/5/12
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(RobolectricTestRunner.class)
public class StraykbolActivityTest
{
	private StraykbolActivity activity;
	private Button pressMeButton;
	private TextView results;

	@Before
	public void setUp() throws Exception {
		activity = new StraykbolActivity();
		activity.onCreate(null);
		pressMeButton = (Button) activity.findViewById(R.id.button);
		results = (TextView) activity.findViewById(R.id.textview);
	}

	@Test
	public void shouldUpdateResultsWhenButtonIsClicked() throws Exception {
		pressMeButton.performClick();
		String resultsText = results.getText().toString();
		assertThat(resultsText, equalTo("Meuh"));
	}
}
