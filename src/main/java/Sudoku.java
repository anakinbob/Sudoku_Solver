public class Sudoku {
    private int _puzzleSize;

    public Sudoku(int puzzleSize) {
        _puzzleSize = puzzleSize;
    }

    public void runSudoku() {
        Console.print(generateSudokuString(createSudokuPuzzle(_puzzleSize),_puzzleSize));

    }

    private short[][] createSudokuPuzzle(int puzzleSize) {
        Console.print("Enter each number from top left going right in order\n");
        short[][] puzzle = new short[puzzleSize][];
        for(int i = 0; i < puzzleSize; i++) {
            short[] row = new short[puzzleSize];
            for(int j = 0; j < puzzleSize; j++) {
                try {
                    short num = Short.parseShort(Console.read());
                    if(num > puzzleSize) {
                        throw new NumberFormatException();
                    }
                    row[j] = num;
                } catch(NumberFormatException e) {
                    Console.print("\nYou have not printed a valid number, try again\n");
                    j--;
                }
            }
            puzzle[i] = row;
        }
        return puzzle;
    }

    private String generateSudokuString(short[][] puzzle, int puzzleSize) {
        StringBuilder puzzleBuilder = new StringBuilder("");
        for(int i = 0; i < puzzleSize; i++) {
            for(int j = 0; j < puzzleSize; j++) {
                puzzleBuilder.append(puzzle[i][j]);
                puzzleBuilder.append(" ");
            }
            puzzleBuilder.append("\n");
        }
        return puzzleBuilder.toString();
    }
}
