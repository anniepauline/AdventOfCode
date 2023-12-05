import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CubeConundrum2 {
    public static int gamesPart2(String s) {
        int power = 1;

        // boolean idAdded = false;
        int id = Integer.parseInt(s.substring(5, s.indexOf(':')));
        String[] turns = s.substring(s.indexOf(":") + 1).split(";");
        Map<String, Integer> map = new HashMap<>();

        for (String t1 : turns) {

            String[] t2 = t1.split(",");
            for (String c : t2) {
                String[] c1 = c.trim().split(" ");
                int num = Integer.parseInt(c1[0]);
                String color = c1[1];

                if (map.containsKey(color)) {
                    map.put(color, Math.max(num, map.get(color)));
                } else {
                    map.put(color, num);
                }

            }

        }
        for (int i : map.values()) {
            // System.out.println(i);
            power *= i;
        }

        return power;
    }

    public static void main(String[] args) {
        int output = 0;
        try {
            File file = new File("D:\\Coding\\Java\\AdventOfCode\\Day2-CubeConundrum\\CubeConundrum.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                output += gamesPart2(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(output);
    }
}
