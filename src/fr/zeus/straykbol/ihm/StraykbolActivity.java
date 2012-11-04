package fr.zeus.straykbol.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.ihm.shuffle.MainShuffleActivity;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

/**
 * Created by the mighty babylonzeus in all His wisdom and glory.
 */

public class StraykbolActivity extends RoboActivity {
	public static final Boolean DEBUG = true;
	private static final int MENU_ITEM = Menu.FIRST;

	@InjectView(R.id.btnShuffleLaunchActivity) private Button shuffle;

	/**
	 * Called when the activity is first created.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		shuffle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(StraykbolActivity.this, MainShuffleActivity.class);
				StraykbolActivity.this.startActivity(myIntent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
			case (R.id.menuitem_about_main): {
				Intent myIntent = new Intent(StraykbolActivity.this, AboutActivity.class);
				StraykbolActivity.this.startActivity(myIntent);
				return true;
			}
		}
		return false;
	}
}
