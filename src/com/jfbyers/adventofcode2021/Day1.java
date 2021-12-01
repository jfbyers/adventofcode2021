package com.jfbyers.adventofcode2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args){

        List<Integer> measurements = getMeasurements();
        //Part 1
        int valuePart1 = compute(measurements,1);

        System.out.println("Part 1: "+ valuePart1);

        //Part 2
        int valuePart2 = compute(measurements,3);
        System.out.println("Part 2: "+ valuePart2);
    }

    private static int compute(List<Integer> measurements, int windowSize) {
        int increases=0;
        for(int i = 1; i<= measurements.size() - windowSize; i++){
           int previous =  measurements.subList(i-1, i+windowSize - 1).stream().reduce(0, Integer::sum);
           int item =  measurements.subList(i, i + windowSize).stream().reduce(0, Integer::sum);;
           if (item > previous) {
               increases++;
           }
        }
       return+ increases;
    }


    private static List<Integer> getMeasurements() {

        try {
            Scanner scanner = new Scanner(new File("Day1-1Input.txt"));
            List<Integer> tall = new ArrayList<>();
            while (scanner.hasNext()) {
                tall.add(Integer.valueOf(scanner.next()));
            }
            return tall;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
