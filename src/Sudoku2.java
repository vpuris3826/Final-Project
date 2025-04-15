import java.util.Scanner;

public class Sudoku2 {
    static int [][] base = new int[9][9];
    static int [][] baseDub = new int[9][9];
    Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Sudoku2();
    }

    public Sudoku2(){
        puzzleMaker();
        System.out.println("base: ");
        printer(base);
        System.out.println("baseDub: ");
        printer(baseDub);
        play();
        //printer(base);

    }

    public void play(){
        System.out.println("Do you want to play sudoku? (y/n) ");
        myScanner.useDelimiter("\\n");
        String play = myScanner.next();
        if (play.equals("y")){
            System.out.println("Here's some instructions: ");
            System.out.println("To move, type the column (1-9 left to right) and row (1-9 top to bottom) when asked");
            System.out.println("If your move is incorrect, a message will be printed on the screen telling you so");
            System.out.println("Place numbers in the blank boxes");
            System.out.println("Do you want to play on easy, medium, or hard difficulty? (e/m/h) ");
            myScanner.useDelimiter("\\n");
            String difficulty = myScanner.next();
            int out = 0;
            if (difficulty.equals("e")){
                out = (int) (Math.random() * 11 + 40);
            } else if (difficulty.equals("m")){
                out = (int) (Math.random() * 11 + 50);
            } else {
                out = (int) (Math.random() * 11 + 60);
            }
            for (int n = 0; n < out; n++){
                int r = (int) (Math.random() * 9);
                int c = (int) (Math.random() * 9);
                base[r][c] = 0;
            }
            printer(base);
            /*System.out.println("base: ");
            printer(base);
            System.out.println("baseDub: ");
            printer(baseDub);*/
            while(base != baseDub){
                System.out.println("What column would you like to move to? ");
                myScanner.useDelimiter("\\n");
                int col = myScanner.nextInt();
                System.out.println("What row would you like to move to? ");
                myScanner.useDelimiter("\\n");
                int row = myScanner.nextInt();
                System.out.println("What number do you want to put there? ");
                base[row - 1][col - 1] = myScanner.nextInt();
                printer(base);
                if (base[row - 1][col - 1] != baseDub[row - 1][col - 1]){
                    System.out.println("INCORRECT!!");
                    base[row - 1][col - 1] = 0;
                }
            }
        }
    }

    public void puzzleMaker(){
        for(int r = 0; r < 9; r++){
            for(int c = 0; c < 9; c++){
                int n = (int) (Math.random() * 9 + 1);
                if(canAdd(n, r, c)){
                    base[r][c] = n;
                    baseDub[r][c] = n;
                }
            }
            for (int c2 = 0; c2 < 9; c2++){
                if (base[r][c2] == 0){
                    int n = (int) (Math.random() * 9 + 1);
                    int tryNum = 0;
                    while(!canAdd(n, r, c2) && tryNum <= 81){
                        n = (int) (Math.random() * 9 + 1);
                        tryNum++;
                    }
                }
            }
            for (int c3 = 0; c3 < 9; c3++){
                if (base[r][c3] == 0){
                    r--;
                }
            }
        }
    }

    public void printer(int [][] cell){
        for(int r = 0; r < cell.length; r++){
            for(int c = 0; c < cell[r].length; c++){
                if (cell [r][c] == 0){
                    System.out.print("  ");
                } else {
                    System.out.print(cell[r][c] + " ");
                }
            }
            System.out.println();
        }
    }

    public boolean canAdd(int n, int r, int c){
        if (canRow(n, c) && canCol(n, r) && canCell(n, r, c)){
            base[r][c] = n;
            baseDub[r][c] = n;
            return true;
        }
        return false;
    }

    public boolean canRow(int n, int c){
        for (int row = 0; row < 9; row ++){
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
