package day3;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.List;

public class Part2 {

    private static long getTotalGearRatio(char[][] parts) {
        long ans = 0;
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts[i].length; j++) {
                if (parts[i][j] == '*') {
                    ans += getCurrentRation(parts, i, j);
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

    private static long getCurrentRation(char[][] parts, int i, int j) {
        long[] ratio = new long[2];
        int idx = 0;
        for (var dir : DIRECTIONS) {
            if (idx == 2) {
                break;
            }
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || y < 0 || x >= parts.length || y >= parts[x].length || !Character.isDigit(parts[x][y])) {
                continue;
            }
            while (y > 0 && Character.isDigit(parts[x][y - 1])) {
                y--;
            }
            StringBuilder sb = new StringBuilder();
            while (y < parts[x].length && Character.isDigit(parts[x][y])) {
                sb.append(parts[x][y]);
                parts[x][y++] = '.';
            }
            ratio[idx++] = Integer.parseInt(sb.toString());
        }
        return ratio[0] * ratio[1];
    }

    public static void main(String[] args) throws IOException {
        List<String> values = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/java/advent_of_code_2023/day3/input.txt");
        char[][] input = new char[values.size()][];
        for (int i = 0; i < values.size(); i++) {
            input[i] = values.get(i).trim().toCharArray();
        }

        System.out.println(getTotalGearRatio(input));
    }
}
