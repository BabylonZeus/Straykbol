package fr.zeus.straykbol;

import android.test.ActivityInstrumentationTestCase2;
import fr.zeus.straykbol.ihm.StraykbolActivity;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class fr.zeus.straykbol.StraykbolActivityTest_AndroidMethod \
 * fr.zeus.straykbol.tests/android.test.InstrumentationTestRunner
 */
public class StraykbolActivityTest_AndroidMethod extends ActivityInstrumentationTestCase2<StraykbolActivity> {

    public StraykbolActivityTest_AndroidMethod() {
        super("fr.zeus.straykbol", StraykbolActivity.class);
    }

	public void testToto() {
		assertTrue(true);
	}

}
