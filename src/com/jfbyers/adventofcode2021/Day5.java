package com.jfbyers.adventofcode2021;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Day5 {

    public static void main(String[] args) throws IOException {
        Matrix coords = parseCoords(false); //part 1
        System.out.println(coords.points.values().stream().filter(c -> c.crossed >= 2).count());
        Matrix coords2 = parseCoords(true); //part 2
        System.out.println(coords2.points.values().stream().filter(c -> c.crossed >= 2).count());

    }

    private static Matrix parseCoords(boolean processDiagonals) throws IOException {
        final Stream<String> lines = Files.lines(Paths.get("Day5.txt"));
        Matrix matr = new Matrix();
        lines.forEach(s -> {
            String[] borderCoord = s.split(" -> ");
            final String[] initCordValues = borderCoord[0].split(",");
            final String[] endCordValues = borderCoord[1].split(",");

            final Integer x = Integer.valueOf(initCordValues[0]);
            final Integer y = Integer.valueOf(initCordValues[1]);
            Coordinate initCord = matr.getCoordinateAt(x, y) == null ? new Coordinate(x, y) : matr.getCoordinateAt(x, y);
            final Coordinate coordinateAt1 = matr.getCoordinateAt(Integer.valueOf(endCordValues[0]), Integer.valueOf(endCordValues[1]));
            Coordinate endCord = coordinateAt1 == null ? new Coordinate(Integer.valueOf(endCordValues[0]), Integer.valueOf(endCordValues[1])) : coordinateAt1;
            matr.addCordinate(initCord);
            if (initCord.x == endCord.x) {
                for (int i = 1; i < Math.abs(initCord.y - endCord.y); i++) {
                    Coordinate coordToStart = initCord.y < endCord.y ? initCord : endCord;
                    Coordinate cord = matr.getCoordinateAt(initCord.x, coordToStart.y + i) == null ? new Coordinate(initCord.x, coordToStart.y + i) : matr.getCoordinateAt(initCord.x, coordToStart.y + i);
                    matr.addCordinate(cord);
                }
            } else if (initCord.y == endCord.y) {
                for (int i = 1; i < Math.abs(initCord.x - endCord.x); i++) {
                    Coordinate coordToStart = initCord.x < endCord.x ? initCord : endCord;
                    Coordinate cord = matr.getCoordinateAt(coordToStart.x + i, initCord.y) == null ? new Coordinate(coordToStart.x + i, initCord.y) : matr.getCoordinateAt(coordToStart.x + i, initCord.y);
                    matr.addCordinate(cord);
                }
            } else if (processDiagonals && (Math.abs(initCord.y - endCord.y) == Math.abs(initCord.x - endCord.x))) {  // diagonal

                for (int i = 1; i < Math.abs(initCord.y - endCord.y); i++) {
                    Coordinate coordXToStart = initCord.x < endCord.x ? initCord : endCord;
                    Coordinate coordToend = initCord.x < endCord.x ? endCord : initCord;
                    int multiplier = coordXToStart.y < coordToend.y ? 1 : -1;

                    final Coordinate coordinateAt = matr.getCoordinateAt(coordXToStart.x + i, coordXToStart.y + (multiplier * i));
                    Coordinate cord = coordinateAt == null ? new Coordinate(coordXToStart.x + i, coordXToStart.y + (multiplier * i)) : coordinateAt;

                    matr.addCordinate(cord);
                }
            }
            matr.addCordinate(endCord);


        });
        return matr;

    }


    private static class Coordinate {
        int x;
        int y;
        int crossed;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
            this.crossed = 0;
        }
    }

    private static class Matrix {
        Map<Point, Coordinate> points = new HashMap<>();

        Coordinate getCoordinateAt(int x, int y) {
            Point p = new Point(x, y);
            return points.get(p);
        }

        void addCordinate(Coordinate c) {
            Point p = new Point(c.x, c.y);
            c.crossed++;
            points.put(p, c);
        }
    }

    private static class Point {

        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
