package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnKeyListener;
import android.widget.*;
import fr.zeus.straykbol.R;

import java.util.ArrayList;

public class ListManagerActivity extends Activity
{
	//private static final int SHOW_SUBACTIVITY = 1;
	private static final int PICK_CONTACT_SUBACTIVITY = 2;
	private boolean addingNew = false;
	private ArrayList<String> todoItems;
	private ListView myListView;
	private EditText myEditText;
	private ArrayAdapter<String> aa;
	
	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_manager_activity);
		
		myListView = (ListView)findViewById(R.id.lstListManagerActivity);
		myEditText = (EditText)findViewById(R.id.txtListManagerActivityAdd);
		
		todoItems = new ArrayList<>();
		int resID = R.layout.list_manager_item;
		//aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, todoItems);
		aa = new ArrayAdapter<>(this, resID, todoItems);
		myListView.setAdapter(aa);
		
		myEditText.setOnKeyListener(new OnKeyListener()
		{
			
			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				// TODO Auto-generated method stub
				if (event.getAction() == KeyEvent.ACTION_DOWN)
				{
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
					{
						todoItems.add(0, myEditText.getText().toString());
						aa.notifyDataSetChanged();
						cancelAdd();
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
		registerForContextMenu(myListView);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.list_manager_menu, menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle(R.string.selectEntry);
		menu.add(0, R.id.menuitem_todolist_del, Menu.NONE, R.string.list_manager_remove_item);
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		super.onPrepareOptionsMenu(menu);
		int idx = myListView.getSelectedItemPosition();
		String removeTitle = getString(addingNew ? R.string.cancel : R.string.list_manager_remove_item);
		MenuItem removeItem = menu.findItem(R.id.menuitem_todolist_del);
		removeItem.setTitle(removeTitle);
		removeItem.setVisible(addingNew || idx > -1);
		menu.findItem(R.id.menuitem_create_game).setVisible(myListView.getCount() > 0);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		super.onOptionsItemSelected(item);
		int index = myListView.getSelectedItemPosition();
		switch (item.getItemId())
		{
			case (R.id.menuitem_todolist_del):
			{
				if (addingNew)
				{
					cancelAdd();
				}
				else
				{
					removeItem(index);
				}
				return true;
			}
			case (R.id.menuitem_todolist_add):
			{
				addNewItem();
				return true;
			}
			case  (R.id.menuitem_create_game):
				Intent intent = new Intent();
				intent.putStringArrayListExtra("liste", todoItems);
				setResult(RESULT_OK, intent);
				finish();
		}
		return false;
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item)
	{
		super.onContextItemSelected(item);
		switch (item.getItemId())
		{
			case (R.id.menuitem_todolist_del) :
			{
				AdapterView.AdapterContextMenuInfo menuInfo;
				menuInfo = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
				int index = menuInfo.position;
				removeItem(index);
				return true;
			}
		}
		return false;
	}
	
	private void cancelAdd()
	{
		addingNew = false;
		myEditText.setVisibility(View.GONE);
	}
	
	private void addNewItem()
	{
		addingNew = true;
		myEditText.setVisibility(View.VISIBLE);
		myEditText.requestFocus();
	}
	
	private void removeItem(int _index)
	{
		todoItems.remove(_index);
		aa.notifyDataSetChanged();
	}
}
