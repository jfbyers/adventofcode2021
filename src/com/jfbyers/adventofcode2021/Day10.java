package com.jfbyers.adventofcode2021;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day10 {

    private static final List<Character> OPENING_CHARS = List.of('<', '[', '{', '(');

    public static void main(String ars[]) {
        final File file = new File("Day10.txt");
        List<Long> scores = new ArrayList<>();

        final Deque<Character> closingChars = new ArrayDeque<>();
        int acum = 0;
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String line;
            boolean corrupted;
            while ((line = br.readLine()) != null) {
                corrupted = false;
                char[] chunks = line.toCharArray();
                for (Character c : chunks) {
                    if (OPENING_CHARS.contains(c)) {
                        Character closingChar = getClosingChar(c);
                        closingChars.push(closingChar);
                    } else {  //is closing char
                        final Character closing = closingChars.poll();
                        if (closing != c) {
                            //System.out.println("Expected " +closing + ", but found "+ c +" instead.");
                            acum += getSyntaxErrorScore(c);
                            corrupted = true;
                            continue;
                        }
                    }
                }
                if (!corrupted && !closingChars.isEmpty()) { //incomplete line
                    final String complete = toArray(closingChars);
                    //System.out.println(line + "- Complete by adding " + complete);
                    long score = getScore(complete);
                    scores.add(score);
                }
                closingChars.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Part 1
        System.out.println("Error score: " + acum);
        Collections.sort(scores);
        Long middle = scores.get((scores.size() / 2));

        //Part 2
        System.out.println("Middle score: " + middle);

    }

    private static long getScore(String complete) {
        long acum = 0L;
        char[] chars = complete.toCharArray();
        for (char c : chars) {
            acum = acum * 5 + points(c);
        }
        return acum;
    }

    private static int points(char c) {
        switch (c) {
            case ')':
                return 1;
            case ']':
                return 2;
            case '}':
                return 3;
            case '>':
                return 4;
            default:
                throw new AssertionError("Bad input char: " + c);
        }
    }

    private static String toArray(Deque<Character> closingChars) {
        char[] chars = new char[closingChars.size()];
        for (int i = 0; !closingChars.isEmpty(); i++) {
            chars[i] = closingChars.poll();
        }
        return new String(chars);
    }

    private static Character getClosingChar(Character c) {
        switch (c) {
            case '<':
                return '>';
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
            default:
                throw new AssertionError("Bad input char: " + c);
        }
    }

    private static int getSyntaxErrorScore(Character c) {
        switch (c) {
            case ')':
                return 3;
            case ']':
                return 57;
            case '}':
                return 1197;
            case '>':
                return 25137;
            default:
                throw new AssertionError("Bad input char: " + c);
        }
    }

}
