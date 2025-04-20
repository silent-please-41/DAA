import java.util.*;

public class MatrixSum {

    static int rowSum(int[][] matrix, int row) {
        int sum = 0;
        for (int j = 0; j < 3; j++) sum += matrix[row][j];
        return sum;
    }

    static int colSum(int[][] matrix, int col) {
        int sum = 0;
        for (int i = 0; i < 3; i++) sum += matrix[i][col];
        return sum;
    }

    static int diagSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < 3; i++) sum += matrix[i][i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[3][3];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = sc.nextInt();

        for (int i = 0; i < 3; i++) System.out.println("Row " + (i+1) + " sum: " + rowSum(matrix, i));
        for (int i = 0; i < 3; i++) System.out.println("Column " + (i+1) + " sum: " + colSum(matrix, i));
        System.out.println("Diagonal sum: " + diagSum(matrix));

        sc.close();
    }
}
