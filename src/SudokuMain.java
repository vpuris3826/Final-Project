import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    //arrays
    int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int newArr[] = new int[]{};
    Integer appArr[] = {};

    public SudokuMain() {
        makeBoxOneOne(arr);
        int r = 2;
        while(r <= 9){
            makeBoxOneOne(newArr);
            r++;
        }
    }

    //int difficulty; // if difficulty = 1, blank boxes = ...

    public void makeBoxOneOne(int [] array) {
        System.out.println("check");
        int arr[] = array;
        //int[] newArr = null;
        int j = (int) (Math.random() * (arr.length));
        newArr = new int[arr.length - 1];
        int n = 9;
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != j) {
                newArr[k] = arr[i];
                k++;
            }
        }
        int appadd = arr[j];
        appArr = addX(n, appArr, appadd);
        System.out.println("addX result: " + Arrays.toString(appArr));
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After (short array): " + Arrays.toString(newArr));
    }

    public Integer[] addX(int n, Integer appArr[], int x){
        int i;
        List<Integer>arrlist
                = new ArrayList<Integer>(
                        Arrays.asList(appArr));
        arrlist.add(x);
        appArr = arrlist.toArray(appArr);
        return appArr;
    }

}
