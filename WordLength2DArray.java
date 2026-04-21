import java.util.Scanner;

public class WordLength2DArray {

    // Method to split text into words without using split()
    public static String[] splitWords(String text) {
        int n = text.length();
        String[] temp = new String[n]; // temporary array
        int wordCount = 0;
        String word = "";

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    temp[wordCount++] = word;
                    word = "";
                }
            }
        }

        // Add last word
        if (!word.equals("")) {
            temp[wordCount++] = word;
        }

        // Create exact-sized array
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            words[i] = temp[i];
        }

        return words;
    }

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // Method to create 2D array of word and length
    public static String[][] create2DArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    // Display in tabular format
    public static void display(String[][] arr) {
        System.out.println("Word\tLength");
        System.out.println("----------------");

        for (int i = 0; i < arr.length; i++) {
            int length = Integer.parseInt(arr[i][1]); // convert back to int
            System.out.println(arr[i][0] + "\t" + length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] result = create2DArray(words);

        display(result);

        sc.close();
    }
}