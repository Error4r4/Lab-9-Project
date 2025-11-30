package checker;

import board.SudokuBoard;
import result.ResultCollector;

public class ColumnChecker extends Checker {

    private final int colIndex;

    public ColumnChecker(int colIndex, SudokuBoard board, ResultCollector results) {
        super(board, results);
        this.colIndex = colIndex;
    }

    @Override
    public void run() {
        int[] col = board.getColumn(colIndex);
        results.check("COL", colIndex, col);
    }
}
