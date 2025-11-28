import java.util.*;

public class BoxChecker extends Checker {
    private int boxIndex;

    public BoxChecker(int[][] board, int boxIndex, List<Violation> violations) {
        super(board, "BOX", violations);
        this.boxIndex = boxIndex;
    }

    @Override
    public void run() {
        int[] box = extractBox(boxIndex);
        findAndAddDuplicates(box, boxIndex + 1);
    }

    private int[] extractBox(int boxIndex) {
        int[] box = new int[9];
        int startRow = (boxIndex / 3) * 3;
        int startCol = (boxIndex % 3) * 3;
        int pos = 0;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                box[pos++] = board[i][j];
            }
        }
        return box;
    }
}