package com.jfbyers.adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day2 {

    public static void main(String[] args) throws IOException {

            AtomicInteger horizontal = new AtomicInteger(), depth = new AtomicInteger(), aim =  new AtomicInteger();
            final Stream<String> lines = Files.lines(Paths.get("Day2-1.txt"));
            lines.forEach(line -> {
                String[] splitted = line.split(" ");
                String operand = splitted[0];
                int units = Integer.valueOf(splitted[1]);
                switch (operand) {
                    case "forward":
                        horizontal.addAndGet(units);
                        depth.addAndGet ( aim.get() * units);
                        break;
                    case "down":
                        aim.addAndGet(units);
                        break;
                    case "up":
                        aim.addAndGet(-units);
                        break;
                }
            });
            System.out.println(horizontal.get() * depth.get());
    }
}
