package day2;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Part1 {

    private final static Map<String, Integer> CUBE_COUNT = Map.of(
            "red", 12,
            "green", 13,
            "blue", 14
    );

    private static int getTotal(List<String> games) {
        int ans = 0;
        game:
        for (String game : games) {
            String[] idSet = game.trim().split(":");
            for (String set : idSet[1].trim().split(";")) {
                for (String turn : set.trim().split(",")) {
                    String[] cubeValue = turn.trim().split(" ");
                    if (Integer.parseInt(cubeValue[0].trim()) > CUBE_COUNT.get(cubeValue[1].trim())) {
                        continue game;
                    }
                }
            }
            ans += Integer.parseInt(idSet[0].trim().split(" ")[1].trim());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<String> games = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/day2/input.txt");
        System.out.println(getTotal(games));
    }
}
