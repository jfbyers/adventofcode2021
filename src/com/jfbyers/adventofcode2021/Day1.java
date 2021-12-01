package com.jfbyers.adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1 {

    public static void main(String[] args) throws IOException {

        List<Integer> measurements = getMeasurements();
        //Part 1
        int valuePart1 = compute(measurements, 1);

        System.out.println("Part 1: " + valuePart1);

        //Part 2
        int valuePart2 = compute(measurements, 3);
        System.out.println("Part 2: " + valuePart2);
    }

    private static int compute(List<Integer> measurements, int windowSize) {
        int increases = 0;
        for (int i = 1; i <= measurements.size() - windowSize; i++) {
            int previous = measurements.subList(i - 1, i + windowSize - 1).stream().reduce(0, Integer::sum);
            int item = measurements.subList(i, i + windowSize).stream().reduce(0, Integer::sum);

            if (item > previous) {
                increases++;
            }
        }
        return increases;
    }


    private static List<Integer> getMeasurements() throws IOException {
        List<Integer> measurementList = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get("Day1-1Input.txt"))) {
            stream.forEach(s -> measurementList.add(Integer.valueOf(s)));
        }
        return measurementList;
    }
}
