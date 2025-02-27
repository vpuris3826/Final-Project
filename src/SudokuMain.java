//import java.text.*;

import java.util.ArrayList;
import java.util.Arrays;

public class SudokuMain {

    //static ArrayList<Integer> nums = new ArrayList<Integer>();

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
    //int[] outOfNine = {1, 2, 3, 4, 5, 6, 7, 8, 9};
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

    public int baseSum(int rStart, int rEnd, int cStart, int cEnd, int [][] baseX){
        int sum = 0;
        for(int r = rStart; r < rEnd; r++){
            for(int c = cStart; c < cEnd; c++){
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
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int adder = 1; adder < 10; adder++)
        for (int j = 1; j <= 9; j++) {
            //why is this going out of bounds?
            System.out.println(nums.size());
            int n = (int) (Math.random() * nums.size());
            System.out.println(n); //why is this only printing 0?
            int i = nums.get(n); //used to just have nums.remove(n) here
            nums.remove(n);
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (bigCell[r][c] == 0) {
                        adder(c, r, bigCell, i);
                        //System.out.println((r+1)*(c+1));
                        //printer(bigCell);
                    }
                }
            }
        }
        System.out.println("test fin");
        printer(bigCell);
        return bigCell;
    }

    public void adder(int c, int r, int [][] bigCell, int n){
        if (colChecker(r, n, bigCell) && rowChecker(c, n, bigCell) && cellChecker(r, c, n, bigCell)){
            bigCell[r][c] = n;
            System.out.println((r+1)*(c+1));
            printer(bigCell);
        }
    }

    public boolean colChecker(int r, int n, int [][] bigCell){
        boolean numWorkCol = true;
        for (int cc = 0; cc < 9; cc++){
            if (bigCell[r][cc] == n){
                numWorkCol = false;
            }
        }
        return numWorkCol;
    }

    public boolean rowChecker(int c, int n, int [][] bigCell){
        boolean numWorkRow = true;
        for (int rr = 0; rr < 9; rr++){
            if (bigCell[rr][c] == n){
                numWorkRow = false;
            }
        }
        return numWorkRow;
    }

    public boolean cellChecker(int r, int c, int n, int [][] bigCell){
        boolean numWorkCell = true;
        int rowNum;
        int colNum;
        int rowMin;
        int colMin;
        if (r < 3){
            rowNum = 3;
            rowMin = 0;
            if (c < 3){
                colNum = 3;
                colMin = 0;
            } else if (c < 6){
                colNum = 6;
                colMin = 3;
            } else {
                colNum = 9;
                colMin = 6;
            }
        } else if (r < 6){
            rowNum = 6;
            rowMin = 3;
            if (c < 3){
                colNum = 3;
                colMin = 0;
            } else if (c < 6){
                colNum = 6;
                colMin = 3;
            } else {
                colNum = 9;
                colMin = 6;
            }
        } else {
            rowNum = 9;
            rowMin = 6;
            if (c < 3){
                colNum = 3;
                colMin = 0;
            } else if (c < 6){
                colNum = 6;
                colMin = 3;
            } else {
                colNum = 9;
                colMin = 6;
            }
        }

        for (int rr = rowMin; rr < rowNum; rr++){
            for (int cc = colMin; cc < colNum; cc++){
                if (bigCell[rr][cc] == n){
                    numWorkCell = false;
                }
            }
        }
        return numWorkCell;
    }

}
