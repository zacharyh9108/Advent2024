import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        String[][] fileData = getFileData("src/Data");
        int[][] intArr = parseFileData(fileData);

        System.out.println(doPartOne(intArr));
        System.out.println(doPartTwo(intArr));
    }

    public static String[][] getFileData(String fileName) {
        String[][] fileData = new String[1000][];
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] arr = line.split(" ");
                fileData[i] = arr;
                i++;
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int[][] parseFileData(String[][] fileData) {
        int[][] intArr = new int[fileData.length][];
        for (int r = 0; r < fileData.length; r++) {
            int[] arr = new int[fileData[r].length];
            for (int c = 0; c < fileData[r].length; c++) {
                arr[c] = Integer.parseInt(fileData[r][c]);
            }
            intArr[r] = arr;
        }
        return intArr;
    }

    public static boolean isValid(int[] arr) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            int absDiff = Math.abs(diff);

            if (absDiff < 1 || absDiff > 3) {
                return false;
            }

            if (diff <= 0) {
                isIncreasing = false;
            }
            if (diff >= 0) {
                isDecreasing = false;
            }
        }
        return isIncreasing || isDecreasing;
    }

    public static int[] removeElement(int[] arr, int indexToRemove) {
        int[] result = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != indexToRemove) {
                result[j] = arr[i];
                j++;
            }
        }
        return result;
    }

    public static int doPartOne(int[][] fileData) {
        int count = 0;
        for (int r = 0; r < fileData.length; r++) {
            if (isValid(fileData[r])) {
                count++;
            }
        }
        return count;
    }

    public static int doPartTwo(int[][] fileData) {
        int count = 0;
        for (int[] r : fileData) {
            if (isValid(r)) {
                count++;
            } else {
                boolean foundValid = false;
                for (int i = 0; i < r.length; i++) {
                    int[] newArr = removeElement(r, i);
                    if (isValid(newArr)) {
                        foundValid = true;
                        break;
                    }
                }
                if (foundValid) {
                    count++;
                }
            }
        }
        return count;
    }
}
