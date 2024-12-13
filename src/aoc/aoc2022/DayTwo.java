package aoc.aoc2022;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayTwo {
    private static final int SCORE_FOR_WINNING = 6;
    public static final int SCORE_FOR_PLAYING_SCISSORS = 3;
    public static final int SCORE_FOR_DRAW = 3;

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
            default:
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
                score += SCORE_FOR_PLAYING_SCISSORS;
                homeScissors = true;
                break;
            default:
                break;
            }

            if ((homeRock && opponentRock) || (homePaper && opponentPaper) || (homeScissors && opponentScissors)) {
                score += SCORE_FOR_DRAW;
            } else if ((homeRock && opponentScissors) || (homePaper && opponentRock)
                    || (homeScissors && opponentPaper)) {
                score += SCORE_FOR_WINNING;
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
            default:
                break;
            }

            switch (home) {
            case "X":
                if (opponentRock) {
                    homeScissors = true;
                    score += SCORE_FOR_PLAYING_SCISSORS;
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
                    score += SCORE_FOR_PLAYING_SCISSORS;
                }
                break;

            case "Z":
                if (opponentRock) {
                    homePaper = true;
                    score += 2;
                } else if (opponentPaper) {
                    homeScissors = true;
                    score += SCORE_FOR_PLAYING_SCISSORS;
                } else if (opponentScissors) {
                    homeRock = true;
                    score += 1;
                }
                break;
            default:
                break;
            }

            if ((homeRock && opponentRock) || (homePaper && opponentPaper) || (homeScissors && opponentScissors)) {
                score += SCORE_FOR_DRAW;
            } else if ((homeRock && opponentScissors) || (homePaper && opponentRock)
                    || (homeScissors && opponentPaper)) {
                score += SCORE_FOR_WINNING;
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
