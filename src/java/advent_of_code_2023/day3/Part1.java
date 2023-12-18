package day3;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.List;

public class Part1 {

    private static long getTotalPartNumbers(char[][] parts) {
        boolean[][] visited = new boolean[parts.length][parts[0].length];
        long ans = 0;
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[0].length; j++) {
                if ((j == 0 || !Character.isDigit(parts[i][j - 1])) && isPart(visited, parts, i, j)) {
                    StringBuilder sb = new StringBuilder();
                    int len = j;
                    while (len < parts[i].length && Character.isDigit(parts[i][len])) {
                        sb.append(parts[i][len++]);
                    }
                    if (!sb.isEmpty()) {
                        ans += Integer.parseInt(sb.toString());
                    }
                }
            }
        }
        return ans;
    }

    private static final int[][] DIRECTIONS = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    private static boolean isPart(boolean[][] visited, char[][] parts, int i, int j) {
        if (i < 0 || j < 0 || i >= parts.length || j >= parts[i].length || visited[i][j] || parts[i][j] == '.') {
            return false;
        }

        if (!Character.isDigit(parts[i][j])) {
            return true;
        }

        visited[i][j] = true;
        for (var dir : DIRECTIONS) {
            int x = i + dir[0], y = j + dir[1];
            if (isPart(visited, parts, x, y)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        List<String> values = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/java/advent_of_code_2023/day3/input.txt");
        char[][] input = new char[values.size()][];
        for (int i = 0; i < values.size(); i++) {
            input[i] = values.get(i).trim().toCharArray();
        }

        System.out.println(getTotalPartNumbers(input));
    }
}
