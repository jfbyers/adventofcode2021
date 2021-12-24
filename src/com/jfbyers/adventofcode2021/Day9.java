package com.jfbyers.adventofcode2021;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Day9 {

    private static final int SIZE = 100;

    public static void main(String[] args) {
        List<Point> points = part1();
        part2(points);
    }

    private static void part2(List<Point> points) {
        List<Basin> basins = new ArrayList<>();

        for (Point p : points){
            basins.add( new Basin(bfs(p)));
        }

        basins.sort(Comparator.comparing(Basin::getSize).reversed());
        System.out.println("Part 2 " + basins.get(0).getSize() * basins.get(1).getSize() * basins.get(2).getSize());
    }

    private static List<Point> part1() {
        Point[][] entries = parseEntries();
        List<Point> points = new ArrayList<>();
        int acum = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Point item  =entries[i][j];
                Point lowPoint = item.getNeighbours().stream()
                        .filter(point -> point.locationValue > item.locationValue)
                        .count() == item.getNeighbours().size() ? item : null;
                if (lowPoint != null) {
                    acum += lowPoint.locationValue + 1;
                    points.add(lowPoint);
                }
            }
        }
        System.out.println("Part 1  : "+ acum);
        return points;
    }

    public static int bfs(Point node)
    {
        Queue<Point> queue = new LinkedList<>();
        Queue<Point> visited = new LinkedList<>();
        int acum = 0;
        queue.add(node);
        acum++;
        visited.add(node);
        while (!queue.isEmpty())
        {
            Point element=queue.remove();
            List<Point> neighbours=element.getNeighbours();
            for (int i = 0; i < neighbours.size(); i++) {
                Point n=neighbours.get(i);
                if(n!=null && !visited.contains(n) && n.locationValue !=9)
                {
                    queue.add(n);
                    acum++;
                    visited.add(n);
                }
            }
        }
        return acum;
    }

    private static Point[][] parseEntries() {
        final File file = new File("Day9.txt");
        Point[][] entries = new Point[SIZE][SIZE];
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            AtomicInteger i = new AtomicInteger(0);
            while ((line = br.readLine()) != null) {
                final String[] pointArray =  line.replaceAll("(\\d)", "$1 ").split(" ");
                final Point[] lineVector = new Point[pointArray.length];
                for (int j = 0 ; j <pointArray.length; j++){
                    lineVector[j] = new Point(Integer.valueOf(pointArray[j]), i.get(), j);
                }
                entries[i.get()] = lineVector;
                i.incrementAndGet();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Point lowPoint = entries[i][j];
                addNeighbours(lowPoint,i,j,entries);
            }
        }
        return entries;
    }

    private static void addNeighbours(Point lowPoint, int i, int j, Point[][] entries) {

        if (i - 1 >= 0)  lowPoint.addneighbours(entries[i - 1][j]);
        if (i + 1 < SIZE) lowPoint.addneighbours(entries[i + 1][j]);
        if (j - 1 >= 0) lowPoint.addneighbours(entries[i][j - 1]);
        if (j + 1 < SIZE) lowPoint.addneighbours(entries[i][j + 1]);
    }

    private static class Point {

        int locationValue;
        int i;
        int j;
        List<Point> neighbours = new ArrayList<>();

        public Point(int locationValue, int i, int j) {
            this.locationValue = locationValue;
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "LowPoint{" +
                    "locationValue=" + locationValue +
                    ", i=" + i +
                    ", j=" + j +
                    '}';
        }

        public void addneighbours(Point neighbourNode) {
            this.neighbours.add(neighbourNode);
        }

        public List<Point> getNeighbours() {
            return neighbours;
        }
    }

    private static class Basin {
        int size;

        public Basin(int skz) {
            size = skz;
        }

        public int getSize() {
            return size;
        }
    }
}
