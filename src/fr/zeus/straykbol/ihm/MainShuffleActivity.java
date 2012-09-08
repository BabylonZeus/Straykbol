package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;

import java.util.List;

import static android.widget.Toast.makeText;

/**
 * Created on 06/09/2012 10:31 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class MainShuffleActivity extends Activity
{
	public static final int REQUEST_LIST_MANAGER = 0;
	List players;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_shuffle_activity);

		makeText(this, "début", Toast.LENGTH_SHORT).show();

		Button newgame = (Button)findViewById(R.id.btnShuffleLaunchNewGameActivity);
		newgame.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent myIntent = new Intent(MainShuffleActivity.this, ShuffleNewGameActivity.class);
				startActivityForResult(myIntent, REQUEST_LIST_MANAGER);
			}
		});

		/*Button manageplayers = (Button)findViewById(R.id.btnShuffleLaunchPlayerManagementActivity);
		manageplayers.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent myIntent = new Intent(StraykbolActivity.this, MainShuffleActivity.class);
				startActivity(myIntent);

			}
		});*/

		Button launchListManager = (Button)findViewById(R.id.btnLaunchListManager);
		launchListManager.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent myIntent = new Intent(MainShuffleActivity.this, ListManagerActivity.class);
				MainShuffleActivity.this.startActivityForResult(myIntent, RESULT_OK);

			}
		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		super.onActivityResult(requestCode, resultCode, data);
		makeText(this, "Retour", Toast.LENGTH_SHORT).show();

		TextView txtPlayers = (Button)findViewById(R.id.txtShuffleLaunchPlayerManagementActivityListPlayers);
		txtPlayers.setText("Retour");

		switch(requestCode) {
			case (REQUEST_LIST_MANAGER) : {
				if (resultCode == Activity.RESULT_OK) {
					players = data.getStringArrayListExtra("liste");
					makeText(this, "Taille : " + players.size(), Toast.LENGTH_SHORT).show();
					txtPlayers.setText("Joueurs : " + players.toString());
				}
				else {
					makeText(this, "Erreur lors du retour de la liste; resultCode=" + resultCode, Toast.LENGTH_SHORT).show();
				}
				break;
			}
			default:
				makeText(this, "Erreur lors du retour de la liste; requestCode: " + requestCode, Toast.LENGTH_SHORT).show();
				break;
		}
	}
}
