import java.util.*;

public class RowChecker extends Checker {
    private int rowIndex;

    public RowChecker(int[][] board, int rowIndex, List<Violation> violations) {
        super(board, "ROW", violations);
        this.rowIndex = rowIndex;
    }

    @Override
    public void run() {
        int[] row = board[rowIndex];
        findAndAddDuplicates(row, rowIndex + 1); // 1-based indexing
    }
}