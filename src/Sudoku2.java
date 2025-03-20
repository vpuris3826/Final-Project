import java.util.ArrayList;

public class Sudoku2 {
    static int [][] base = new int[9][9];
    static ArrayList<Integer> nums = new ArrayList<Integer>();

    public static void main(String[] args) {
        new Sudoku2();
    }

    public Sudoku2(){
        printer(base);
        System.out.println();
        int numAdd = 1;
        for (int n = 0; n < 9; n++){
            nums.add(numAdd);
            numAdd++;
        }
        makePuzzle();
        printer(base);
    }

    public void printer(int [][] cell){
        for(int r = 0; r < cell.length; r++){
            for(int c = 0; c < cell[r].length; c++){
                System.out.print(cell [r][c] + " ");
            }
            System.out.println();
        }
    }

    public int baseSum(){
        int sum = 0;
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                sum += base[r][c];
            }
        }
        return sum;
    }

    public void makePuzzle(/*int [][] cell*/){
        for (int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if (base[r][c] == 0){
                    //figure out what's happening here? why won't it keep going?
                    //ArrayList<Integer> break = new ArrayList<Integer> nums;
                    int numSave = (int) (Math.random() * 9 + 1);
                    int tryNum = 1;
                    if(!canAdd(numSave, r, c)){
                        while(!canAdd(numSave, r, c)){
                            numSave = (int) (Math.random() * 9 + 1);
                            tryNum++;
                            if (tryNum > 81 && r > 0){
                                r--;
                                //c--;
                            } else if (81 < tryNum && c > 0){
                                c--;
                            } else {
                                c = 0;
                                r = 0;
                            }
                            //System.out.println("num test: " + numSave);
                        }
                    }
                    printer(base);
                    System.out.println();
                }
            }
        }
    }

    public boolean canAdd(int n, int r, int c){
        //System.out.println(c);
        if (canRow(n, c) && canCol(n, r) && canCell(n, r, c)){
            //System.out.println("test after enter: " + canCell(n, r, c));
            //System.out.println("try 2: r - " + r + " c - " + c);
            base[r][c] = n;
            return true;
        }
        return false;
    }

    public boolean canRow(int n, int c){
        for (int row = 0; row < 9; row ++){
            //why is this part out of bounds??
            if (base[row][c] == n){
                return false;
            }
        }
        return true;
    }

    public boolean canCol(int n, int r){
        for (int col = 0; col < 9; col++){
            if (base[r][col] == n){
                return false;
            }
        }
        return true;
    }

    public boolean canCell(int n, int r, int c){
        int rowMax;
        int colMax;
        int rowMin;
        int colMin;
        if (r < 3){
            rowMax = 3;
            rowMin = 0;
            if (c < 3){
                colMax = 3;
                colMin = 0;
            } else if (c < 6){
                colMax = 6;
                colMin = 3;
            } else {
                colMax = 9;
                colMin = 6;
            }
        } else if (r < 6){
            rowMax = 6;
            rowMin = 3;
            if (c < 3){
                colMax = 3;
                colMin = 0;
            } else if (c < 6){
                colMax = 6;
                colMin = 3;
            } else {
                colMax = 9;
                colMin = 6;
            }
        } else {
            rowMax = 9;
            rowMin = 6;
            if (c < 3){
                colMax = 3;
                colMin = 0;
            } else if (c < 6){
                colMax = 6;
                colMin = 3;
            } else {
                colMax = 9;
                colMin = 6;
            }
        }

        for (int rr = rowMin; rr < rowMax; rr++){
            for (int cc = colMin; cc < colMax; cc++){
                if (base[rr][cc] == n){
                    return false;
                }
            }
        }
        return true;
    }
}
