package fr.zeus.straykbol.ihm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnKeyListener;
import android.widget.*;
import fr.zeus.straykbol.R;

import java.util.ArrayList;

public class ListManagerActivity extends Activity
{
	public static final String LIST_NAME = "liste";
	protected boolean addingNew = false;
	protected ArrayList<String> listItems;
	protected ListView visualListView;
	protected EditText visualEditText;
	protected ArrayAdapter<String> aa;
	private int menuToInflate;
	private int contextMenuToInflate;

	/** Called when the activity is first created. */
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_manager_activity);
		
		visualListView = (ListView)findViewById(R.id.lstListManagerActivity);
		visualEditText = (EditText)findViewById(R.id.txtListManagerActivityAdd);

		Intent fromIntent = getIntent();
		if (fromIntent != null
				&& fromIntent.getStringArrayListExtra(LIST_NAME) != null
				&& fromIntent.getStringArrayListExtra(LIST_NAME).size() > 0) {
			listItems = fromIntent.getStringArrayListExtra(LIST_NAME);
		} else {
			listItems = new ArrayList<>();
		}
		int resID = R.layout.list_manager_item;
		aa = new ArrayAdapter<>(this, resID, listItems);
		visualListView.setAdapter(aa);
		
		visualEditText.setOnKeyListener(new OnKeyListener()
		{

			public boolean onKey(View v, int keyCode, KeyEvent event)
			{
				if (event.getAction() == KeyEvent.ACTION_DOWN)
				{
					if (keyCode == KeyEvent.KEYCODE_DPAD_CENTER
							|| keyCode == KeyEvent.KEYCODE_ENTER)
					{
						listItems.add(0, visualEditText.getText().toString());
						aa.notifyDataSetChanged();
						cancelAdd();
						visualEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});

		setMenuToInflate(R.menu.list_manager_menu);
		setContextMenuToInflate(R.menu.list_manager_contextmenu);
		registerForContextMenu(visualListView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(getMenuToInflate(), menu);
		return true;
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle(R.string.selectEntry);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(getContextMenuToInflate(), menu);
		//menu.add(0, R.id.menuitem_list_manager_delete_item, Menu.NONE, this.getResources().getIdentifier(menu.findItem(R.id.menuitem_list_manager_delete_item).getTitle().toString(), null, null));
	}
	
	@Override
	public boolean onPrepareOptionsMenu(Menu menu)
	{
		super.onPrepareOptionsMenu(menu);
		int idx = visualListView.getSelectedItemPosition();
		String removeTitle = addingNew ? getString(R.string.cancel) : menu.findItem(R.id.menuitem_list_manager_delete_item).getTitle().toString();
		MenuItem removeItem = menu.findItem(R.id.menuitem_list_manager_delete_item);
		removeItem.setTitle(removeTitle);
		removeItem.setVisible(addingNew || idx > -1);
		menu.findItem(R.id.menuitem_list_manager_create_list).setVisible(visualListView.getCount() > 0);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		super.onOptionsItemSelected(item);
		int index = visualListView.getSelectedItemPosition();
		switch (item.getItemId())
		{
			case (R.id.menuitem_list_manager_delete_item):
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
			case (R.id.menuitem_list_manager_add_item):
			{
				addNewItem();
				return true;
			}
			case  (R.id.menuitem_list_manager_create_list):
				Intent intent = new Intent();
				intent.putStringArrayListExtra(LIST_NAME, listItems);
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
			case (R.id.contextmenuitem_list_manager_delete_item) :
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
		visualEditText.setVisibility(View.GONE);
	}
	
	private void addNewItem()
	{
		addingNew = true;
		visualEditText.setVisibility(View.VISIBLE);
		visualEditText.requestFocus();
	}
	
	private void removeItem(int _index)
	{
		listItems.remove(_index);
		aa.notifyDataSetChanged();
	}

	public int getMenuToInflate()
	{
		return menuToInflate;
	}

	public void setMenuToInflate(int menuToInflate)
	{
		this.menuToInflate = menuToInflate;
	}

	public int getContextMenuToInflate()
	{
		return contextMenuToInflate;
	}

	public void setContextMenuToInflate(int contextMenuToInflate)
	{
		this.contextMenuToInflate = contextMenuToInflate;
	}
}
