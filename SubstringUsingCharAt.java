import java.util.Scanner;

public class SubstringUsingCharAt {

    static String createSubstring(String str, int start, int end) {
        String result = "";

        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }

        return result;
    }

    static boolean compareStrings(String s1, String s2) {
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String str = sc.next();

        System.out.print("Enter Start Index: ");
        int start = sc.nextInt();

        System.out.print("Enter End Index: ");
        int end = sc.nextInt();

        String sub1 = createSubstring(str, start, end);
        String sub2 = str.substring(start, end);

        System.out.println("Using charAt(): " + sub1);
        System.out.println("Using substring(): " + sub2);
        System.out.println("Same? " + compareStrings(sub1, sub2));

        sc.close();
    }
}