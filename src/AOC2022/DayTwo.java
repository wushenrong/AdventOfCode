package AOC2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    public static void main(String[] args) {
        ArrayList<String> strategy = readStrategyFromFile("2022DayTwo.txt");
        System.out.println("Basic Strategy: " + calculateBasicStrategy(strategy));
        System.out.println("Advance Strategy: " + calculateAdvanceStrategy(strategy));
    }

    public static int calculateBasicStrategy(ArrayList<String> strategy) {
        int totalScore = 0;

        for (String round : strategy) {
            String opponent = round.substring(0, 1);
            String home = round.substring(2);
            int score = 0;

            boolean opponentRock = false;
            boolean opponentPaper = false;
            boolean opponentScissors = false;
            boolean homeRock = false;
            boolean homePaper = false;
            boolean homeScissors = false;

            switch (opponent) {
            case "A":
                opponentRock = true;
                break;

            case "B":
                opponentPaper = true;
                break;

            case "C":
                opponentScissors = true;
                break;
            }

            switch (home) {
            case "X":
                score += 1;
                homeRock = true;
                break;

            case "Y":
                score += 2;
                homePaper = true;
                break;

            case "Z":
                score += 3;
                homeScissors = true;
                break;
            }

            if ((homeRock && opponentRock) || (homePaper && opponentPaper) || (homeScissors && opponentScissors)) {
                score += 3;
            } else if ((homeRock && opponentScissors) || (homePaper && opponentRock)
                    || (homeScissors && opponentPaper)) {
                score += 6;
            }

            totalScore += score;
        }

        return totalScore;
    }

    public static int calculateAdvanceStrategy(ArrayList<String> strategy) {
        int totalScore = 0;

        for (String round : strategy) {
            String opponent = round.substring(0, 1);
            String home = round.substring(2);
            int score = 0;

            boolean opponentRock = false;
            boolean opponentPaper = false;
            boolean opponentScissors = false;
            boolean homeRock = false;
            boolean homePaper = false;
            boolean homeScissors = false;

            switch (opponent) {
            case "A":
                opponentRock = true;
                break;

            case "B":
                opponentPaper = true;
                break;

            case "C":
                opponentScissors = true;
                break;
            }

            switch (home) {
            case "X":
                if (opponentRock) {
                    homeScissors = true;
                    score += 3;
                } else if (opponentPaper) {
                    homeRock = true;
                    score += 1;
                } else if (opponentScissors) {
                    homePaper = true;
                    score += 2;
                }
                break;

            case "Y":
                if (opponentRock) {
                    homeRock = true;
                    score += 1;
                } else if (opponentPaper) {
                    homePaper = true;
                    score += 2;
                } else if (opponentScissors) {
                    homeScissors = true;
                    score += 3;
                }
                break;

            case "Z":
                if (opponentRock) {
                    homePaper = true;
                    score += 2;
                } else if (opponentPaper) {
                    homeScissors = true;
                    score += 3;
                } else if (opponentScissors) {
                    homeRock = true;
                    score += 1;
                }
                break;
            }

            if ((homeRock && opponentRock) || (homePaper && opponentPaper) || (homeScissors && opponentScissors)) {
                score += 3;
            } else if ((homeRock && opponentScissors) || (homePaper && opponentRock)
                    || (homeScissors && opponentPaper)) {
                score += 6;
            }

            totalScore += score;
        }

        return totalScore;
    }

    public static ArrayList<String> readStrategyFromFile(String filename) {
        ArrayList<String> strategy = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNextLine()) {
                strategy.add(fileScanner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        return strategy;
    }
}
