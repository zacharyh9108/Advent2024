import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        ArrayList<Integer> leftList = getFileDataLeftList("src/Lists");
        ArrayList<Integer> rightList = getFileDataRightList("src/Lists");

        System.out.println(partOne(leftList, rightList));
        System.out.println(partTwo(leftList, rightList));
    }

    public static ArrayList<Integer> getFileDataLeftList(String fileName) {
        ArrayList<Integer> fileData = new ArrayList<>();
        try
        {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine())
            {
                String line = s.nextLine();
                line = line.substring(0, line.indexOf(" "));
                int n = Integer.parseInt(line);
                if (!line.isEmpty())
                {
                    fileData.add(n);
                }
            }
            return fileData;
        }
        catch (FileNotFoundException e)
        {
            return fileData;
        }
    }

    public static ArrayList<Integer> getFileDataRightList(String fileName) {
        ArrayList<Integer> fileData = new ArrayList<>();
        try
        {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine())
            {
                String line = s.nextLine();
                line = line.substring(line.indexOf("   ") + 3);
                int n = Integer.parseInt(line);
                if (!line.isEmpty())
                {
                    fileData.add(n);
                }
            }
            return fileData;
        }
        catch (FileNotFoundException e)
        {
            return fileData;
        }
    }

    public static int partOne(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        Collections.sort(leftList);
        Collections.sort(rightList);
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            ans += Math.abs(rightList.get(i) - leftList.get(i));
        }
        return ans;
    }

    public static int partTwo(ArrayList<Integer> leftList, ArrayList<Integer> rightList) {
        int ans = 0;
        for (int numLeft = 0; numLeft < leftList.size(); numLeft++) {
            int x = 0;
            for (int numRight = 0; numRight < rightList.size(); numRight++) {
                if (rightList.get(numRight).equals(leftList.get(numLeft))) {
                    x++;
                }
            }
            ans = ans + leftList.get(numLeft) * x;
        }
        return ans;
    }
}
