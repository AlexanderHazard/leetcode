package org.example;


import junit.framework.Assert;
import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testDAC() {
        int [] underTest = {1,-2,3,-4,-3,-4,-3};
        int res = new MaxMultSubarray().maxProduct(underTest);
        Assert.assertEquals(432, res);
    }

    public void testZigZag() {
        String s = "PAYPALISHIRING";
        String res = new ZigZagConversion().convert(s, 4);
        Assert.assertEquals("PINALSIGYAHRPI", res);
    }

}
