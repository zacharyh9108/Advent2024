import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day03 {
    public static void main(String[] args) {
        String fileData = getFileData("src/Data");

        System.out.println(doPartOne(fileData));
        System.out.println(doPartTwo(fileData));
    }

    public static String getFileData(String fileName) {
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            String line = "";
            while (s.hasNextLine()) {
                line += s.nextLine();
            }
            return line;
        }
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static int doPartOne(String memory) {
        int sum = 0;

        Pattern pattern = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(memory);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            sum += x * y;
        }
        return sum;
    }

    public static int doPartTwo(String memory) {
        return 0;
    }
}
