package VerifyModes;

import Checker.*;

public class Mode0 extends Verifier {
    public Mode0(int[][] board) {
        super(board);
    }

    @Override
    public Result verify() {
        Checker rowChecker = RowChecker.getInstance(board, 1);
        Checker colChecker = ColumnChecker.getInstance(board, 1);
        
        return result;
    }
}
