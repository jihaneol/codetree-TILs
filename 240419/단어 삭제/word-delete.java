import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        String remove_word = sc.next();

        word = word.replaceAll(remove_word, "");
        System.out.print(word);
    }
}