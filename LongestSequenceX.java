import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestSequenceX {
    public static void main(String[] args) {
        String fileName = "C://Users//User//IdeaProjects//posledovatelnost//src//text.txt"; // Замените на фактический путь к файлу
        int maxLength = findLongestXSequence(fileName);
        System.out.println("Длина самой длинной последовательности X: " + maxLength);
    }

    private static int findLongestXSequence(String fileName) {
        int maxLength = 0;
        int currentLength = 0;
        boolean foundX = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int c;
            while ((c = reader.read()) != -1) {
                char ch = (char) c;
                if (ch == 'X') {
                    currentLength++;
                    foundX = true;
                } else {
                    maxLength = Math.max(maxLength, currentLength);
                    currentLength = 0;
                }
            }
            maxLength = Math.max(maxLength, currentLength);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!foundX) {
            return 0;
        }
        return maxLength;
    }
}
