package day1;

import util.ReadFileAndCreateList;

import java.io.IOException;
import java.util.List;

public class Part1 {
    private static int getCalibration(List<String> values) {
        int ans = 0;
        for (String value : values) {
            StringBuilder sb = new StringBuilder();
            int l = 0, r = value.length() - 1;
            while (l < value.length() && !Character.isDigit(value.charAt(l))) {
                l++;
            }
            sb.append(value.charAt(l));
            while (r >= 0 && !Character.isDigit(value.charAt(r))) {
                r--;
            }
            sb.append(value.charAt(r));
            ans += Integer.parseInt(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        List<String> values = ReadFileAndCreateList.readLinesFromFile(System.getProperty("user.dir") + "/advent_of_code_2023/src/day1/input_1.txt");
        System.out.println(getCalibration(values));
    }
}
