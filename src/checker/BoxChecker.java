package checker;

import board.SudokuBoard;
import result.ResultCollector;

public class BoxChecker extends Checker {

    private final int boxIndex;

    public BoxChecker(int boxIndex, SudokuBoard board, ResultCollector results) {
        super(board, results);
        this.boxIndex = boxIndex;
    }

    @Override
    public void run() {
        int[] box = board.getBox(boxIndex);
        results.check("BOX", boxIndex, box);
    }
}
