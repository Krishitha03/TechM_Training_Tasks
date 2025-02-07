
import java.util.Scanner;

public class StringProcessor {
    // reverse String
    public static String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString.append(str.charAt(i));
        }
        return reversedString.toString();
    }

    // count occurence of sub string
    public static int countOccurences(String text, String sub) {
        int count = 0;
        for (int i = 0; i <= text.length() - sub.length(); i++) {
            int j;
            for (j = 0; j < sub.length(); j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }
            if (j == sub.length()) {
                count++;
                j = 0;
            }
        }
        return count;
    }

    public static String splitAndCapitalize(String str) {
        StringBuilder sentence = new StringBuilder();
        sentence.append(str);
        if(Character.isLowerCase(sentence.charAt(0)))
            sentence.setCharAt(0, (char) (sentence.charAt(0) - 32));
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '&&Character.isLowerCase(sentence.charAt(i+1))) {
                sentence.setCharAt(i + 1, (char) (str.charAt(i + 1) - 32));
            }
        }
        return sentence.toString();
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String Sentence = s.nextLine();
        String subString = s.next();
        System.out.println("Reversed String Output: " + reverseString(Sentence));
        System.out.println("Count Of Occurence Of SubString: " + countOccurences(Sentence, subString));
        System.out.println("Split And Capitalize Output: " + splitAndCapitalize(Sentence));
    }
}
