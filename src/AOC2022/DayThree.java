package AOC2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayThree {
    public final static int ATCharacterASCIIValue = 64;
    public final static int UpperToLowerCaseValue = 32;
    public final static int SpecialCharacters = 6;

    public static void main(String[] args) {
        ArrayList<String> rucksacks = readRucksacksFromFile("2022DayThree.txt");
        System.out.println("Rucksacks Priority: " + calculateTotalPriority(rucksacks));
        System.out.println("Group Priority: " + calculateTotalGroupPriority(rucksacks));
    }

    public static int calculateTotalPriority(ArrayList<String> rucksacks) {
        int totalPriority = 0;

        for (String rucksack : rucksacks) {
            totalPriority += calculatePriority(getDuplicateItem(rucksack));
        }

        return totalPriority;
    }

    public static int calculateTotalGroupPriority(ArrayList<String> rucksacks) {
        int totalGroupPriority = 0;

        for (int i = 0; i < rucksacks.size(); i += 3) {
            totalGroupPriority += calculatePriority(getGroupBadge(rucksacks, i));
        }

        return totalGroupPriority;
    }

    public static char getGroupBadge(ArrayList<String> rucksacks, int index) {
        String rucksackOne = rucksacks.get(index);
        String rucksackTwo = rucksacks.get(index + 1);
        String rucksackThree = rucksacks.get(index + 2);

        for (int i = 0; i < rucksackOne.length(); i++) {
            char item = rucksackOne.charAt(i);

            int foundInTwo = rucksackTwo.indexOf(item);
            int foundInThree = rucksackThree.indexOf(item);

            if (foundInTwo != -1 && foundInThree != -1) {
                return item;
            }
        }

        return '\0';
    }

    public static char getDuplicateItem(String rucksack) {
        int middle = rucksack.length() / 2;
        String lowerCompartment = rucksack.substring(0, middle);
        String upperCompartment = rucksack.substring(middle);

        for (int i = 0; i < lowerCompartment.length(); i++) {
            char item = lowerCompartment.charAt(i);
            int found = upperCompartment.indexOf(item);

            if (found != -1) {
                return item;
            }
        }

        return '\0';
    }

    public static int calculatePriority(char character) {
        int priority = character - ATCharacterASCIIValue - UpperToLowerCaseValue;

        if (priority < 0) {
            priority += ATCharacterASCIIValue - SpecialCharacters;
        }

        return priority;
    }

    public static ArrayList<String> readRucksacksFromFile(String filename) {
        ArrayList<String> rucksacks = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                rucksacks.add(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return rucksacks;
    }
}
