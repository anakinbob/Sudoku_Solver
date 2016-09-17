import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toSet;

public class Sudoku {
    private int _puzzleSize;
    private int[][] _puzzle;

    public Sudoku(int puzzleSize) {
        _puzzleSize = puzzleSize;
    }

    public void runSudoku() {
        _puzzle = createSudokuPuzzle(_puzzleSize);
        Console.print(generateSudokuString(_puzzle,_puzzleSize));
    }

    private int[][] createSudokuPuzzle(int puzzleSize) {
        Console.print("Enter each number from top left going right in order, 0 for unknown number\n");
        int[][] puzzle = new int[puzzleSize][];
        for(int i = 0; i < puzzleSize; i++) {
            int[] row = new int[puzzleSize];
            for(int j = 0; j < puzzleSize; j++) {
                try {

                    int num = Integer.parseInt(Console.read());
                    if(num > puzzleSize || num < 0) {
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

    private String generateSudokuString(int[][] puzzle, int puzzleSize) {
        StringBuilder puzzleBuilder = new StringBuilder("");
        for(int i = 0; i < puzzleSize; i++) {
            for(int j = 0; j < puzzleSize; j++) {
                if(puzzle[i][j] == 0) {
                    puzzleBuilder.append("_");
                } else {
                    puzzleBuilder.append(puzzle[i][j]);
                }
                puzzleBuilder.append(" ");
            }
            puzzleBuilder.append("\n");
        }
        return puzzleBuilder.toString();
    }

    private int[][] solve(int[][] puzzle) {
        return null;
    }

    private Set<Integer> extractRow(int rowNum) {
        Set<Integer> row = new HashSet<>();
        for(int i : _puzzle[rowNum]) {
            if(i != 0) {
                row.add(i);
            }
        }
        return row;
    }

    private Set<Integer> extractBox(int boxNum) {
        Set<Integer> box = new HashSet<>();
        int topLeftBoxIndexRow = 0;
        int topLeftBoxIndexColumn = 0;
        return null;
    }

    private Set<Integer> extractColumn(int columnNum) {
        return null;
    }
    
    private Set<Integer> generatePossibleNumbers(Set<Integer> numsInBox, Set<Integer> numsInRow, Set<Integer> numsInColumn) {
        Set<Integer> possibleNumList = new HashSet<Integer>();
        for(int i = 1; i <= _puzzleSize; i++) {
            if(!numsInBox.contains(i) && !numsInRow.contains(i) && !numsInColumn.contains(i)) {
                possibleNumList.add(i);
            }
        }
        return possibleNumList;
    }
}
