package day4;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Part1 {

    private static long getTotalPoints(List<String> scratchCards) {
        long totalPoints = 0;
        for (var scratchCard : scratchCards) {
            String[] currentDraw = scratchCard.split(":")[1].trim().split("\\|");
            Set<Integer> winningCards = new HashSet<>();
            for (var card : currentDraw[0].trim().split(" ")) {
                card = card.trim();
                if (!card.isEmpty()) {
                    winningCards.add(Integer.parseInt(card));
                }
            }
            int currentWinnings = 0;
            for (var seq : currentDraw[1].trim().split(" ")) {
                seq = seq.trim();
                if (!seq.isEmpty() && winningCards.contains(Integer.parseInt(seq.trim()))) {
                    currentWinnings++;
                }
            }
            totalPoints += (long)Math.pow(2, currentWinnings - 1);
        }
        return totalPoints;
    }

    public static void main(String[] args) throws IOException {
        List<String> values = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/java/advent_of_code_2023/day4/input.txt");
        System.out.println(getTotalPoints(values));
    }
}
