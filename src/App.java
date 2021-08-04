import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        getWords();
        editWords();
        printWords();
    }

    private static void printWords() {
        System.out.print(String.join(" ", words));
    }

    private static void getWords() {
        Scanner in = new Scanner(System.in);
        words.addAll(Arrays.asList(in.nextLine().toLowerCase().split(" ")));
        in.close();
    }

    private static void editWords() {
        removeArticles();
        removeC();
        removeDoubleLetters();
        removeEAtTheEnd();
    }

    private static void removeEAtTheEnd() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (word.length() > 1 && word.lastIndexOf("e") == word.length() - 1) {
                word = word.substring(0, word.length() - 1);
                words.set(i, word);
            }
        }
    }

    private static void removeDoubleLetters() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length() - 1; j++) {
                if (word.charAt(j) == word.charAt(j + 1)) {
                    if (word.charAt(j) == 'e') {
                        word = word.replace("ee", "i");
                    } else if (word.charAt(j) == 'o') {
                        word = word.replace("oo", "u");
                    } else {
                        word = word.replace(word.charAt(j) + Character.toString(word.charAt(j)), Character.toString(word.charAt(j)));
                    }
                    j = -1;
                }
            }
            words.set(i, word);
        }
    }

    private static void removeC() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            word = word.replace("ci", "si")
                    .replace("ce", "se")
                    .replace("ck", "k")
                    .replace("c", "k");
            words.set(i, word);
        }
    }

    private static void removeArticles() {
        for (int i = words.size() - 1; i >= 0; i--) {
            String word = words.get(i);
            if ("a".equals(word) || "an".equals(word) || "the".equals(word)) {
                words.remove(i);
            }
        }
    }

}
