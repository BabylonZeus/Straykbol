package fr.zeus.straykbol;

import com.google.common.collect.ImmutableList;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: babylonzeus
 * Date: 8/29/12
 * Time: 11:57 PM
 * To change this template use File | Settings | File Templates.
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
