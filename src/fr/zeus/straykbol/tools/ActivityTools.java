package fr.zeus.straykbol.tools;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created on 16/09/12 18:05 with IntelliJ IDEA,
 * by the venerable Kosh in all His wisdom and glory.
 */
public class ActivityTools {
	public static ArrayList<String> retrieveArrayListFromIntent(Intent intent, String listName) {
		ArrayList<String> listItems = new ArrayList<>();
		if (intent != null
				&& intent.getStringArrayListExtra(listName) != null
				&& intent.getStringArrayListExtra(listName).size() > 0) {
			listItems = intent.getStringArrayListExtra(listName);
		}
		return listItems;
	}

	public static Intent retrieveIntentFromArrayList(ArrayList<String> players, String listName) {
		return new Intent().putStringArrayListExtra(listName,  players);
	}

	public static String printViewMainParameters(View view) {
		return view.getId() + " : width=" + view.getWidth() + "; ";
	}
}
