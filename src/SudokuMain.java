//import java.text.*;

import java.util.Arrays;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    public SudokuMain() {
        removal();
        cellMaker(cell1x1);
    }

    int [][] base =
            { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
    int [][] cell1x1 = new int[3][3];
    int [][] cell2x2 = new int[3][3];
    int [][] cell3x3 = new int[3][3];

    public int[][] removal(){
        int [][] cellBase = base;
        int [][] oneToNineMinus = new int [0][0];
        for(int n = 0; n < 3; n++) {
            oneToNineMinus = new int[cellBase.length - 1][cellBase.length - 1];
            int j = (int) (Math.random() * 3);
            for (int r = 0, k = 0; r < cellBase.length; r++) {
                if(r != j) {
                    int m = (int) (Math.random() * 3);
                    for (int c = 0, l = 0; c < cellBase.length; c++) {
                        if (c != m) {
                            oneToNineMinus[k][l] = cellBase[r][c];
                            l++;
                        }
                    }
                    k++;
                }
            }
        }
        System.out.println("before: ");
        printer(cellBase);
        System.out.println("after: ");
        printer(oneToNineMinus);
        return oneToNineMinus;
    }

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

    public int [][] appendCell(int row, int col, int num, int [][] cellZ){
        cellZ[row][col] = num;
        return cellZ;
    }

    public void cellMaker(int [][] cellY){
        int sum = cellSum(cellY);
        while(sum != 45) {
            for (int n = 1; n <= 9; n++) {
                int r = (int) (Math.random() * 3);
                int c = (int) (Math.random() * 3);
                if (cellY[r][c] == 0) {
                    appendCell(r, c, n, cellY);
                }
            }
        }
        //return CellX
    }

}
