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

    private static boolean isInBounds(String[][] fileData, int r, int c) {
        return r >= 0 && r < fileData.length && fileData[r] != null && c >= 0 && c < fileData[r].length && fileData[r][c] != null;
    }

    public static int doPartOne(String[][] fileData) {
        int count = 0;

        for (int r = 0; r < fileData.length; r++) {
            for (int c = 0; c < fileData[r].length; c++) {
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r, c + 1) && fileData[r][c + 1].equals("M") &&
                        isInBounds(fileData, r, c + 2) && fileData[r][c + 2].equals("A") &&
                        isInBounds(fileData, r, c + 3) && fileData[r][c + 3].equals("S")) {
                    count++;
                }

                // Horizontal left
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r, c - 1) && fileData[r][c - 1].equals("M") &&
                        isInBounds(fileData, r, c - 2) && fileData[r][c - 2].equals("A") &&
                        isInBounds(fileData, r, c - 3) && fileData[r][c - 3].equals("S")) {
                    count++;
                }

                // Vertical down
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r + 1, c) && fileData[r + 1][c].equals("M") &&
                        isInBounds(fileData, r + 2, c) && fileData[r + 2][c].equals("A") &&
                        isInBounds(fileData, r + 3, c) && fileData[r + 3][c].equals("S")) {
                    count++;
                }

                // Vertical up
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r - 1, c) && fileData[r - 1][c].equals("M") &&
                        isInBounds(fileData, r - 2, c) && fileData[r - 2][c].equals("A") &&
                        isInBounds(fileData, r - 3, c) && fileData[r - 3][c].equals("S")) {
                    count++;
                }

                // Diagonal down right
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r + 1, c + 1) && fileData[r + 1][c + 1].equals("M") &&
                        isInBounds(fileData, r + 2, c + 2) && fileData[r + 2][c + 2].equals("A") &&
                        isInBounds(fileData, r + 3, c + 3) && fileData[r + 3][c + 3].equals("S")) {
                    count++;
                }

                // Diagonal up left
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r - 1, c - 1) && fileData[r - 1][c - 1].equals("M") &&
                        isInBounds(fileData, r - 2, c - 2) && fileData[r - 2][c - 2].equals("A") &&
                        isInBounds(fileData, r - 3, c - 3) && fileData[r - 3][c - 3].equals("S")) {
                    count++;
                }

                // Diagonal down left
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r + 1, c - 1) && fileData[r + 1][c - 1].equals("M") &&
                        isInBounds(fileData, r + 2, c - 2) && fileData[r + 2][c - 2].equals("A") &&
                        isInBounds(fileData, r + 3, c - 3) && fileData[r + 3][c - 3].equals("S")) {
                    count++;
                }

                // Diagonal up right
                if (fileData[r][c].equals("X") &&
                        isInBounds(fileData, r - 1, c + 1) && fileData[r - 1][c + 1].equals("M") &&
                        isInBounds(fileData, r - 2, c + 2) && fileData[r - 2][c + 2].equals("A") &&
                        isInBounds(fileData, r - 3, c + 3) && fileData[r - 3][c + 3].equals("S")) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int doPartTwo(String[][] fileData) {
        int count = 0;

        for (int r = 1; r < fileData.length - 1; r++) {
            for (int c = 1; c < fileData[r].length - 1; c++) {
                if (!fileData[r][c].equals("A")) {
                    continue;
                }

                if (isInBounds(fileData, r - 1, c - 1) && isInBounds(fileData, r + 1, c + 1) &&
                        isInBounds(fileData, r - 1, c + 1) && isInBounds(fileData, r + 1, c - 1)) {

                    String tl = fileData[r - 1][c - 1];
                    String br = fileData[r + 1][c + 1];
                    String tr = fileData[r - 1][c + 1];
                    String bl = fileData[r + 1][c - 1];

                    boolean diag1 = (tl.equals("M") && br.equals("S")) || (tl.equals("S") && br.equals("M"));
                    boolean diag2 = (tr.equals("M") && bl.equals("S")) || (tr.equals("S") && bl.equals("M"));

                    if (diag1 && diag2) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
