package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
		setMenuToInflate(R.menu.shuffle_newgame_menu);
		setContextMenuToInflate(R.menu.shuffle_newgame_contextmenu);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		return super.onContextItemSelected(item);
	}
}
