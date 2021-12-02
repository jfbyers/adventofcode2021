package com.jfbyers.adventofcode2021;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {

    private final static List<Instruction> PROGRAM = parseProgram();

    public static void main(String[] args){
        int horizontal = 0,  depth = 0 , aim = 0;
        for (Instruction i : PROGRAM){
            switch (i.op){
                case "forward":
                    horizontal += i.units;
                    depth += aim * i.units;
                    break;
                case "down":
                    aim += i.units;
                    break;
                case "up":
                    aim -= i.units;
                    break;
            }
        }
        System.out.println(horizontal * depth);
    }
    private static List<Instruction> parseProgram() {
        try {
            final Stream<String> lines = Files.lines(Paths.get("Day2-1.txt"));
            return lines.map(line -> {
                String[] splitted = line.split(" ");
                return new Instruction(splitted[0], splitted[1]);
            }).collect(Collectors.toUnmodifiableList());
        } catch (IOException e) {
            //ignored
        }
        return Collections.emptyList();
    }

    private static class Instruction {
        String op;
        int units;

        public Instruction(String operand, String units) {
            this.op = operand;
            this.units = Integer.valueOf(units);
        }
    }
}
