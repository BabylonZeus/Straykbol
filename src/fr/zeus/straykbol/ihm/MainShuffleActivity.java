package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

/**
 * Created on 06/09/2012 10:31 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class MainShuffleActivity extends Activity {
	public static final int REQUEST_LIST_MANAGER = 0;
	public static final String LIST_NAME = "liste";
	ArrayList players;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_shuffle_activity);

		Button newgame = (Button) findViewById(R.id.btnShuffleLaunchNewGameActivity);
		newgame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(MainShuffleActivity.this, ShuffleNewGameActivity.class);
				if (players != null && players.size() > 0) {
					myIntent.putStringArrayListExtra(LIST_NAME, players);
				}
				MainShuffleActivity.this.startActivityForResult(myIntent, REQUEST_LIST_MANAGER);
			}
		});

		/*Button manageplayers = (Button)findViewById(R.id.btnShuffleLaunchPlayerManagementActivity);
		manageplayers.setOnClickListener(new View.OnClickListener()
		{RESULT_OK
			@Override
			public void onClick(View view)
			{
				Intent myIntent = new Intent(StraykbolActivity.this, MainShuffleActivity.class);
				startActivity(myIntent);

			}
		});*/

		Button launchListManager = (Button) findViewById(R.id.btnLaunchListManager);
		launchListManager.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(MainShuffleActivity.this, ListManagerActivity.class);
				if (players != null && players.size() > 0) {
					myIntent.putStringArrayListExtra(LIST_NAME, players);
				}
				MainShuffleActivity.this.startActivityForResult(myIntent, REQUEST_LIST_MANAGER);
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		TextView txtPlayers = (TextView) findViewById(R.id.txtShuffleLaunchPlayerManagementActivityListPlayers);
		txtPlayers.setText("US non gérée");

		switch (requestCode) {
			case (REQUEST_LIST_MANAGER): {
				if (resultCode == Activity.RESULT_OK) {
					players = data.getStringArrayListExtra(LIST_NAME);
					makeText(this, "Partie créée avec " + players.size() + " joueurs", Toast.LENGTH_SHORT).show();
					txtPlayers.setText("Joueurs : " + players.toString());
				} else {
					makeText(this, "Liste de joueurs non modifiée", Toast.LENGTH_SHORT).show();
				}
				break;
			}
			default:
				makeText(this, "Erreur lors du retour de la liste; requestCode: " + requestCode, Toast.LENGTH_SHORT).show();
				break;
		}
	}
}
