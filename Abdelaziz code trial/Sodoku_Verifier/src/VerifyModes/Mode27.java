package VerifyModes;

import Checker.*;

public class Mode27 extends Verifier {
    private static Mode27 instance;

    private Mode27(int[][] board) {
        super(board);
    }

    public static Mode27 getInstance(int[][] board) {
        if (instance == null) {
            instance = new Mode27(board);
        }
        return instance;
    }

    @Override
    public Result verify() {
        // Check rows, columns, boxes sequentially

        return Checker.getResult();
    }
}
