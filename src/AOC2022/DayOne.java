package AOC2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<Integer> calories = readCaloriesFromFile("2022DayOne.txt");
        ArrayList<Integer> caloriesCount = countCalories(calories);

        Collections.sort(caloriesCount);
        Collections.reverse(caloriesCount);

        int topThreeCalories = 0;

        System.out.println("Top Three Calories");
        for (int i = 0; i < 3; i++) {
            int calorieCount = caloriesCount.get(i);
            System.out.println(calorieCount);
            topThreeCalories += calorieCount;
        }

        System.out.println("Total Top Calories: " + topThreeCalories);
    }

    public static ArrayList<Integer> countCalories(ArrayList<Integer> calories) {
        ArrayList<Integer> counts = new ArrayList<>();

        int totalCalories = 0;
        for (Integer calorie : calories) {
            if (calorie != -1) {
                totalCalories += calorie;
            } else {
                counts.add(totalCalories);
                totalCalories = 0;
            }
        }

        return counts;
    }

    public static ArrayList<Integer> readCaloriesFromFile(String filename) {
        ArrayList<Integer> calories = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                int calorie = -1;
                if (!line.equals("")) {
                    calorie = Integer.parseInt(line);
                }

                calories.add(calorie);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return calories;
    }
}
