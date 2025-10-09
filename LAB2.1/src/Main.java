import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static final int LIMIT = 10;

    public static void main(String[] args) {
        int size = 10;
        int[] numbers = new int[size];
        Random rand = new Random();

        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(199) - 99;
        }

        System.out.println("Исходный массив:");
        printArray(numbers);

        int[] filteredValues = getValuesBelowLimit(numbers, LIMIT);
        int[] filteredIndexes = getIndexesBelowLimit(numbers, LIMIT);

        System.out.println("\nЭлементы, меньшие " + LIMIT + ":");
        printArray(filteredValues);

        System.out.println("Их индексы в исходном массиве:");
        printArray(filteredIndexes);
    }

    public static int[] getValuesBelowLimit(int[] arr, int limit) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (num < limit) {
                result.add(num);
            }
        }
        return toIntArray(result);
    }

    public static int[] getIndexesBelowLimit(int[] arr, int limit) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < limit) {
                result.add(i);
            }
        }
        return toIntArray(result);
    }

    public static int[] toIntArray(ArrayList<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
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
