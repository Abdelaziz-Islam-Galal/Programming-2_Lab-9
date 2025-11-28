import java.util.*;

public abstract class Checker implements Runnable {
    protected int[][] board;
    protected String type;
    protected List<Violation> violations; // Shared collection

    public Checker(int[][] board, String type, List<Violation> violations) {
        this.board = board;
        this.type = type;
        this.violations = violations;
    }

    protected void findAndAddDuplicates(int[] numbers, int index) {
        Map<Integer, Set<Integer>> numberPositions = new HashMap<>();

        // Track positions of each number
        for (int pos = 0; pos < numbers.length; pos++) {
            int num = numbers[pos];
            numberPositions.putIfAbsent(num, new HashSet<>());
            numberPositions.get(num).add(pos + 1); // 1-based positions
        }

        // Add violations for duplicates
        for (Map.Entry<Integer, Set<Integer>> entry : numberPositions.entrySet()) {
            if (entry.getValue().size() > 1) {
                synchronized (violations) {
                    violations.add(new Violation(type, index, entry.getKey(), entry.getValue()));
                }
            }
        }
    }
}