import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] A = new int[n][n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = rand.nextInt(101) - 50;
            }
        }

        printMatrix(A);

        int min = A[0][0];
        int max = A[0][0];
        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 0; i < n; i++) {
            int value = A[i][i];
            if (value < min) {
                min = value;
                minIndex = i;
            }
            if (value > max) {
                max = value;
                maxIndex = i;
            }
        }

        int sumIndexes = minIndex + maxIndex;


        System.out.println("summ: " + sumIndexes);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf(val + " ");
            }
            System.out.println();
        }
    }
}
