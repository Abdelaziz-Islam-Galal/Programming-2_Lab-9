package VerifyModes;
public class VerifyFactory {
    public static Verifier createVerifier(int mode, int[][] board) {
        switch (mode) {
            case 0:
                return new Mode0(board);
            case 3:
                return new Mode3(board);
            case 27:
                return new Mode27(board);
            default:
                throw new IllegalArgumentException("Invalid mode: " + mode);
        }
    }
}
