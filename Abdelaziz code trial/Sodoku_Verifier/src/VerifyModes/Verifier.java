package VerifyModes;
public abstract class Verifier {
    protected int[][] board;

    protected Verifier(int[][] board) {
        this.board = board;
    }

    public abstract Result verify();
}
