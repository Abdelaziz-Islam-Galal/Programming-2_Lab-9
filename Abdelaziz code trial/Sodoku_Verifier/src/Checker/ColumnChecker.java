package Checker;
import java.util.*;

public class ColumnChecker extends Checker {

    private ColumnChecker(int[][] board, int num) {
        super(board);
        this.num = num;
    }

    @Override
    public Checker getInstance(int[][] board, int num) {
        if (instance == null) {
            instance = new ColumnChecker(board, num);
        }

        return instance;
    }

    @Override
    public void run() {
        int[] column = new int[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][num-1];
        }
        findViolations(column);
    }

    @Override
    protected void findViolations(int[] numbers) {
        for(int j = 1; j <= 9; j++) {
            Set<Integer> positions = new HashSet<>();
            for(int k = 0; k < numbers.length; k++) {
                if(numbers[k] == j) {
                    positions.add(k + 1);
                }
            }
            if(positions.size() > 1) {
                Violation violation = new Violation('c', num, j, positions);
                colViolations.add(violation);
            }
        }
    }
}