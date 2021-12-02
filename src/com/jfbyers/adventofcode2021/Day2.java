package com.jfbyers.adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) throws IOException {
        resolve(1);
        resolve(2);
    }

    private static void resolve(int part) throws IOException {
        AtomicInteger horizontal = new AtomicInteger(), aim = new AtomicInteger(), depth = new AtomicInteger();
        final Stream<String> lines = Files.lines(Paths.get("Day2-1.txt"));

        lines.forEach(line -> {
            String[] split = line.split(" ");
            String operand = split[0];
            int units = Integer.valueOf(split[1]);
            switch (operand) {
                case "forward":
                    horizontal.addAndGet(units);
                    if (part == 2) depth.addAndGet(aim.get() * units);
                    break;
                case "down":
                    if (part == 2)
                        aim.addAndGet(units);
                    else
                        depth.addAndGet(units);
                    break;
                case "up":
                    if (part == 2)
                        aim.addAndGet(-units);
                    else
                        depth.addAndGet(-units);
                    break;
            }
        });
        System.out.println("Part " + part + " : " + horizontal.get() * depth.get());
    }

}
