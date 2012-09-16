package fr.zeus.straykbol;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Collection;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;
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
			assertThat(testItem.size(), equalTo(1));
		}
	}

}
