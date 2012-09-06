package fr.zeus.straykbol;

import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * Created on 29/08/2012 11:57 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class ShuffleUtility
{
	public static ImmutableList<String> retrieveRandomizedList(ImmutableList<String> listInput)
	{
		List<String> listOutput = new ArrayList<>();
		listOutput.addAll(listInput);

		//Algo de Fisher–Yates
		Random rnd = new Random();
		for (int i = listInput.size()-1; i>=1; i--) {
			int j = rnd.nextInt(i+1);
			Collections.swap(listOutput, i, j);
		}
		return new ImmutableList.Builder<String>().addAll(listOutput).build();
		//return new ImmutableList.Builder<String>().add("Mathias", "Loïc", "Corinne", "Patrick").build();
	}
}
