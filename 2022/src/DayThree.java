import java.util.ArrayList;

public class DayThree {
    final static int ATCharacterASCIIValue = 64;
    final static int UpperToLowerCaseValue = 32;
    final static int SpecialCharacters = 6;

    public static void main(String[] args) {
        ArrayList<String> rucksacks = Utilities.readFile("DayThree.txt");
        System.out.println("Rucksacks Priority: " + getTotalPriority(rucksacks));
        System.out.println("Elves Priority: " + getTotalGroupPriority(rucksacks));
    }

    public static int getTotalPriority(ArrayList<String> rucksacks) {
        int totalPriority = 0;

        for (String rucksack : rucksacks) {
            totalPriority += calculatePriority(getPriority(rucksack));
        }

        return totalPriority;
    }

    public static String getPriority(String rucksack) {
        int middle = rucksack.length() / 2;
        String firstCompartment = rucksack.substring(0, middle);
        String secondCompartment = rucksack.substring(middle);
        String commonItem = null;

        for (int i = 0; i < firstCompartment.length(); i++) {
            String itemOne = firstCompartment.substring(i, i + 1);

            for (int j = 0; j < secondCompartment.length(); j++) {
                String itemTwo = secondCompartment.substring(j, j + 1);

                if (itemOne.equals(itemTwo)) {
                    commonItem = itemOne;
                }
            }
        }

        return commonItem;
    }

    public static int getTotalGroupPriority(ArrayList<String> rucksacks) {
        int totalGroupPriority = 0;

        for (int i = 0; i < rucksacks.size(); i += 3) {
            totalGroupPriority += calculatePriority(
                    getGroupPriority(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2)));
        }

        return totalGroupPriority;
    }

    public static String getGroupPriority(String firstRuck, String secondRuckSack, String thirdRuckSack) {
        String commonItem = null;

        for (int i = 0; i < firstRuck.length(); i++) {
            String itemOne = firstRuck.substring(i, i + 1);

            for (int j = 0; j < secondRuckSack.length(); j++) {
                String itemTwo = secondRuckSack.substring(j, j + 1);

                for (int k = 0; k < thirdRuckSack.length(); k++) {
                    String itemThree = thirdRuckSack.substring(k, k + 1);

                    if (itemOne.equals(itemTwo) && itemOne.equals(itemThree)) {
                        commonItem = itemOne;
                    }
                }
            }
        }

        return commonItem;
    }

    public static int calculatePriority(String character) {
        int priority = character.charAt(0);

        priority -= ATCharacterASCIIValue;
        priority -= UpperToLowerCaseValue;

        if (priority < 0) {
            priority += ATCharacterASCIIValue - SpecialCharacters;
        }

        return priority;
    }
}
