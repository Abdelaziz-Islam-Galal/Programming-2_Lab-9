package Checker;

import java.util.*;

public class RowChecker extends Checker {

    public RowChecker(int[][] board, int num) {
        super(board, num);
    }

    @Override
    public void run() {
        int[] row = board[num - 1];
        findViolations(row);
    }

    @Override
    protected void findViolations(int[] numbers) {
        for (int j = 1; j <= 9; j++) {
            Set<Integer> positions = new HashSet<>();
            for (int k = 0; k < numbers.length; k++) {
                if (numbers[k] == j) {
                    positions.add(k + 1);
                }
            }
            if (positions.size() > 1) {
                Violation violation = new Violation('r', num, j, positions);
                rowViolations.add(violation);
            }
        }
    }
}