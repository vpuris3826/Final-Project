import java.util.Random;
import java.util.Arrays;
//import java.text.*;

public class SudokuMain {

    //int [] mat[]; // sets up array
    //int numColRow = 9; // 9 columns/rows
    //int boxSize = 3; // 3 x 3 boxes
    //int difficulty; // if difficulty = 1, blank boxes = ...

    //int n = 9;
    //int i;
    //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void RunRunRun(){

        //MakeBoxOneOne();

    }

    /*public int[] RandGen()
    {
        int pick = (int) (Math.random() * 9);
        int newArray[] = MakeBoxOneOne(pick);
        return newArray[];
    }*/

    public void MakeBoxOneOne()
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int j = (int) (Math.random() * (arr.length + 1));
        int newArr[] = new int[arr.length - 1];
        int appArray[] = {};
        for(int i = 0, k = 0; i < arr.length; i++){

            if(i!=j){
                newArr[k] = arr[i];
                k++;
            }
        }
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After: " + Arrays.toString(newArr));
        System.out.println("New array: ");
    }

}
