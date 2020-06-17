package day617;

public class Homework2 {

    public static void main(String[] args) {

        for(int i = 1; i<=10 ; i++) {
            for (int j = 1; j <= 10 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
