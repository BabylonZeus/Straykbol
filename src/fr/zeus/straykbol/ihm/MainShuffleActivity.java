package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

/**
 * Created on 06/09/2012 10:31 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class MainShuffleActivity extends RoboActivity {
	public static final int REQUEST_LIST_MANAGER = 0;
	public static final String LIST_NAME = "liste";

	@InjectView(R.id.btnShuffleLaunchNewGameActivity) private Button btnNewGame;
	@InjectView(R.id.btnShuffleLaunchShufflePlayersActivity) private Button btnShufflePlayers;
	@InjectView(R.id.btnShufflePopulateDefaultPlayers) private Button btnDefaultPlayers;
	@InjectView(R.id.txtShuffleLaunchPlayerManagementActivityListPlayers) private TextView txtPlayers;

	ArrayList players;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_shuffle_activity);

		setShuffleButtonState();

		btnNewGame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent myIntent = new Intent(MainShuffleActivity.this, ShuffleNewGameActivity.class);
				if (players != null && players.size() > 0) {
					myIntent.putStringArrayListExtra(LIST_NAME, players);
				}
				MainShuffleActivity.this.startActivityForResult(myIntent, REQUEST_LIST_MANAGER);
			}
		});

		btnShufflePlayers.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (players != null && players.size() > 0) {
					Intent myIntent = new Intent(MainShuffleActivity.this, ShufflePlayersActivity.class);
					myIntent.putStringArrayListExtra(LIST_NAME, players);
					MainShuffleActivity.this.startActivityForResult(myIntent, REQUEST_LIST_MANAGER);
				} else {
					Toast.makeText(MainShuffleActivity.this, R.string.shuffle_players_empty_message, Toast.LENGTH_LONG).show();
				}
			}
		});

		btnDefaultPlayers.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				populateInitialPlayers();
			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		updatePlayersList();

		switch (requestCode) {
			case (REQUEST_LIST_MANAGER): {
				if (resultCode == Activity.RESULT_OK) {
					players = data.getStringArrayListExtra(LIST_NAME);
					setShuffleButtonState();
					makeText(this, "Partie créée avec " + players.size() + " joueurs", Toast.LENGTH_SHORT).show();
					updatePlayersList();
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

	private void updatePlayersList() {
		if (players == null || players.size() == 0) {
			txtPlayers.setText("Aucune partie en cours");
		}
		else {
			txtPlayers.setText("Joueurs dans la partie : " + players.toString());
		}
	}

	private void setShuffleButtonState() {
		if (players == null || players.size() == 0) {
			btnShufflePlayers.setVisibility(View.INVISIBLE);
		}
		else {
			btnShufflePlayers.setVisibility(View.VISIBLE);
		}
	}

	public ArrayList getPlayers() {
		return players;
	}

	public void populateInitialPlayers() {
		players = new ArrayList<>();
		players.add("Iluvatar");
		players.add("Manwë");
		players.add("Ulmo");
		players.add("Yavanna");
		players.add("Aulë");
		players.add("Nienna");
		updatePlayersList();
		setShuffleButtonState();
	}
}
