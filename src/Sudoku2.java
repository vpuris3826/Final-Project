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
        makePuzzle(base);
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

    public void makePuzzle(int [][] cell){
        int numAdd = 1;
        for (int n = 0; n < 9; n++){
            nums.add(numAdd);
            numAdd++;
        }
        for (int n = 1; n <= 9; n++){
            int numTemp = (int) (Math.random() * nums.size());
            System.out.println("num generated: " + numTemp);
            System.out.println("num added: " + nums.get(numTemp));
            int numSave = nums.remove(numTemp);
            for (int r = 0; r < 9; r++){
                //System.out.println("for r tester: " + n);
                for (int c = 0; c < 9; c++){
                    //System.out.println("for c tester: " + n);
                    canAdd(numSave, r, c);
                    //System.out.println(canAdd(numSave, r, c))
                }
            }
        }
    }

    public void canAdd(int n, int r, int c){
        //System.out.println(canRow(n, c));
        //System.out.println(canCol(n, r));
        //System.out.println(canCell(n, r, c));
        if (canRow(n, c) && canCol(n, r) && canCell(n, r, c)){
            base[r][c] = n;
        }
        //return false;
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
        for (int row = r % 3; row < 3 - (r % 3); row++){
            for (int col = c % 3; col < 3 - (c % 3); col++){
                if (base[row][col] == n){
                    return false;
                }
            }
        }
        return true;
    }
}
