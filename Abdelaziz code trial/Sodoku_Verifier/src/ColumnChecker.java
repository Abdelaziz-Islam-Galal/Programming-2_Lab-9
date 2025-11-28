import java.util.*;

public class ColumnChecker extends Checker {
    private int colIndex;

    public ColumnChecker(int[][] board, int colIndex, List<Violation> violations) {
        super(board, "COL", violations);
        this.colIndex = colIndex;
    }

    @Override
    public void run() {
        int[] column = new int[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][colIndex];
        }
        findAndAddDuplicates(column, colIndex + 1);
    }
}