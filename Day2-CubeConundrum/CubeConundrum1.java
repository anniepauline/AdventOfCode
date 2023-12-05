//package Day2-CubeConundrum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeConundrum1 {
    public static void main(String args[]) {
        int val = 0;
        try {
            Pattern pattern = Pattern.compile("(\\d+) (\\w+)");
            File file = new File("D:\\Coding\\Java\\AdventOfCode\\Day2-CubeConundrum\\CubeConundrum.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] arr = data.split(":");
                int gameNo = Integer.parseInt(arr[0].replace("Game", "").trim());

                int red = 0;
                int blue = 0;
                int green = 0;

                for (String rounds : arr[1].split(";")) {
                    for (String cubes : rounds.split(",")) {
                        Matcher m = pattern.matcher(cubes);
                        // no.ofBalls color
                        // 12 red cubes,
                        // 13 green cubes
                        // 14 blue
                        if (m.find()) {
                            switch (m.group(2)) {
                                case "red":
                                    int newred = Integer.parseInt(m.group(1));
                                    if (newred > red) {
                                        red = newred;
                                    }

                                    break;
                                case "blue":
                                    int newblue = Integer.parseInt(m.group(1));
                                    if (newblue > blue) {
                                        blue = newblue;
                                    }

                                    break;
                                case "green":
                                    int newgreen = Integer.parseInt(m.group(1));
                                    if (newgreen > green) {
                                        green = newgreen;
                                    }

                                    break;
                            }
                        }
                    }
                }

                if (red <= 12 && green <= 13 && blue <= 14) {
                    System.out.println(gameNo);
                    val += gameNo;
                }
            }
            System.out.println(val);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
