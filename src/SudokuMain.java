//import java.text.*;

import java.util.Arrays;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    //arrays
    //int[] base = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    //Integer app[];
    //Integer[] arr;

    public SudokuMain() {
        //removal();
        System.out.print(Arrays.toString(cell1x1));
    }

    //int difficulty; // if difficulty = 1, blank boxes = ...

    /*int [][] cellBase =
            { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};*/
    int [][] cell1x1 = new int[3][3];
    int [][] cell2x2 = new int[3][3];
    int [][] cell3x3 = new int[3][3];

    public int[][] removal(){
        int [][] cellBase =
                { {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}};
        int [][] oneToNineMinus = new int[cellBase.length - 1][cellBase.length - 1];
        int j = (int)(Math.random() * 9);
        for(int r = 0, k = 0; r < cellBase.length; r++){
            for
            if(i != j){
                oneToNineMinus[k] = cellBase[i];
                k++;
            }
        }
        System.out.println("before: " + Arrays.toString(cellBase));
        System.out.println("after: " + Arrays.toString(oneToNineMinus));
        return oneToNineMinus;
    }

    /*public int[][] adding(){
        for(int n = 1; n <= 9; n++){

        }
    }*/

}
