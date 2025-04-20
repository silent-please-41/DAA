import java.util.Scanner;

public class Factorial {

    static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non‑negative integer: ");
        int n = sc.nextInt();
        sc.close();

        long fact = factorial(n);
        System.out.println(n + "! = " + fact);
    }
}
