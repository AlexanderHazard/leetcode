package org.example;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LongestPalindromicSubstringTest extends TestCase {

    private static final LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

    public void testShouldFindLongest() {
/*        String res1 = lps.longestPalindrome("babad");
        Assert.assertEquals("bab", res1);

        String res2 = lps.longestPalindrome("cbbd");
        Assert.assertEquals("bb", res2);

        String res3 = lps.longestPalindrome("a");
        Assert.assertEquals("a", res3);

        String res4 = lps.longestPalindrome("ccc");
        Assert.assertEquals("ccc", res4);

        String res5 = lps.longestPalindrome("bb");
        Assert.assertEquals("bb", res5);*/


        String res6 = lps.longestPalindrome("abb");
        Assert.assertEquals("bb", res6);
    }

}
