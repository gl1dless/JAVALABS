import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n = 10; // размер массива
        int[] x = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            x[i] = rand.nextInt(101) - 50; // [-50, 50]
        }

        System.out.println("Исходный массив х:");
        printArray(x);

        int[] y = createNegativeDoubleArray(x);

        System.out.println("\nМассив у (отрицательные элементы * 2):");
        printArray(y);

        selectionSort(y);

        System.out.println("\nМассив у после сортировки по возрастанию:");
        printArray(y);
    }

    public static int[] createNegativeDoubleArray(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int value : arr) {
            if (value < 0) {
                list.add(value * 2);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void printArray(int[] arr) {
        if (arr.length == 0) {
            System.out.println("(нет элементов)");
            return;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
