package Checker;
import java.util.*;

import VerifyModes.Result;

public abstract class Checker implements Runnable {
    protected static Checker instance;
    protected int[][] board;
    protected int num; // the value of row/column/box (1 to 9)
    // lists of all violations
    protected List<Violation> rowViolations = new ArrayList<>();
    protected List<Violation> colViolations = new ArrayList<>();
    protected List<Violation> boxViolations = new ArrayList<>();

    protected Checker(int[][] board, int num) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            throw new IllegalArgumentException("Board must be a 9x9 array.");
        }
        if(num < 1 || num > 9) {
            throw new IllegalArgumentException("num must be between 1 and 9.");
        }
        
        this.board = board;
        this.num = num;
    }

    protected abstract void findViolations(int[] numbers);
    
    public Result getResult() {
        return new Result(rowViolations, colViolations, boxViolations);
    }
}