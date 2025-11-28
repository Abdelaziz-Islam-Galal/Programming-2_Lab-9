public class App {
    private CSVReader csvReader;
    private ResultFormatter formatter;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar app.jar <csv-file> <mode>");
            return;
        }

        String csvFile = args[0];
        int mode = Integer.parseInt(args[1]);

        run(csvFile, mode);
    }

    public static void run(String csvFile, int mode) {
        try {
            // Read board
            int[][] board = csvReader.readBoard(csvFile);

            // Create appropriate verifier using factory
            SudokuVerifier verifier = VerifierFactory.createVerifier(mode, board);

            // Perform verification
            VerificationResult result = verifier.verify();

            // Format and display results
            String output = formatter.format(result);
            System.out.println(output);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}