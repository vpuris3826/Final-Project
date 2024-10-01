import java.util.Arrays;
//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public SudokuMain() {
        makeBoxOneOne(arr);
    }

    //int difficulty; // if difficulty = 1, blank boxes = ...

    public void makeBoxOneOne(int [] array) {
        System.out.println("check");
        int arr[] = array;
        int[] newArr = null;
        int[] appArr = new int[8];
        int j = (int) (Math.random() * (arr.length));
        newArr = new int[arr.length - 1];
        int appArray[] = {};
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != j) {
                newArr[k] = arr[i];
                k++;
            }
        }
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After: " + Arrays.toString(newArr));
        //System.out.println("Before: " + Arrays.toString(arr));
        //System.out.println("After: " + Arrays.toString(newArr));
        //System.out.println("New array: ");
        //return arr;
        //return newArr;
    }

}
