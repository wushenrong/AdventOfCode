import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public final class Utilities {
    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> strings = new ArrayList<String>();
        File file = new File(fileName);
        Scanner reader = null;

        try {
            reader = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        while (reader.hasNextLine()) {
            strings.add(reader.nextLine());
        }

        reader.close();
        return strings;
    }

    public static int[] parseIntArrList(ArrayList<String> strings) {
        int[] intArrayList = new int[strings.size()];

        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).equals("")) {
                intArrayList[i] = -1;
            } else {
                intArrayList[i] = Integer.parseInt(strings.get(i));
            }
        }

        return intArrayList;
    }
}
