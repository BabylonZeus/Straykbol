package fr.zeus.straykbol.ihm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import fr.zeus.straykbol.R;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.xtremelabs.robolectric.Robolectric.shadowOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created on 18/09/2012 8:28 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
@RunWith(RobolectricTestRunner.class)
public class AboutActivityTest
{
	private AboutActivity activity;

	private TextView lblAboutVersionNameValue;
	private TextView lblAboutVersionCodeValue;
	private TextView lblAboutPackageValue;

	@Before
	public void setUp() throws Exception {
		activity = new AboutActivity();
		activity.onCreate(null);

		lblAboutVersionNameValue = (TextView) activity.findViewById(R.id.lblAboutVersionNameValue);
		lblAboutVersionCodeValue = (TextView) activity.findViewById(R.id.lblAboutVersionCodeValue);
		lblAboutPackageValue = (TextView) activity.findViewById(R.id.lblAboutPackageValue);
	}

	@Test
	public void shouldCheckVersion() throws PackageManager.NameNotFoundException
	{
		PackageInfo pInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0);
		assertThat(lblAboutVersionNameValue.getText().toString(), equalTo(pInfo.versionName));
		assertThat(lblAboutVersionCodeValue.getText().toString(), equalTo(String.valueOf(pInfo.versionCode)));
		assertThat(lblAboutPackageValue.getText().toString(), equalTo(pInfo.packageName));
	}

}
