package fr.zeus.straykbol.ihm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import static android.widget.Toast.makeText;
import static org.junit.Assert.assertThat;

/**
 * Created on 18/09/2012 8:33 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class AboutActivity extends RoboActivity
{
	@InjectView(R.id.lblAboutVersionNameValue) private TextView lblAboutVersionNameValue;
	@InjectView(R.id.lblAboutVersionCodeValue) private TextView lblAboutVersionCodeValue;
	@InjectView(R.id.lblAboutPackageValue) private TextView lblAboutPackageValue;

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
			lblAboutVersionNameValue.setText(pInfo.versionName);
			lblAboutVersionCodeValue.setText(String.valueOf(pInfo.versionCode));
			lblAboutPackageValue.setText(pInfo.packageName);
		}
		catch (PackageManager.NameNotFoundException e)
		{
			e.printStackTrace();
			makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
