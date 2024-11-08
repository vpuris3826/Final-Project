//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    public SudokuMain() {
        System.out.println("Cell 1x1");
        cellMaker(cell1x1);
        System.out.println("Cell 2x2");
        cellMaker(cell2x2);
        System.out.println("Cell 3x3");
        cellMaker(cell3x3);
        System.out.println("base test");
        basemaker(base, cell1x1, cell2x2, cell3x3);
    }

    int [][] base = new int[9][9];
    int [][] cell1x1 = new int[3][3];
    int [][] cell2x2 = new int[3][3];
    int [][] cell3x3 = new int[3][3];

    public void printer(int [][] cellX){
        for(int r = 0; r < cellX.length; r++){
            for(int c = 0; c < cellX[r].length; c++){
                System.out.print(cellX [r][c] + " ");
            }
            System.out.println();
        }
    }

    public int cellSum(int [][] cellX){
        int sum = 0;
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                sum += cellX[r][c];
            }
        }
        return sum;
    }

    public int [][] appendCell(int row, int col, int num, int [][] cellZ){
        cellZ[row][col] = num;
        return cellZ;
    }

    public int [][] cellMaker(int [][] cellY){
        int sum = cellSum(cellY);
        int n = 1;
        while (sum != 45) {
            int r = (int) (Math.random() * 3);
            int c = (int) (Math.random() * 3);
            if (cellY[r][c] == 0) {
                appendCell(r, c, n, cellY);
                sum = cellSum(cellY);
                n++;
            }
        }
        printer(cellY);
        return cellY;
    }

    public int [][] basemaker(int [][] base, int [][] cell1x1, int [][] cell2x2, int [][] cell3x3){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                int n = cell1x1[r][c];
                appendCell(r, c, n, base);
            }
        }
        for(int rc = 0; rc < 3; rc++){
            int r = 3;
            int c = 3;
            for(int cc = 0; cc < 3; cc++){
                int n = cell2x2[rc][cc];
                appendCell(r, c, n, base);
                System.out.println("rc: " + rc + "cc: " + cc);
            }
            r++;
            c++;
        }
        for(int r = 6; r < 9; r++){
            for(int c = 6; c < 9; c++){
                if(base[r][c] == 0){
                    for(int rc = 0; rc < 3; rc++){
                        for(int cc = 0; cc < 3; cc++){
                            if(base[r][c] == 0){
                                int n = cell3x3[rc][cc];
                                appendCell(r, c, n, base);
                            }
                        }
                    }
                }
            }
        }
        printer(base);
        return base;
    }

}
