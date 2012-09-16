package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.inject.Inject;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.ShuffleUtility;
import fr.zeus.straykbol.tools.ActivityTools;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.ArrayList;

/**
 * Created on 16/09/12 15:24 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
public class ShufflePlayersActivity extends RoboActivity {
	public static final String LIST_NAME = "liste";
	ArrayList<String> players;
	@InjectView(R.id.lblCurrentPlayer) private TextView lblCurrentPlayer;
	@InjectView(R.id.lblTargetPlayer) private TextView lblTargetPlayer;
	@InjectView(R.id.btnShufflePlayersShowTarget) private Button btnShowTarget;
	@InjectView(R.id.btnShufflePlayersShowNextPlayer) private Button btnShowNextPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shuffle_players_activity);

		lblCurrentPlayer.setVisibility(View.VISIBLE);
		lblTargetPlayer.setVisibility(View.INVISIBLE);
		btnShowTarget.setVisibility(View.VISIBLE);
		btnShowNextPlayer.setVisibility(View.INVISIBLE);

		players = ActivityTools.retrieveArrayListFromIntent(getIntent(), LIST_NAME);
		players = (ArrayList) ShuffleUtility.retrieveRandomizedList(players);

		if (players.size()> 0) {
			lblCurrentPlayer.setText(players.get(0));
			lblTargetPlayer.setText("");
		}
	}

	public ArrayList<String> getPlayers() {
		return players;
	}
}
