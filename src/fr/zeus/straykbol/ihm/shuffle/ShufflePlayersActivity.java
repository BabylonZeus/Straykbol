package fr.zeus.straykbol.ihm.shuffle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.common.collect.ImmutableList;
import fr.zeus.straykbol.R;
import fr.zeus.straykbol.tools.ActivityTools;
import fr.zeus.straykbol.tools.ShuffleUtility;
import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;

import java.util.ArrayList;

import static android.widget.Toast.makeText;

/**
 * Created on 16/09/12 15:24 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
public class ShufflePlayersActivity extends RoboActivity {
	public static final String LIST_NAME = "liste";
	private ArrayList<String> playersArbitrary;
	private ImmutableList<String> playersRandom;
	private Integer currentPlayer;

	@InjectView(R.id.lblRamdomizedList) private TextView lblRandomizedList;
	@InjectView(R.id.lblCurrentPlayer) private TextView lblCurrentPlayer;
	@InjectView(R.id.lblTargetPlayer) private TextView lblTargetPlayer;
	@InjectView(R.id.btnShufflePlayersShowTarget) private Button btnShowTarget;
	@InjectView(R.id.btnShufflePlayersShowNextPlayer) private Button btnShowNextPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shuffle_players_activity);
		currentPlayer = 0;
		if (getIntent().getBooleanExtra("showResults", false)) lblRandomizedList.setVisibility(View.VISIBLE);
		else lblRandomizedList.setVisibility(View.INVISIBLE);

		lblCurrentPlayer.setVisibility(View.VISIBLE);
		lblTargetPlayer.setVisibility(View.INVISIBLE);
		btnShowTarget.setVisibility(View.VISIBLE);
		btnShowNextPlayer.setVisibility(View.INVISIBLE);

		playersArbitrary = ActivityTools.retrieveArrayListFromIntent(getIntent(), LIST_NAME);
		playersRandom = ShuffleUtility.retrieveRandomizedList(playersArbitrary);
		lblRandomizedList.setText(getString(R.string.shuffle_players_results) + playersRandom.toString());

		if (playersArbitrary.size()> 0) {
			lblCurrentPlayer.setText(getString(R.string.shuffle_players_current_player) + playersArbitrary.get(0));
			lblTargetPlayer.setText("");
		}

		btnShowTarget.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (playersArbitrary != null && playersArbitrary.size() > 0) {
					lblCurrentPlayer.setVisibility(View.VISIBLE);
					lblTargetPlayer.setVisibility(View.VISIBLE);
					btnShowTarget.setVisibility(View.INVISIBLE);
					btnShowNextPlayer.setVisibility(View.VISIBLE);
					lblTargetPlayer.setText(getString(R.string.shuffle_players_target_player) + ShuffleUtility.findNextElement(playersRandom, playersArbitrary.get(currentPlayer)));
				}
				else {
					makeText(ShufflePlayersActivity.this, R.string.shuffle_players_empty_message, Toast.LENGTH_LONG).show();
				}
			}
		});

		btnShowNextPlayer.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				if (playersArbitrary != null && playersArbitrary.size() > 0)
				{
					lblCurrentPlayer.setVisibility(View.VISIBLE);
					lblTargetPlayer.setVisibility(View.INVISIBLE);
					btnShowTarget.setVisibility(View.VISIBLE);
					btnShowNextPlayer.setVisibility(View.INVISIBLE);
					currentPlayer = browseToNextPlayer(currentPlayer);
					lblCurrentPlayer.setText(getString(R.string.shuffle_players_current_player) + playersArbitrary.get(currentPlayer));
				}
				else
				{
					makeText(ShufflePlayersActivity.this, R.string.shuffle_players_empty_message, Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public ArrayList<String> getPlayersArbitrary() {
		return playersArbitrary;
	}

	public ImmutableList<String> getPlayersRandom()
	{
		return playersRandom;
	}

	public Integer getCurrentPlayer()
	{
		return currentPlayer;
	}

	private Integer browseToNextPlayer(Integer currentPlayer) {
		if (playersRandom == null || playersRandom.size() == 0) {
			return 0;
		}
		if (currentPlayer == playersRandom.size() - 1) {
			return 0;
		}
		return currentPlayer + 1;
	}

}
