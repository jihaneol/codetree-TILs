public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        int a = 7;
        int b = 5;
        int c = 6;
        print(a);
        print(b);
        print(c);
    }
    public static <T> void print(T value){
            System.out.println(value);
            return value;
    }
}