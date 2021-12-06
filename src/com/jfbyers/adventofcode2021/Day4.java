package com.jfbyers.adventofcode2021;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {

    private static List<Integer> numbers = Arrays.asList("94,21,58,16,4,1,44,6,17,48,20,92,55,36,40,63,62,2,47,7,46,72,85,24,66,49,34,56,98,41,84,23,86,64,28,90,39,97,73,81,12,69,35,26,75,8,32,77,52,50,5,96,14,31,70,60,29,71,9,68,19,65,99,57,54,61,33,91,27,78,43,95,42,3,88,51,53,30,89,87,93,74,18,15,80,38,82,79,0,22,13,67,59,11,83,76,10,37,25,45".split(",")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());
    private static List<Board> boards = parseBoards();

    public static void main(String[] args) {

        final TreeMap<Integer, Board> boardsPlays = new TreeMap<>();
        for (Board b : boards) {
            int plays = playBingo(b);
            boardsPlays.put(plays, b);
        }

        Board winningBoard = boardsPlays.firstEntry().getValue();
        Integer numberCalled = numbers.get(boardsPlays.firstKey());
        resolve(winningBoard, numberCalled);
        Board lastWinningBoard = boardsPlays.lastEntry().getValue();
        Integer lastNumberCalled = numbers.get(boardsPlays.lastKey());
        resolve(lastWinningBoard, lastNumberCalled);

    }

    private static void resolve(Board winningBoard, Integer numberCalled) {
        int acum = 0;
        for (BoardNumber[] rows : winningBoard.rows) {
            for (BoardNumber number : rows) {
                if (!number.isMarked) {
                    acum += number.value;
                }
            }
        }
        System.out.println("Value: " + (numberCalled * acum));
    }

    private static int playBingo(Board b) {
        for (int plays = 0; plays < numbers.size(); plays++) {
            int number = numbers.get(plays);
            b.play(number);
            if (b.bingo()) {
                return plays;
            }
        }
        return -1;
    }

    private static List<Board> parseBoards() {
        final File file = new File("Day4-1.txt");
        List<Board> boards = new ArrayList<>();
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                Board b = new Board();
                int i = 0;
                while (line != null && !line.equals("")) {
                    Integer[] row = Arrays.asList(line.replaceAll("  ", " ").replaceAll("^ ", "").split(" ")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList()).toArray(new Integer[0]);
                    b.addRow(row);
                    b.addCol(i, row);
                    line = br.readLine();
                    i++;
                }
                boards.add(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boards;

    }

    private static class Board {

        List<BoardNumber[]> rows = new ArrayList<>(5);
        List<BoardNumber[]> cols = new ArrayList<>(5);

        public Board() {
            for (int i = 0; i < 5; i++) {
                BoardNumber[] colNumbers = new BoardNumber[5];
                cols.add(colNumbers);
            }
        }

        public void addRow(Integer[] numbers) {
            BoardNumber[] row = Arrays.asList(numbers).stream().map(integer -> new BoardNumber(integer)).collect(Collectors.toList()).toArray(new BoardNumber[0]);
            this.rows.add(row);
        }

        public void addCol(int rowIndex, Integer[] rowValues) {

            for (int i = 0; i < rowValues.length; i++) {
                BoardNumber[] col = cols.get(i);
                col[rowIndex] = new BoardNumber(rowValues[i]);
            }
        }

        public void play(Integer numberToCheck) {
            checkNumberInArray(numberToCheck, rows);
            checkNumberInArray(numberToCheck, cols);
        }

        private void checkNumberInArray(Integer numberToCheck, List<BoardNumber[]> rows) {
            for (BoardNumber[] row : rows) {
                for (BoardNumber number : row) {
                    if (numberToCheck.equals(number.value)) {
                        number.isMarked = true;
                        break;
                    }
                }
            }
        }

        public boolean bingo() {
            if (checkRows(cols)) return true;
            if (checkRows(rows)) return true;
            return false;
        }

        private boolean checkRows(List<BoardNumber[]> rows) {
            for (BoardNumber[] row : rows) {
                boolean[] line = new boolean[5];

                for (int i = 0; i < row.length; i++) {
                    BoardNumber number = row[i];
                    if (number.isMarked) {
                        line[i] = true;
                    }
                }
                if (isLine(line)) {
                    return true;
                }
            }
            return false;
        }

        private boolean isLine(boolean[] line) {
            for (boolean v : line) {
                if (!v) return false;
            }
            return true;
        }
    }

    private static class BoardNumber {

        Integer value;
        boolean isMarked = false;

        public BoardNumber(Integer integer) {
            this.value = integer;
        }
    }
}
