package com.jfbyers.adventofcode2021;


import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {

    private static final int WORD_LENGTH = 12;

    private static String[] DIAGNOSTIC_REPORT = ("011000110010 111011101000 110100110010 011010101110 111010100100 100111111100 110001110000 000100100100 000110101101 101011100110 110011000110 111100101111 000011010111 001111100100 100010101101 101100000010 001100001111 001001001110 100100110000 000000011001 000111001000 101000110110 110011010000 101110111011 111000000011 101100110100 111110001010 001101001111 100101011001 010101111111 111100111001 010100111010 111110100111 100101110111 110001001100 110111001110 011111011011 011111010111 001100101111 110111011101 000110010111 001100000001 111101100100 100111110010 111010001010 000010000001 000011101110 110011100101 011101100010 101100010101 010110110101 000010111001 100111010101 000101010001 000000110111 110010000111 000101010111 011100101000 011111101011 101001110110 000000110100 100101001100 111100010101 001000001101 111101101011 110101010010 011101000100 100000100011 111110110110 001010010111 111001010101 011011011100 001010010001 001101111110 100100111010 100011000110 111010000111 000111000101 000110000011 111000011110 011110110001 011111111011 100001000010 001011111011 101111101011 001111110001 010001000000 011001100111 110100101110 001001110110 101110011101 110011101001 101111000010 110000000110 011000010001 010001011111 111000001111 000101101011 110011010001 000011110101 101010110010 001111001001 001011000100 001001101001 010011010101 010011011011 101101011100 011111011001 101011100001 000100011011 111011000011 001001001101 111110011111 110101101111 100100111110 110000110100 011010110111 101000000100 111110010100 111111001100 100101100110 111111010000 011011100111 000111100100 011011100000 111011100000 001001111010 010111010111 011100110101 101010111100 101111110101 110101001110 110000001011 100111011000 011010011000 111101010011 101011010110 110110001101 100111010000 110100000001 110001010001 001000110011 110010110101 010000011010 001010111101 001000110001 111111000101 111101010101 001000000010 101010101001 000000010011 101111010101 000100111001 001111001111 000100000001 100010101001 010011101011 011001101100 011001001100 110010111110 000000010000 010010110110 101101110101 010001101010 111001011100 001100000110 110001110010 100001001001 101011000010 111011100011 011101010010 011000100000 100000110111 100100100101 100110101011 011101000111 011001010101 110011100010 001100100001 111000010110 000110100110 001001011000 101000011010 001101001101 111110000111 001110111011 001111101110 111000101101 000111010011 110101010000 010101000011 110011100110 111001011111 011101011111 001000101110 001111001000 001111010000 110010010010 100010110110 000011101000 010001100111 101100001001 100000000110 010101000111 000001100111 101010111000 000101010101 001011011010 110011000111 000101000101 111111011011 111001100010 101111110110 111110011011 110011010110 100110001101 111100000000 101101010001 011100101110 100011101110 111100010010 010111111010 100000101000 011001111001 100001010100 100111011101 001101100011 001001110100 101011010100 001101111000 101111010010 110001000111 100001000101 100110110011 000011101100 111000000000 010110000011 011001000111 010101100101 110100100010 111100100100 010011011101 101100100110 011111111001 101100111001 000000110110 011111110110 000110110101 111111010110 111000111001 111111100001 010000111111 000100000111 010101001110 011001011101 110111100101 100011001001 110100101101 110110010111 101001010111 011011010011 100100000000 111001101000 001101010101 000100010100 100001101000 011001101110 100111100111 011001111110 101011111111 100111100001 000001011110 010110100011 100100010110 001010011110 101101111001 000100111100 101011011011 011010000111 001011011001 001110110000 110001001011 011100010110 111011110101 110100000110 101001011100 010010001000 111001110101 000111000011 110111010110 011111111010 101000011111 111001100101 011100000000 010101010111 100111111011 110100001111 010111011101 011000100010 111111000110 111011100110 100010111100 110100111000 100001010101 101101100011 011001001101 011011111000 000011111010 011010110001 001000110010 011000111110 010101110011 101011110100 100011011011 111010000010 011010101000 101110111111 011110111011 011101101111 110010011001 010001100011 001101010011 100001001010 110110110111 010010100000 100110000100 110110101110 100101101001 110101001111 011101110110 010111111001 000010101110 000000001000 111110000000 100010010011 011100011101 100100001000 101001000111 011000001111 100111111001 000001000011 000111100101 111001010001 110011011010 101000100111 111101100010 110100001011 111111001101 001001001001 010110010110 001111010101 011010010100 001110001000 000011110010 010111111100 101101001011 011001111111 000110110111 101001001110 100000011101 100100110111 111001110110 100110011001 001010000101 111011000110 110010010101 000110000001 111111010111 100100100000 000110011111 000111110011 100100101001 100100001100 110010001110 010100001010 101001000010 001100000000 001011111001 011100001001 010010000101 110101100111 101110111100 111011000001 000111010111 010000000100 101101001100 101010001100 000101011010 110011101011 110101010001 000010111000 101010011111 010011011010 011011001000 010100110101 010111100111 011011000111 100001110011 101000000010 000110010000 101011101011 010000010100 011100000100 001010111010 011111001001 000101110101 100001001100 111000011101 001101101110 010100011110 100101111100 000010100000 111100001001 001110000010 100000100110 011000001011 110110110101 001100000101 000001100110 000001010111 110101011101 001010010101 110011101100 110101110010 000101100010 111000100000 001110111001 010100110100 101000100010 011110100101 011110000111 000011000111 101101101001 000011001001 000111011010 000110001000 011100101011 100110110110 001110100011 001110100101 111011101110 100110110111 111000000110 001110001111 011001101011 111000110100 000101110111 001001001111 010111101010 100010101110 111001100000 111111000000 111010101111 010010010010 110011010111 000001101010 101101111110 100011000111 100111001110 011110111010 001101000101 100000001101 011001110000 001011100001 011101000000 100010010101 111111011111 000001110001 001110010010 111000110011 010001011011 100011010010 001110011101 000100001010 111000001000 001001111011 010000111000 010111000010 110010000011 001111001100 001100101001 011010110010 001010001111 100010100011 100110111111 000101110110 010100000001 110010011110 100000111001 011101100000 001010110101 101101011111 010101111010 110101011111 100110111110 011101010100 110101001010 010100110111 101100000101 100000100010 000011100110 010000010011 000010101101 101001111011 000100110100 001110110001 100010101100 111010001011 000000101110 111101000100 000011011110 100010001000 001101101010 101100100100 000101001111 101000101111 001110101001 001101010100 000011000010 001001100000 111101010010 000001101001 010011110000 000100110000 010000101011 011110011111 110011100011 010000110011 110101111000 101000001010 110101100101 010110100010 101001000110 101101111100 011001011000 100011101011 110111111110 111000111110 110010001111 101010100011 001100100111 001111100111 101101001111 100111011110 101010101100 000100010010 111011110001 101111111101 000001000010 101010110110 001100001010 001111011111 110110111111 100110010111 001011001011 000011001101 011000110011 000100101111 100111010100 011000011011 000010101010 010111110111 000100011001 110110001100 100010011100 111110000001 101110011100 111011110100 001101100101 000110001111 001101110111 000010101001 111010101000 010000001001 100100011001 100001011000 011110110000 000001010110 101000001000 001100011110 110010100001 000011100001 111111001110 011110011110 100110111100 100001011100 100011011010 011000011110 110011000101 001100011100 011110010010 110000101110 010011100111 010111010110 111010011001 110000011010 000101101000 010111001100 001000010011 001110101110 000101101001 110111101001 111101011000 000011110111 011010101100 110110110110 000011011100 111110001111 100110100001 110100010111 101001111000 001111000011 110111011010 101001100001 001001010001 011010101010 111010100010 010011100010 111011011010 001000000110 011111010010 100000010000 000001110011 001010111100 110000110110 110011001010 001011001100 100010100001 100110010000 100100011011 100111001100 100101001001 000100101101 101000101000 010011100001 111101101000 011010010001 100100110110 110001011101 011001111010 100101000000 011110100000 001000001100 111000101010 001011000010 110000101100 110011011000 011010100101 100111001011 110110111100 100101101000 000010111100 010010010101 100110101100 010101101111 101100111111 001111111011 100000111101 010010111100 001011110000 111010011000 000101111110 011011111011 000001101011 000111111000 000111010001 000111110010 100000111111 110100101100 001010100100 001111011010 111011010010 111111000011 001000101111 000000000010 111011100010 111000110000 000000110010 111110111011 000110100111 101000000011 011101100011 001010000011 011001111101 000101011101 101101110010 011011101101 101011110001 110110010110 101110111000 111010110111 001001111100 100101011110 101000010100 101000110010 001110110111 000001000111 100101000001 011111011100 101010001000 001101010000 110101001000 001010010011 101001011000 111101010001 100000110100 110101000011 000011101111 001011000101 110100101011 010000011000 100011001101 101010001111 001011101011 011110010001 011010001101 111110011001 110110001111 100100111011 110001110011 110000100001 010010010000 011111010011 101100111011 010111100110 111000101001 000000110001 000010001110 010110101111 001100001100 101011011001 000010001010 101100100111 011011101010 111011010001 001011101010 110011111011 011101000101 101101100100 101100111010 100001000100 111001111111 110001000011 000101110000 100101000010 000000000100 110001000000 110111010001 010011101010 010101110001 111101110011 000000101011 011011111101 100101110010 110000111101 000110111101 100011000100 011011111100 101110101011 110100110101 110001001010 010111001111 010011100101 011010011111 011000011111 110000010000 011000001010 111111001010 010001000011 110110000110 110110111000 010110011011 100000101110 101111100100 110011100100 011010111000 011001001111 101000100000 001010001000 001000101011 111101111100 111110100000 001111111010 000000111101 100011100010 000101101101 011111000111 010010001001 000001110100 010000010010 101110011111 001010000001 011100010111 111001111000 001100101011 100111101101 111011011100 100001101110 100100010010 000110111111 010011101100 110001100100 011010111100 000000101100 001011110110 011101100001 000100111101 111011111111 000101100011 101011001011 110110101001 000001100101 010111100001 110001001101 011000000000 101100001110 101101011101 100011110110 100101000100 001001011100 100101100000 010000101010 001001101100 011111110010 110101101000 100000100101 011111010100 111110000100 000010110001 110110110001 001001100010 101000001110 101111010011 101101100010 011110100110 011100100010 000001110110 111010010100 111111111110 111010100101 100100110001 000100001001 100010111110 001111000000 110110111110 100111110101 110000110000 001000101100 011111000110 011000110100 111010100111 010101000010 110111100011 011111111000 100111000101 000010011111 101010100100 111001010011 101111101101 000111011110 100110001011 110101010111 000010010000 100111101110 111101011100 001000101010 001011001001 011010100000 001100010100 110111000001 100100011100 110111000100 011001011011 111000010100 101110100000 100000010001 100000001001 001010000110 100011011110 100111011011 100110110100 111000110010 000001001011 111001110111 011101000010 010101100110 101011110011 111100011110 111100011101 101110011110 101010001101 111100000110 000111111111 001010101101 011101000011 100000001110 110101101100 000100110001 111101101001 101010001001 001101011010 011000000101 011101101001 011000100001 100101010100 011000101100 010110110010 000010011011 110101001011 101001111001 101000101001 011001100010 100010001011 001100100110 100000111011 001111100001 101110001101 101010000010 110010101100 100100000100 011001111011 101000010001 110101101101 101000000001 101111101000 011001110110 111101010110 110001011111 110111110111 010010110100 111111100000 110100011010 000110100011 010001111010 010111100101 000001110000 011110000110 101010111010 001000010111 000001000101 010101001010 011111010000 000011100011 100011101010 111011011001 111111100101 010000101101 011110010111 110100101010 000110101111 110101010011 101110000010 110101011001 110110111101 010101110100 101001101011 101100000111 010001111110 101110001110 011011110001 010111000101 001010111000 001010000111 001111001110 100010011110 100000110010 100000011111 001000100010 010111001110 011110011100 010001101101 101011001001 000001001001 100110011000 000001111010 110010101110 101101001000 001011100110 000101001011 110100010101 110101000010 110010111101 011110001111 000011010001 010000111101 011110001110 110110111001 101111111011 101011111110 110001111101 011010010110 111011011111 110100100001 100110101110 101010011000 100001001101 101001110000 001100111001 100001111011 111101110001".split(" "));


    public static void main(String[] args)   {
        part1();
        part2();
    }

    private static void part1() {
        char[] gamma = new char[WORD_LENGTH] , epsilon = new char[WORD_LENGTH];
        List<String> currentNumbers = new ArrayList(Arrays.asList(DIAGNOSTIC_REPORT));
        for (int i = 0; i < WORD_LENGTH; i++) {
            Character[] binaryWord = getBinaryWordAtColumn(i,currentNumbers);
            final char frequencyChar = getHigherFrequency(binaryWord);
            gamma[i] = frequencyChar;
            epsilon[i] = frequencyChar == '0' ? '1' : '0';
        }
        Long gammaValue = Long.parseLong(new String(gamma) ,2);
        Long epsilonValue =   Long.parseLong(new String(epsilon), 2);
        System.out.println("Fuel comsumption: "+ gammaValue * epsilonValue);
    }


    private static void part2() {
        List<String> currentNumbers = new ArrayList(Arrays.asList(DIAGNOSTIC_REPORT));
        String oxygen = extractRating(currentNumbers,0, Day3::getHigherFrequency);
        String co2 = extractRating(currentNumbers,0,Day3::getLowerFrequency);
        long oxygenValue = Long.parseLong(oxygen, 2);
        long co2Value = Long.parseLong(co2, 2);

        System.out.println(co2Value * oxygenValue);
    }

    private static String extractRating(List<String> currentNumbers, int index, Function<Character[],Character> function) {

        for (int k = 0; k < currentNumbers.size(); k++) {
            Character[] binaryWord = getBinaryWordAtColumn(index,currentNumbers);
            final char frequencyChar = function.apply(binaryWord);
            List<String> filterNumbers = currentNumbers.stream().filter(s -> s.charAt(index)== frequencyChar).collect(Collectors.toList());
            if (filterNumbers.size() == 1) return filterNumbers.get(0);
            else return extractRating(filterNumbers,index + 1, function);
        }
        return null;
    }


    private static Character[] getBinaryWordAtColumn(int i,List<String> currentNumbers) {
        Character[] binaryWord = new Character[currentNumbers.size()];
        for (int k = 0; k < currentNumbers.size(); k++) {
            String binaryNumber = currentNumbers.get(k);
            binaryWord[k] = binaryNumber.charAt(i);
        }
        return binaryWord;
    }

    private static char getHigherFrequency(Character[] binaryWord) {
        Map<Character, Long> frequency = getFrequency(binaryWord);

        if (frequency.get('0') > frequency.get('1')) {
            return '0';
        } else {
            return '1';
        }
    }

    private static char getLowerFrequency(Character[] binaryWord) {
        Map<Character, Long> frequency = getFrequency(binaryWord);

        if (frequency.get('1') >= frequency.get('0')) {
            return '0';
        } else {
            return '1';
        }
    }

    private static Map<Character, Long> getFrequency(Character[] binaryWord) {
        char[] binaryWordArray = Arrays.stream(binaryWord)
                .map(ch -> ch.toString())
                .collect(Collectors.joining())
                .toCharArray();
        IntStream cStream = CharBuffer.wrap(binaryWordArray).chars();

        return cStream
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

}
