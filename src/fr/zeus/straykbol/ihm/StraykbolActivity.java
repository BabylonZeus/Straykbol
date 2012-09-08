package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import fr.zeus.straykbol.R;

/**
 * Created by the mighty babylonzeus in all His wisdom and glory.
 */

public class StraykbolActivity extends Activity
{
	static final private int MENU_ITEM = Menu.FIRST;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button b = (Button)findViewById(R.id.button);
		b.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				TextView tv = (TextView)findViewById(R.id.textview);
				tv.setText("Meuh");
			}
		});

		Button shuffle = (Button)findViewById(R.id.btnShuffleLaunchActivity);
		shuffle.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent myIntent = new Intent(StraykbolActivity.this, MainShuffleActivity.class);
				StraykbolActivity.this.startActivity(myIntent);

			}
		});

    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		//Identifiant de groupe
		int groupId = 0;
		//Identifiant unique d'entrée de menu. Utilisé pour la gestion des événements
		int menuItemId = MENU_ITEM;
		//Position de l'entrée
		int menuItemOrder = Menu.NONE;
		//Texte de l'entrée
		int menuItemText = R.string.menu_item_reset;
		MenuItem item1 = menu.add(groupId, menuItemId, menuItemOrder, menuItemText);
		item1.setIcon(R.drawable.nuclear);

		menuItemId++;
		SubMenu sub = menu.addSubMenu(groupId, Menu.NONE, menuItemOrder, R.string.submenu_item);
		sub.setHeaderIcon(R.drawable.nuclear);
		//sub.setIcon(R.drawable.menu_item);
		sub.add(groupId, menuItemId, menuItemOrder, R.string.submenu_entry);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		super.onOptionsItemSelected(item);
		//Détermine quelle entrée de menu a été sélectionnée
		switch (item.getItemId())
		{
			case (Menu.NONE):
				break;
			case (MENU_ITEM):
				//clearCompassValue();
				Toast.makeText(this, R.string.reset_text, Toast.LENGTH_SHORT).show();
				break;
			case (MENU_ITEM + 1):
				Toast.makeText(this, R.string.toto_text, Toast.LENGTH_SHORT).show();
				break;
			default:
				Toast.makeText(this, R.string.fail, Toast.LENGTH_SHORT).show();
				return false;
		}
		return true;
	}

}
