package fr.zeus.straykbol.ihm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import static android.widget.Toast.makeText;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created on 18/09/2012 8:33 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class AboutActivity extends RoboActivity
{
	@InjectView(R.id.lblAboutVersion) private TextView lblAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

		updateApplicationAboutInformation();
	}

	private void updateApplicationAboutInformation()
	{
		PackageInfo pInfo = null;
		try
		{
			pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
			lblAbout.setText(pInfo.versionName);
		}
		catch (PackageManager.NameNotFoundException e)
		{
			e.printStackTrace();
			makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
