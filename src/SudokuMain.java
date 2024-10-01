import java.util.Arrays;
//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    //int difficulty; // if difficulty = 1, blank boxes = ...

    public void makeBoxOneOne()
    {
        System.out.println("check");
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int j = (int) (Math.random() * (arr.length + 1));
        int newArr[] = new int[arr.length - 1];
        //int appArray[] = {};
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
