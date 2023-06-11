import java.util.ArrayList;

public class DayOne {
    public static void main(String[] args) throws Exception {
        ArrayList<String> calories = Utilities.readFile("DayOne.txt");
        int[] caloriesInt = Utilities.parseIntArrList(calories);
        ArrayList<Integer> caloriesCount = getCountCalories(caloriesInt);
        int[] maxCalories = getThreeMaxCalories(caloriesCount);

        System.out.println("Top Three Calories");
        int topThree = 0;
        for (int i : maxCalories) {
            System.out.println(i);
            topThree += i;
        }
        System.out.println("Total Top Calories: " + topThree);
    }

    public static ArrayList<Integer> getCountCalories(int[] calories) {
        ArrayList<Integer> counts = new ArrayList<Integer>();

        int total = 0;
        for (Integer integer : calories) {
            if (integer == -1) {
                counts.add(total);
                total = 0;
            } else {
                total += integer;
            }
        }

        return counts;
    }

    public static int[] getThreeMaxCalories(ArrayList<Integer> calories) {
        int[] maxes = new int[3];
        maxes[0] = calories.get(0);
        maxes[1] = calories.get(0);
        maxes[2] = calories.get(0);

        int index = 0;
        for (int i = 0; i < maxes.length; i++) {
            for (int j = 0; j < calories.size(); j++) {
                if (calories.get(j) > maxes[i]) {
                    maxes[i] = calories.get(j);
                    index = j;
                }
            }
            calories.set(index, 0);
        }

        return maxes;
    }
}
