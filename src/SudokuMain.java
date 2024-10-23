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
    Integer appArr2[] = {};

    public SudokuMain() {
        //saveApp();
        //saveApp2();
        saver();
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

    public Integer[] makeLine(int [] array) {
        System.out.println("check");
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
        Integer[] append = addX(n, appArr, appadd);
        System.out.println("addX result: " + Arrays.toString(appArr));
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After (short array): " + Arrays.toString(newArr));
        return append;
    }

    /*public Integer[] makeLine2(int [] array) {
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
        appArr2 = addX(n, appArr2, appadd);
        System.out.println("addX result: " + Arrays.toString(appArr2));
        System.out.println("Before: " + Arrays.toString(arr));
        System.out.println("After (short array): " + Arrays.toString(newArr));
        return appArr2;
    }*/

    public Integer [] saveApp(){
        makeLine(arr);
        int r = 2;
        while(r <= 8){
            makeLine(newArr);
            r++;
        }
        makeLine(newArr);
        return appArr;
    }

    public Integer[] saver(){
        saveApp();
        System.out.println(appArr);
        return appArr;
    }

    /*public Integer[] saveApp2(Integer appArr2[]){
        makeLine2(arr);
        int r = 2;
        while(r <= 9){
            makeLine2(newArr);
            r++;
        }
        System.out.println(appArr2);
        return appArr2;
    }*/

}
