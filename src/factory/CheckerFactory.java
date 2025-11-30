package factory;

import board.SudokuBoard;
import checker.BoxChecker;
import checker.ColumnChecker;
import checker.RowChecker;
import result.ResultCollector;

import java.util.ArrayList;
import java.util.List;

public class CheckerFactory {


    public static List<Thread> createCheckers(int mode, SudokuBoard board, ResultCollector results) {
        List<Thread> list = new ArrayList<>();

        if (mode == 0) {
            for (int i = 0; i < 9; i++) results.check("ROW", i, board.getRow(i));
            for (int i = 0; i < 9; i++) results.check("COL", i, board.getColumn(i));
            for (int i = 0; i < 9; i++) results.check("BOX", i, board.getBox(i));
            return List.of();
        }
        else if (mode == 3) {
            Thread rows = new Thread(() -> {
                for (int i = 0; i < 9; i++) results.check("ROW", i, board.getRow(i));
            }, "RowsChecker");
            Thread cols = new Thread(() -> {
                for (int i = 0; i < 9; i++) results.check("COL", i, board.getColumn(i));
            }, "ColsChecker");
            Thread boxes = new Thread(() -> {
                for (int i = 0; i < 9; i++) results.check("BOX", i, board.getBox(i));
            }, "BoxesChecker");
            list.add(rows);
            list.add(cols);
            list.add(boxes);
        } else { // mode == 27
            for (int i = 0; i < 9; i++) list.add(new Thread(new RowChecker(i, board, results)));
            for (int i = 0; i < 9; i++) list.add(new Thread(new ColumnChecker(i, board, results)));
            for (int i = 0; i < 9; i++) list.add(new Thread(new BoxChecker(i, board, results)));
        }

        return list;
    }
}
