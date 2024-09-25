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

    System.out.println("asdfghjkl");

    public int RandGen()
    {
        int pick = (int) (Math.random() * 9);
        return pick;
    }

    public void MakeBoxOneOne(String[] args, int pick)
    {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int newArr[] = new int[arr.length - 1];
        int j = pick;
        for(int i = 0, k = 0; i < arr.length; i++){
            if(i!=j){
                newArr[k] = arr[i];
                k++;
            }
        }
    }

}
