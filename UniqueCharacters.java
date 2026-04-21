import java.util.Scanner;

public class UniqueCharacters {

    // Method to find length without using length()
    public static int findLength(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count++;
        }
        return count;
    }

    // Method to find unique characters
    public static char[] getUniqueChars(String str) {
        int len = findLength(str);
        char[] temp = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            // Check previous characters
            for (int j = 0; j < i; j++) {
                if (current == str.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                temp[index++] = current;
            }
        }

        // Create exact size array
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    // Display method
    public static void display(char[] arr) {
        System.out.println("Unique Characters:");
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = sc.nextLine();

        char[] unique = getUniqueChars(input);
        display(unique);

        sc.close();
    }
}