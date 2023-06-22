package org.example;


public class ZigZagConversion {

    public String convert(String s, int numRows) {
        int col = -1;
        int row = 0;
        int zigCount = 0;


        char[][] zigzag = new char[numRows][s.length()];

        int charCurs = 0;
        while (charCurs < s.length()) {
            char ss = s.charAt(charCurs++);

            if (zigCount == 0) {
                if (row == 0) col++;
                zigzag[row][col] = ss;
                //run zigzag after reach end of row
                if (++row == numRows) {
                    zigCount = Math.max(numRows - 1, 1);
                    row = numRows - zigCount;
                }
                continue;
            }

            zigzag[--zigCount][++col] = ss;
        }

        StringBuilder strBuild = new StringBuilder();
        for (int rowIdx = 0; rowIdx < numRows; rowIdx++) {
            for (int colIdx = 0; colIdx <= col; colIdx++) {
                char symb = zigzag[rowIdx][colIdx];
                if (symb != '\u0000') {
                    strBuild.append(symb);
                }
            }
        }


        return strBuild.toString();
    }

}
