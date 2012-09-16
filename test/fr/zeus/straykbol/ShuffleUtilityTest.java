package fr.zeus.straykbol;

import android.test.AndroidTestCase;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;

import java.util.Collection;

/**
 * Created on 29/08/2012 09:33 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class ShuffleUtilityTest extends AndroidTestCase {
	ImmutableList<String> listInput;

	@Override
	protected void setUp() throws Exception {
		listInput = new ImmutableList.Builder<String>().add("Patrick", "Corinne", "Loïc", "Mathias").build();
		super.setUp();
	}

	public void testShouldReturnSameSizeList() {
		ImmutableList<String> listOutput = ShuffleUtility.retrieveRandomizedList(listInput);
		assertNotNull(listOutput);
		assertTrue(listOutput.size() == listInput.size());
	}

	public void testShouldReturnRandomOrderFromList() {
		ImmutableList<String> listOutput = ShuffleUtility.retrieveRandomizedList(listInput);

		//ToDo : en attendant un framework d'assertions comme fest
		for (int i = 0; i < listInput.size(); i++) {
			final int j = i;
			Collection<String> testItem = Collections2.filter(listOutput, new Predicate<String>() {
				@Override
				public boolean apply(String s) {
					if (listInput.get(j).equals(s)) return true;
					return false;
				}
			});
			assertTrue(testItem.size() == 1);
		}
	}

}
