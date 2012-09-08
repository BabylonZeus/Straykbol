package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.os.Bundle;
import fr.zeus.straykbol.R;

/**
 * Created on 08/09/2012 10:39 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class ShuffleNewGameActivity extends ListManagerActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_game_shuffle_activity);
	}
}
