package aoc.aoc2015;

import java.io.File;
import java.util.Scanner;

public class DayOne {
    private static final char GO_UP = '(';
    private static final char GO_DOWN = ')';

    public static void main(String[] args) {
        String instructions = null;

        try (Scanner fileScanner = new Scanner(new File("2015DayOne.txt"))) {
            instructions = fileScanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("Go to floor: " + calculateFloor(instructions));
        System.out.println("Position to basement: " + calculatePositionToBasement(instructions));
    }

    public static int calculateFloor(String instructions) {
        int floor = 0;

        for (int i = 0; i < instructions.length(); i++) {
            floor += goUpOrDown(instructions.charAt(i));
        }

        return floor;
    }

    public static int calculatePositionToBasement(String instructions) {
        int floor = 0;

        for (int i = 0; i < instructions.length(); i++) {
            if (floor < 0) {
                return i;
            }
            floor += goUpOrDown(instructions.charAt(i));
        }

        return -1;
    }

    public static int goUpOrDown(char instruction) {
        switch (instruction) {
        case GO_UP:
            return 1;
        case GO_DOWN:
            return -1;
        default:
            return 0;
        }
    }
}
