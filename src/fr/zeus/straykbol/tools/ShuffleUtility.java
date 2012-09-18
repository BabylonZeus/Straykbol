package fr.zeus.straykbol.tools;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

import java.util.*;

import static com.google.common.collect.Collections2.filter;

/**
 * Created on 29/08/2012 11:57 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class ShuffleUtility {
	public static ImmutableList<String> retrieveRandomizedList(ImmutableList<String> listInput) {
		List<String> listOutput = new ArrayList<>();
		listOutput.addAll(listInput);

		//Algo de Fisher–Yates
		Random rnd = new Random();
		for (int i = listInput.size() - 1; i >= 1; i--) {
			int j = rnd.nextInt(i + 1);
			Collections.swap(listOutput, i, j);
		}
		return new ImmutableList.Builder<String>().addAll(listOutput).build();
	}

	public static ImmutableList<String> retrieveRandomizedList(List<String> listInput) {
		List<String> listOutput = new ArrayList<>();
		listOutput.addAll(listInput);

		//Algo de Fisher–Yates
		Random rnd = new Random();
		for (int i = listInput.size() - 1; i >= 1; i--) {
			int j = rnd.nextInt(i + 1);
			Collections.swap(listOutput, i, j);
		}
		return ImmutableList.copyOf(listOutput);
	}

	public static String findNextElement(List<String> list, final String currentElement)
	{
		Integer index = getIndexFromString(list, currentElement);
		if (index >= 0) {
			if (index == list.size() - 1) {
				return list.get(0);
			}
			return list.get(index+1);
		}
		return "";
	}

	private static Integer getIndexFromString(List<String> list, String s) {
		for (Integer i = 0; i < list.size(); i++) {
			String sTemp = list.get(i);
			if (sTemp != null && sTemp.equals(s)) {
				return i;
			}
		}
		return -1;
	}
}
