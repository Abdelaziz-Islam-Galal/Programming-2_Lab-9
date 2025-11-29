package VerifyModes;

import Checker.*;

public class Mode0 extends Verifier {
    public Mode0(int[][] board) {
        super(board);
    }

    @Override
    public Result verify() {
        for (int i = 0; i < 9; i++) {
            int[] row = RowChecker.collectInts(board, i);
            RowChecker rowChecker = new RowChecker(row, i + 1);
            rowChecker.run();

            int[] column = ColumnChecker.collectInts(board, i);
            ColumnChecker columnChecker = new ColumnChecker(column, i + 1);
            columnChecker.run();

            int[] box = BoxChecker.collectsInts(board, i);
            BoxChecker boxChecker = new BoxChecker(box, i + 1);
            boxChecker.run();
        }

        return Checker.getResult();
    }
}
