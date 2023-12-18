package day2;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static long getPowerSum(List<String> games) {
        long totalPower = 0;
        for (String game : games) {
            Map<String, Integer> cubeCount = new HashMap<>(Map.of(
                    "red", 0,
                    "blue", 0,
                    "green", 0));
            for (String set : game.trim().split(":")[1].trim().split(";")) {
                for (String turn : set.trim().split(",")) {
                    String[] cubeValues = turn.trim().split(" ");
                    cubeCount.put(cubeValues[1].trim(), Math.max(cubeCount.get(cubeValues[1].trim()), Integer.parseInt(cubeValues[0].trim())));
                }
            }
            long currentPower = 1;
            for (int power : cubeCount.values()) {
                currentPower *= power;
            }
            totalPower += currentPower;
        }
        return totalPower;
    }

    public static void main(String[] args) throws IOException {
        List<String> games = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/java/advent_of_code_2023/day2/input.txt");
        System.out.println(getPowerSum(games));
    }
}
