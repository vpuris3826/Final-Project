//import java.text.*;

import java.util.Arrays;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    public SudokuMain() {
        System.out.println("Cell 1x1");
        cellMakerDiagonal(cell1x1);
        System.out.println("Cell 2x2");
        cellMakerDiagonal(cell2x2);
        System.out.println("Cell 3x3");
        cellMakerDiagonal(cell3x3);
        System.out.println("base test");
        basemaker(base, cell1x1, cell2x2, cell3x3);
        System.out.println("rest test");
        tryRest(base);
        //System.out.println("top right: ");
        //cellMakerCorns(cell1x3);
        //System.out.println("bottom left");
        //cellMakerCorns(cell3x1);
    }

    int [][] base = new int[9][9];
    int [][] cell1x1 = new int[3][3];
    int [][] cell2x2 = new int[3][3];
    int [][] cell3x3 = new int[3][3];
    int[] allTest = new int[9];
    int[] outOfNine = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    //int [][] cell1x3 = new int[3][3];
    //int [][] cell3x1 = new int[3][3];

    public void printer(int [][] cellX){
        for(int r = 0; r < cellX.length; r++){
            for(int c = 0; c < cellX[r].length; c++){
                System.out.print(cellX [r][c] + " ");
            }
            System.out.println();
        }
    }

    public int cellSum(int [][] cellX){
        int sum = 0;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                sum += cellX[r][c];
            }
        }
        return sum;
    }

    public int baseSum(int [][] baseX){
        int sum = 0;
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                sum += baseX[r][c];
            }
        }
        return sum;
    }

    public int [][] appendCell(int row, int col, int num, int [][] cellZ){
        cellZ[row][col] = num;
        return cellZ;
    }

    public int [][] cellMakerDiagonal(int [][] cellY){
        int sum = cellSum(cellY);
        int n = 1;
        while (sum != 45) {
            int r = (int) (Math.random() * 3);
            int c = (int) (Math.random() * 3);
            if (cellY[r][c] == 0) {
                appendCell(r, c, n, cellY);
                sum = cellSum(cellY);
                n++;
            }
        }
        printer(cellY);
        return cellY;
    }

    public int [][] basemaker(int [][] base, int [][] cell1x1, int [][] cell2x2, int [][] cell3x3){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                int n = cell1x1[r][c];
                appendCell(r, c, n, base);
            }
        }
        for(int r = 3, rc = 0; r < 6 && rc < 3; r++, rc++){
            for(int c = 3, cc = 0; c < 6 && cc < 3; c++, cc++){
                int n = cell2x2[rc][cc];
                appendCell(r, c, n, base);
            }
        }
        for(int r = 6, rc = 0; r < 9 && rc < 3; r++, rc++){
            for(int c = 6, cc = 0; c < 9 && cc < 3; c++, cc++){
                int n = cell3x3[rc][cc];
                appendCell(r, c, n, base);
            }
        }
        printer(base);
        return base;
    }

    public int[][] tryRest(int [][] bigCell){
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (bigCell[r][c] == 0){
                    testAllTwo(c, r, bigCell, allTest);
                    addNum(r, c, bigCell, allTest, outOfNine);
                }
            }
        }
        printer(bigCell);
        return bigCell;
    }

    //figure out what numbers are already in row
    /*public int[] testRows(int c, int [][] bigCell, int [] rowTest){
        for (int r = 0; r < 9; r++){
            if (bigCell[r][c] != 0){
                rowTest[r] = bigCell[r][c];
            }
            System.out.println(Arrays.toString(rowTest));
        }
        return rowTest;
    }

    //figure out what numbers are already in col
    public int[] testCols(int r, int [][] bigCell, int [] colTest){
        for (int c = 0; c < 9; c++){
            if (bigCell[r][c] != 0){
                colTest[c] = bigCell[r][c];
            }
            System.out.println(Arrays.toString(colTest));
        }
        return colTest;
    }*/

    //figure out what numbers could go in
    /*public int[] testAll(int c, int r, int [][] bigCell, int [] allTest){
        int i = 0;
        for (int cc = 0; cc < 9; cc++){
            if (bigCell[r][cc] != 0){
                allTest[i] = bigCell[r][cc];
            }
        }
        for (int rr = 0; rr < 9; rr++){
            if (bigCell[rr][c] != 0){
                allTest[i] = bigCell[rr][c];
            }
        }
        i++;
        System.out.println("Printing allTest:");
        System.out.println(Arrays.toString(allTest));
        return allTest;
    }*/

    public int[] testAllTwo(int c, int r, int [][] bigCell, int [] allTest){
        int [] outOfNine = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int cc = 0; cc < 9; cc++){
            if (bigCell[r][cc] != 0){
                for (int i = 0; i < 9; i++){
                    if (bigCell[r][cc] == outOfNine[i]){
                        outOfNine[i] = 0;
                    }
                }
                System.out.println("Printing allTest:");
                System.out.println(Arrays.toString(outOfNine));
            }
        }
        for (int rr = 0; rr < 9; rr++){
            if (bigCell[rr][c] != 0){
                for (int i = 0; i < 9; i++){
                    if (bigCell[rr][c] == outOfNine[i]){
                        outOfNine[i] = 0;
                    }
                }
                System.out.println("Printing allTest:");
                System.out.println(Arrays.toString(outOfNine));
            }
        }
        return outOfNine;
    }

    //figure out what numbers could be added
    public void addNum(int r, int c, int [][] bigCell, int [] allTest, int [] outOfNine){
        //int [] outOfNine = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = 0;
        for (int i = 0; i < 9; i++){
            for (int j =0; j < 9; j++) {
                if (outOfNine[j] == allTest[i]) {
                    outOfNine[j] = 0;
                }
            }
        }
        System.out.println("Printing all possible numbers");
        System.out.println(Arrays.toString(outOfNine));
        for (int k = 0; k < 9; k++) {
            if (outOfNine[k] != 0) {
                n = outOfNine[k];
            }
        }
        appendCell(r, c, n, bigCell);
    }

    /*public int crossCheck(int [] rowTest, int [] colTest){
        int n = -1;
        int numsGood = 0;
        boolean add = true;
        while (numsGood < 9 && !add) {
            n = (int) (Math.random() * 9) + 1;
            for (int i = 0; i < 9; i++) {
                if (n != colTest[i] && n != rowTest[i]){
                    numsGood++;
                } else if (n == colTest[i] || n == rowTest[i]){
                    add = false;
                }
            }
        }
        return n;
    }*/

    /*public void testTestCols(int n, int i, int [] colTest, int [] rowTest){
        if (n == colTest[i]){
            crossCheck(rowTest, colTest);
        } else {
            testTestRows(n, i, rowTest, colTest);
        }
    }

    public void testTestRows(int n, int i, int [] rowTest, int [] colTest){
        if (n == rowTest[i]){
            crossCheck(rowTest, colTest);
        }
    }*/

    /*public void tryTest(int r, int c, int [][] bigCell){
        if (bigCell[r][c] == 0){
            //int[] colTest = new int[9];
            //int[] rowTest = new int[9];
            int[] allTest = new int[9];
            //testRows(c, bigCell, rowTest);
            //testCols(r, bigCell, colTest);
            testAll(c, r, bigCell, allTest);
            //crossCheck(rowTest, colTest);
            addNum(r, c, bigCell, allTest);
        }
    }*/

    /*public boolean checkRowCol(int n, int r, int c, int [][] bigCell, boolean add) {
        //boolean add = false;
        while (!add){
            for (int tester = 0; tester < 9; tester++) {
                if (n != bigCell[r][tester] && n != bigCell[tester][c]) {
                    //appendCell(n, r, c, base);
                    add = true;
                } else {
                    //n = 0;
                    add = false;
                }
            }
        }
        return add;
    }

    public void checkN(int n, int r, int c, int [][] bigCell){
        boolean add = false;
        if (n == 0) {
            n = (int) (Math.random() * 9 + 1);
            while (!add){
                for (int tester = 0; tester < 9; tester++) {
                    if (n != bigCell[r][tester] && n != bigCell[tester][c]) {
                        //appendCell(n, r, c, base);
                        add = true;
                    } else {
                        //n = 0;
                        add = false;
                    }
                }
            } if (add) {
                appendCell(n,r, c, base);
            } if (!add){
                n = 0;
            }
        }
    }

    public int [][] cellMakerRest(int [][] bigCell){
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                int n = bigCell[r][c];
                checkN(n, r, c, bigCell);
            }
        }
        printer(bigCell);
        return bigCell;
    }*/

    /*public int [][] cellMakerBottomLeft(int [][] cellY){
        int sum = cellSum(cellY);
        int n = 1;
        while (sum != 45) {
            int r = (int) (Math.random() * 3);
            int c = (int) (Math.random() * 3);
            if (cellY[r][c] == 0 && n != cell1x1[r][c] && n != cell3x3[r][c]) {
                appendCell(r, c, n, cellY);
                sum = cellSum(cellY);
                n++;
            }
        }
        printer(cellY);
        return cellY;
    }*/

}
