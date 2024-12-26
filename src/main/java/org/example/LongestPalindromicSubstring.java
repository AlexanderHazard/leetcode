package org.example;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        StringBuilder strB = new StringBuilder();

        for (int i = 0; i < s.length() ; i++) {
            StringBuilder candidate = search(i, s, new StringBuilder());
            if (candidate.length() > strB.length()) {
                strB = candidate;
            }

            if (strB.length() == s.length()) break;
        }

        return strB.toString();
    }

    private StringBuilder search(int pos, String s, StringBuilder stringBuilder) {
        if (stringBuilder.length() == 0) {
            if (s.length() > pos + 1 && s.charAt(pos) == s.charAt(pos + 1)) {
                return search(pos, s, stringBuilder.append(s.charAt(pos)).append(s.charAt(pos + 1)));
            }

            return search(pos, s, stringBuilder.append(s.charAt(pos)));
        }

        int left = pos - (stringBuilder.length() % 2 == 0 ? stringBuilder.length() - 1 : stringBuilder.length());
        int right = pos +  stringBuilder.length();

        if (left < 0 && right >= s.length()) {
            return stringBuilder;
        }

        if (left < 0 && stringBuilder.charAt(0) == s.charAt(right)) {
            StringBuilder res = new StringBuilder().append(stringBuilder).append(s.charAt(right));
            return search(pos, s, res);
        }

        if (right >= s.length() && s.charAt(left) == stringBuilder.charAt(stringBuilder.length() - 1)) {
            StringBuilder res = new StringBuilder().append(s.charAt(left)).append(stringBuilder);
            return search(pos, s, res);
        }

        if (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            StringBuilder res = new StringBuilder().append(s.charAt(left)).append(stringBuilder).append(s.charAt(right));
            return search(pos, s, res);
        }

        return stringBuilder;
    }

}
