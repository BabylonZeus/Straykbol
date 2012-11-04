package fr.zeus.straykbol.tools;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.collect.Collections2.filter;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created on 29/08/2012 09:33 PM with IntelliJ IDEA,
 * by the mighty babylonzeus in all His wisdom and glory.
 */
public class ShuffleUtilityTest {
	ImmutableList<String> listInput;

	@Before
	public void setUp() throws Exception {
		listInput = new ImmutableList.Builder<String>().add("Iluvatar", "Manwë", "Ulmo", "Yavanna", "Aulë", "Nienna").build();
	}

	@Test
	public void testShouldReturnSameSizeList() {
		ImmutableList<String> listOutput = ShuffleUtility.retrieveRandomizedList(listInput);
		assertThat(listOutput, notNullValue());
		assertThat(listOutput.size(), equalTo(listInput.size()));
	}

	@Test
	public void testShouldReturnRandomOrderFromImmutableList() {
		ImmutableList<String> listOutput = ShuffleUtility.retrieveRandomizedList(listInput);

		//ToDo : en attendant un framework d'assertions comme fest
		for (int i = 0; i < listInput.size(); i++) {
			final int j = i;
			Collection<String> testItem = filter(listOutput, new Predicate<String>()
			{
				@Override
				public boolean apply(String s)
				{
					if (listInput.get(j).equals(s)) return true;
					return false;
				}
			});
			assertThat(testItem.size(), equalTo(1));
		}
	}

	@Test
	public void testShouldReturnRandomOrderFromList() {
		ArrayList<String> listInput2 = GenericTestingTools.createListOfPlayers();
		List<String> listOutput = ShuffleUtility.retrieveRandomizedList(listInput2);

		//ToDo : en attendant un framework d'assertions comme fest
		for (int i = 0; i < listInput.size(); i++) {
			final int j = i;
			Collection<String> testItem = filter(listOutput, new Predicate<String>()
			{
				@Override
				public boolean apply(String s)
				{
					if (listInput.get(j).equals(s)) return true;
					return false;
				}
			});
			assertThat(testItem.size(), equalTo(1));
		}
	}

	@Test
	public void shouldReturnNextElementCircularly() {
		ArrayList<String> list = GenericTestingTools.createListOfPlayers();
		assertThat(ShuffleUtility.findNextElement(list, "Iluvatar"), containsString("Manwë"));
		assertThat(ShuffleUtility.findNextElement(list, "Manwë"), containsString("Ulmo"));
		assertThat(ShuffleUtility.findNextElement(list, "Nienna"), containsString("Iluvatar"));
		assertThat(ShuffleUtility.findNextElement(list, "toto"), containsString(""));

		list = new ArrayList<>();
		assertThat(ShuffleUtility.findNextElement(list, "Iluvatar"), containsString(""));

		list.add("Iluvatar");
		assertThat(ShuffleUtility.findNextElement(list, "Iluvatar"), containsString("Iluvatar"));

	}

}
