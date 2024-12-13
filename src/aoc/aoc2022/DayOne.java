package aoc.aoc2022;

import java.util.ArrayList;
import java.util.Collections;

import aoc.Utilities;

public class DayOne {
    public static final int NUM_OF_ELVES_TO_GET = 3;

    public static void main(String[] args) {
        ArrayList<String> calories = Utilities.readLinesFromFile("2022DayOne.txt");
        ArrayList<Integer> caloriesCount = countCalories(calories);

        Collections.sort(caloriesCount);
        Collections.reverse(caloriesCount);

        int topThreeCalories = 0;

        System.out.println("Top Three Calories");
        for (int i = 0; i < NUM_OF_ELVES_TO_GET; i++) {
            int calorieCount = caloriesCount.get(i);
            System.out.println(calorieCount);
            topThreeCalories += calorieCount;
        }

        System.out.println("Total Top Calories: " + topThreeCalories);
    }

    public static ArrayList<Integer> countCalories(ArrayList<String> calories) {
        ArrayList<Integer> counts = new ArrayList<>();

        int totalCalories = 0;
        for (String calorie : calories) {
            if (calorie.equals("")) {
                counts.add(totalCalories);
                totalCalories = 0;
            } else {
                totalCalories += Integer.parseInt(calorie);
            }
        }

        return counts;
    }
}
