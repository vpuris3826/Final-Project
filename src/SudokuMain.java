import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    //arrays
    int arr1[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr2[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr3[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr4[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr5[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr6[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr7[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr8[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int arr9[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    int newArr1[] = new int[]{};
    int newArr2[] = new int[]{};
    int newArr3[] = new int[]{};
    int newArr4[] = new int[]{};
    int newArr5[] = new int[]{};
    int newArr6[] = new int[]{};
    int newArr7[] = new int[]{};
    int newArr8[] = new int[]{};
    int newArr9[] = new int[]{};
    Integer appArr1[] = {};
    Integer appArr2[] = {};
    Integer appArr3[] = {};
    Integer appArr4[] = {};
    Integer appArr5[] = {};
    Integer appArr6[] = {};
    Integer appArr7[] = {};
    Integer appArr8[] = {};
    Integer appArr9[] = {};

    public SudokuMain() {
        //saveApp();
        //saveApp(appArr);
        //saver();
        //makeLine(arr);
        printer(appArr1);
    }

    //int difficulty; // if difficulty = 1, blank boxes = ...

    public Integer[] addX(int n, Integer appArr[], int x){
        int i;
        List<Integer>arrlist
                = new ArrayList<Integer>(
                Arrays.asList(appArr));
        arrlist.add(x);
        appArr = arrlist.toArray(appArr);
        return appArr;
    }

    public Integer[] makeLine(int [] array, int [] newArr) {
        System.out.println("check 2");
        int arr[] = array;
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
        appArr1 = addX(n, appArr1, appadd);
        System.out.println("addX result: " + Arrays.toString(appArr1));
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After (short array): " + Arrays.toString(newArr));
        return appArr1;
    }

    public void saveApp(int [] array, int [] newArr, Integer appArr[]){
        makeLine(array, newArr);
        int r = 2;
        while(r <= 9){
            makeLine(newArr, newArr);
            r++;
        }
    }

    public void printer(Integer appArr[]){
        saveApp(arr1, newArr1, appArr1);
        System.out.println(Arrays.toString(appArr1));
        saveApp(arr2, newArr2, appArr2);
        System.out.println(Arrays.toString(appArr2));
    }

}
