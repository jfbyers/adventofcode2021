package com.jfbyers.adventofcode2021;


import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6 {

    private static List<Integer> lanternFish = Arrays.asList("1,2,5,1,1,4,1,5,5,5,3,4,1,2,2,5,3,5,1,3,4,1,5,2,5,1,4,1,2,2,1,5,1,1,1,2,4,3,4,2,2,4,5,4,1,2,3,5,3,4,1,1,2,2,1,3,3,2,3,2,1,2,2,3,1,1,2,5,1,2,1,1,3,1,1,5,5,4,1,1,5,1,4,3,5,1,3,3,1,1,5,2,1,2,4,4,5,5,4,4,5,4,3,5,5,1,3,5,2,4,1,1,2,2,2,4,1,2,1,5,1,3,1,1,1,2,1,2,2,1,3,3,5,3,4,2,1,5,2,1,4,1,1,5,1,1,5,4,4,1,4,2,3,5,2,5,5,2,2,4,4,1,1,1,4,4,1,3,5,4,2,5,5,4,4,2,2,3,2,1,3,4,1,5,1,4,5,2,4,5,1,3,4,1,4,3,3,1,1,3,2,1,5,5,3,1,1,2,4,5,3,1,1,1,2,5,2,4,5,1,3,2,4,5,5,1,2,3,4,4,1,4,1,1,3,3,5,1,2,5,1,2,5,4,1,1,3,2,1,1,1,3,5,1,3,2,4,3,5,4,1,1,5,3,4,2,3,1,1,4,2,1,2,2,1,1,4,3,1,1,3,5,2,1,3,2,1,1,1,2,1,1,5,1,1,2,5,1,1,4".split(",")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList());

    public static void main(String[] args)   {

        System.out.println("After 80 days: " +  countFish(80));
        System.out.println("After 256 days: " +  countFish(256));
    }

    private static long countFish(int numberOfDays) {

        Map<Long, Long> fishMapping = getNewFishMapping();

        for (int i = 0; i < numberOfDays; i++) {
            long newFishes = 0;
            for (long day = 0; day <= 8; day++) {
                if (day == 0) {
                    newFishes = fishMapping.get(day);
                } else {
                    fishMapping.put(day - 1, fishMapping.get(day));
                }
            }
            fishMapping.put(8L, newFishes);
            fishMapping.put(6L, fishMapping.get(6L) + newFishes);
        }
        return fishMapping.values().stream().mapToLong(Long::longValue).sum();
    }

    private static Map<Long, Long> getNewFishMapping() {
        Map<Long, Long> fishMapping = new HashMap<>();
        for (long i = 0; i <= 8; i++) {
            final long day = i;
            fishMapping.put(day, lanternFish.stream().filter(val -> val == day).count());
        }
        return fishMapping;
    }


}
