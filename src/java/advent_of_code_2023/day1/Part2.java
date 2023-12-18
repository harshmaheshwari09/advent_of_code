package day1;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Part2 {

    private static final Map<String, String> NUMBERS_MAP = Map.of(
            "one", "1",
            "two", "2",
            "three", "3",
            "four", "4",
            "five", "5",
            "six", "6",
            "seven", "7",
            "eight", "8",
            "nine", "9"
    );

    private static int getCalibration(List<String> values) {
        int ans = 0;
        for (String value : values) {
            StringBuilder sb = new StringBuilder();

            // left to right
            int l = 0;
            leftToRightLoop:
            while (l < value.length()) {
                if (Character.isDigit(value.charAt(l))) {
                    sb.append(value.charAt(l));
                    break;
                } else {
                    for (int i = 3; i <= 5 && l + i <= value.length(); i++) {
                        String curr = value.substring(l, l + i);
                        if (NUMBERS_MAP.containsKey(curr)) {
                            sb.append(NUMBERS_MAP.get(curr));
                            break leftToRightLoop;
                        }
                    }
                }
                l++;
            }

            // right to left
            int r = value.length() - 1;
            rightToLeftLoop:
            while (r >= 0) {
                if (Character.isDigit(value.charAt(r))) {
                    sb.append(value.charAt(r));
                    break ;
                } else {
                    for (int i = 3; i <= 5 && r + i <= value.length(); i++) {
                        String curr = value.substring(r, r + i);
                        if (NUMBERS_MAP.containsKey(curr)) {
                            sb.append(NUMBERS_MAP.get(curr));
                            break rightToLeftLoop;
                        }
                    }
                }
                r--;
            }

            ans += Integer.parseInt(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<String> values = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/src/java/advent_of_code_2023/day1/input_1.txt");
        System.out.println(getCalibration(values));
    }
}
