//import java.text.*;

public class SudokuMain {
    public static void main(String[] args) {
        new SudokuMain();
    }

    public SudokuMain() {
        System.out.println("Cell 1x1");
        cellMakerDiagonal(cell1x1);
        System.out.println("Cell 2x2");
        cellMakerDiagonal(cell2x2);
        System.out.println("Cell 3x3");
        cellMakerDiagonal(cell3x3);
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

    public int [][] cellMakerDiagonal(int [][] cellY){
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
        for(int r = 3, rc = 0; r < 6 && rc < 3; r++, rc++){
            for(int c = 3, cc = 0; c < 6 && cc < 3; c++, cc++){
                int n = cell2x2[rc][cc];
                appendCell(r, c, n, base);
            }
        }
        for(int r = 6, rc = 0; r < 9 && rc < 3; r++, rc++){
            for(int c = 6, cc = 0; c < 9 && cc < 3; c++, cc++){
                int n = cell3x3[rc][cc];
                appendCell(r, c, n, base);
            }
        }
        printer(base);
        return base;
    }

    public int [][] cellMaker1x3(int [][] cellY){
        int sum = cellSum(cellY);
        int n = 1;
        while (sum != 45) {
            int r = (int) (Math.random() * 3);
            int c = (int) (Math.random() * 3);
            if (cellY[r][c] == 0 && n != cell1x1[r][c] && n != cell3x3[r][c]) {
                appendCell(r, c, n, cellY);
                sum = cellSum(cellY);
                n++;
            }
        }
        printer(cellY);
        return cellY;
    }

}
