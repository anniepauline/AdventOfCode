import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebuchet1 {
    public static void main(String args[]) {
        int total = 0;
        try {
            File file = new File("D:\\Coding\\Java\\AdventOfCode\\Trebuchet.txt");
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                StringBuilder num = new StringBuilder();
                // System.out.println(data);

                char[] chars = data.toCharArray();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {

                    if (Character.isDigit(chars[i])) {
                        sb.append(chars[i]);
                        break;
                    }

                }
                for (int i = chars.length - 1; i >= 0; i--) {
                    //
                    if (Character.isDigit(chars[i])) {
                        sb.append(chars[i]);
                        break;
                    }
                }
                String value = sb.toString();
                int v = Integer.parseInt(value);
                total += v;

            }
            myReader.close();
            System.out.println(total);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
