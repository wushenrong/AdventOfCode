package aoc;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    public static ArrayList<String> readLinesFromFile(String filename) {
        ArrayList<String> lines = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return lines;
    }
}
