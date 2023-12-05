import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Trebuchet2 {
    public static void main(String args[]) {
        int total = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        try {
            File file = new File("D:\\Coding\\Java\\AdventOfCode\\Trebuchet.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int start = 0;
                int end = 0;
                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;
                StringBuilder sb = new StringBuilder();

                // create foundMap map - contains index and value(1-9)
                HashMap<Integer, Integer> foundMap = new HashMap<>();
                for (Entry<String, Integer> e : map.entrySet()) {
                    String key = e.getKey();
                    int i = data.indexOf(key);
                    while (i >= 0) {
                        foundMap.put(i, e.getValue());
                        i = data.indexOf(key, i + 1);
                    }
                }
                // finds min and max from foundMap
                for (Entry<Integer, Integer> e : foundMap.entrySet()) {
                    // System.out.println(e.getKey() + " " + e.getValue());
                    min = Math.min(min, e.getKey());
                    max = Math.max(max, e.getKey());

                }
                // left-right decides to use digit or convert word to digit
                char[] chars = data.toCharArray();
                for (int i = 0; i < chars.length; i++) {

                    if (Character.isDigit(chars[i]) && i <= min) {
                        sb.append(chars[i]);
                        break;
                    } else if (Character.isDigit(chars[i])) {
                        if (foundMap.containsKey(min)) {
                            sb.append(foundMap.get(min));
                            break;
                        }
                    } else {
                        continue;
                    }
                }
                // right-left
                for (int i = chars.length - 1; i >= 0; i--) {
                    System.out.println(i);
                    //
                    if (Character.isDigit(chars[i]) && i >= max) {
                        sb.append(chars[i]);
                        break;
                    } else if (Character.isDigit(chars[i])) {
                        if (foundMap.containsKey(max)) {
                            sb.append(foundMap.get(max));
                            break;
                        }
                    } else {
                        continue;
                    }

                }
                // count total value
                String value = sb.toString();
                int v = Integer.parseInt(value);
                total += v;
                System.out.println(v);
            }
            myReader.close();
            // System.out.println(total);
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
