import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(parenthesesCheck("(()"));
        System.out.println(reverseInteger(1357));
        System.out.println(encryptThis("Hello good day"));
        System.out.println(decipherThis("72olle 103doo 100ya"));
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int openCount = 0, closeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                openCount++;
            if (s.charAt(i) == ')')
                closeCount++;
            if (closeCount > openCount)
                return false;
        }
        return openCount == closeCount;
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String s = "" + n, revString = "";
        for (int i = 0; i < s.length(); i++)
            revString += s.charAt(s.length() - i - 1);
        return revString;
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        String msg = "";
        Scanner src = new Scanner(input);
        while (src.hasNext()) {
            String word = src.next();
            char first = word.charAt(0);
            if (word.length() > 2) {
                char second = word.charAt(1), last = word.charAt(word.length() - 1);
                word = "" + first + last + word.substring(2, word.length() - 1) + second;
            }
            msg += " " + (int) first + word.substring(1);
        }
        if (msg.length() > 0)
            return msg.substring(1);
        else
            return msg;
    }

    // 4. decipherThis
    public static String decipherWord(String x) {
        String noNum = x.replaceAll("\\d", "");
        String yesNum = x.replaceAll(noNum, "");
        int yesNumInt = Integer.parseInt(yesNum);
        char second = noNum.charAt(0);
        char last = noNum.charAt(noNum.length() - 1);
        String a = noNum.replace(second, last);
        String b = noNum.replace(last, second);
        String c = "";

        for (int i = 0; i <= noNum.length() - 2; i++) {
            c += a.charAt(i);
        }
        c += b.charAt(noNum.length() - 1);
        char f = (char) yesNumInt;
        return f + c;
    }

    public static String decipherThis(String input) {
        String[] words = input.split(" ");
        String one = words[0];
        String two = words[1];
        String three = words[2];
        String a = decipherWord(one);
        String b = decipherWord(two);
        String c = decipherWord(three);
        return a + " " + b + " " + c;
    }

}