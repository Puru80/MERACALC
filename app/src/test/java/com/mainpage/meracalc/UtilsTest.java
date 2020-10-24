 package com.mainpage.meracalc;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class UtilsTest
{
    // Used to make sure "System.out" and "System.err" are NOT used in your assignments EVER!!
    ByteArrayOutputStream myOut;
    ByteArrayOutputStream myErr;

    /**
     * This method runs before every test method and 'sets up' the testing environment.
     * </p>
     * This entire class is re-created for each test method below. Therefore, 'setup'
     * operations such as these that need to be ran 'before' each test are in this method.
     */

    @Before
    public void setUp()
    {
        System.err.flush();
        System.out.flush();
        myOut = new ByteArrayOutputStream();
        myErr = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));
        System.setErr(new PrintStream(myErr));
    }

    /**
     * This method runs after every test method and 'tears down' the testing environment.
     */
    @After
    public void tearDown()
    {
        final String standardOutput = myOut.toString();
        final String standardError  = myErr.toString();
        assertTrue("You used 'System.out' in your assignment, This is not allowed.", standardOutput.length() == 0);
        assertTrue("You used 'System.err' in your assignment, This is not allowed.", standardError.length() == 0);
        System.err.flush();
        System.out.flush();
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.err)));
    }

/*
    @Rubric(
            //value="testRectangleArea",
            goal="The goal of this evaluation is to calculate the RectangleArea",
            //points=10.0,
            reference="This Test fails when: The Rectangle area is miscalculated"
    )

 */



    @Test
    public void compute()
    {
        Utils obj = new Utils("2/8-8x7+28");
        String answer = obj.Compute();
        double ans = Double.parseDouble(answer);

        assertEquals(-27.75,ans,0.001);
        assertEquals("Passed",-27.75,ans,0.001);
    }
}