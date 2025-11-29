package VerifyModes;

import Checker.*;

public class Mode3 extends Verifier{
    private static Mode3 instance;

    private Mode3(int[][] board) {
            super(board);
    }

    public static Mode3 getInstance(int[][] board) {
        if (instance == null) {
            instance = new Mode3(board);
        }
        return instance;
    }

    @Override
        public Result verify() {
            // Check rows, columns, boxes sequentially

            return Checker.getResult();
        }
}
