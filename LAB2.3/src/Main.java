import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int a = 4;
        int[][] matrix = new int[a][a];
        Random rand = new Random();

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                matrix[i][j] = rand.nextInt(101) - 50;
            }
        }

        printMatrix(matrix);

        int[] vectorB = createMinVector(matrix);

        System.out.println("\nvector:");
        printArray(vectorB);
    }

    public static int[] createMinVector(int[][] matrix) {
        int[] minVector = new int[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minVector[i] = min;
        }
        return minVector;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf(val + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
