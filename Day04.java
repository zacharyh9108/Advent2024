import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day04 {
    public static void main(String[] args) {
        String[][] fileData = getFileData("src/Data");

        System.out.println(doPartOne(fileData));
        System.out.println(doPartTwo(fileData));
    }

    public static String[][] getFileData(String fileName) {
        String[][] fileData = new String[140][];
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            int i = 0;
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] arr = new String[line.length()];
                for (int j = 0; j < line.length(); j++) {
                    arr[j] = String.valueOf(line.charAt(j));
                }
                fileData[i] = arr;
                i++;
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }

    public static int doPartOne(String[][] fileData) {
        int count = 0;

        for (int r = 0; r < fileData.length; r++) {
            for (int c = 0; c < fileData[r].length; c++) {
                // Horizontal right
                if (c + 3 < fileData[r].length &&
                        fileData[r][c].equals("X") &&
                        fileData[r][c + 1].equals("M") &&
                        fileData[r][c + 2].equals("A") &&
                        fileData[r][c + 3].equals("S")) {
                    count++;
                }

                // Horizontal left
                if (c - 3 >= 0 &&
                        fileData[r][c].equals("X") &&
                        fileData[r][c - 1].equals("M") &&
                        fileData[r][c - 2].equals("A") &&
                        fileData[r][c - 3].equals("S")) {
                    count++;
                }

                // Vertical down
                if (r + 3 < fileData.length &&
                        fileData[r + 1] != null && fileData[r + 2] != null && fileData[r + 3] != null &&
                        fileData[r][c].equals("X") &&
                        c < fileData[r + 1].length && fileData[r + 1][c].equals("M") &&
                        c < fileData[r + 2].length && fileData[r + 2][c].equals("A") &&
                        c < fileData[r + 3].length && fileData[r + 3][c].equals("S")) {
                    count++;
                }

                // Vertical up
                if (r - 3 >= 0 &&
                        fileData[r - 1] != null && fileData[r - 2] != null && fileData[r - 3] != null &&
                        fileData[r][c].equals("X") &&
                        c < fileData[r - 1].length && fileData[r - 1][c].equals("M") &&
                        c < fileData[r - 2].length && fileData[r - 2][c].equals("A") &&
                        c < fileData[r - 3].length && fileData[r - 3][c].equals("S")) {
                    count++;
                }

                // Diagonal down right
                if (r + 3 < fileData.length && c + 3 < fileData[r].length &&
                        fileData[r + 1] != null && fileData[r + 2] != null && fileData[r + 3] != null &&
                        c + 1 < fileData[r + 1].length &&
                        c + 2 < fileData[r + 2].length &&
                        c + 3 < fileData[r + 3].length &&
                        fileData[r][c].equals("X") &&
                        fileData[r + 1][c + 1].equals("M") &&
                        fileData[r + 2][c + 2].equals("A") &&
                        fileData[r + 3][c + 3].equals("S")) {
                    count++;
                }

                // Diagonal up left
                if (r - 3 >= 0 && c - 3 >= 0 &&
                        fileData[r - 1] != null && fileData[r - 2] != null && fileData[r - 3] != null &&
                        c - 1 < fileData[r - 1].length &&
                        c - 2 < fileData[r - 2].length &&
                        c - 3 < fileData[r - 3].length &&
                        fileData[r][c].equals("X") &&
                        fileData[r - 1][c - 1].equals("M") &&
                        fileData[r - 2][c - 2].equals("A") &&
                        fileData[r - 3][c - 3].equals("S")) {
                    count++;
                }

                // Diagonal down left
                if (r + 3 < fileData.length && c - 3 >= 0 &&
                        fileData[r + 1] != null && fileData[r + 2] != null && fileData[r + 3] != null &&
                        c - 1 < fileData[r + 1].length &&
                        c - 2 < fileData[r + 2].length &&
                        c - 3 < fileData[r + 3].length &&
                        fileData[r][c].equals("X") &&
                        fileData[r + 1][c - 1].equals("M") &&
                        fileData[r + 2][c - 2].equals("A") &&
                        fileData[r + 3][c - 3].equals("S")) {
                    count++;
                }

                // Diagonal up right
                if (r - 3 >= 0 && c + 3 < fileData[r].length &&
                        fileData[r - 1] != null && fileData[r - 2] != null && fileData[r - 3] != null &&
                        c + 1 < fileData[r - 1].length &&
                        c + 2 < fileData[r - 2].length &&
                        c + 3 < fileData[r - 3].length &&
                        fileData[r][c].equals("X") &&
                        fileData[r - 1][c + 1].equals("M") &&
                        fileData[r - 2][c + 2].equals("A") &&
                        fileData[r - 3][c + 3].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int doPartTwo(String[][] fileData) {
        int count = 0;

        return count;
    }
}
