package Checker;

import java.util.*;

public class RowChecker extends Checker {

    public RowChecker(int[] values, int num) {
        super(values, num);
    }
    
    public RowChecker(int[] values, int num, boolean isSync) {
        super(values, num, isSync);
    }

    @Override
    public void run() {
        findViolations(values);
    }

    public static int[] collectInts(int[][] board, int rowIndex) {
        int[] row = new int[9];
        for (int j = 0; j < 9; j++) {
            row[j] = board[rowIndex][j];
        }
        return row;
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
                if (isSync) {
                    addViolation(violation);
                } else {
                    rowViolations.add(violation);
                }
            }
        }
    }

    @Override
    protected synchronized void addViolation(Violation violation) {
        try {
            this.wait();
        } catch (InterruptedException e) {
            System.out.println("Interrupt exception catched");
        }
        rowViolations.add(violation);
        notify();
    }
}