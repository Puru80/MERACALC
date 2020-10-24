package com.mainpage.meracalc;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest
{
    private static final String FAKE_STRING = "10";
    //private final Context context = ApplicationProvider.getApplicationContext();

    @Test
    public void computationTest()
    {
        Utils obj = new Utils("5+7-2");

        // ...when the string is returned from the object under test...
        String result = obj.Compute();

        // ...then the result should be the expected one.
        //assertThat(result).isEqualTo(FAKE_STRING);

    }
}