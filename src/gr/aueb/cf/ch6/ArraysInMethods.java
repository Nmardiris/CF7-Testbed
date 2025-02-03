package gr.aueb.cf.ch6;

/**
 * Demo with arrays and methods
 *
 */
public class ArraysInMethods {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        printArray(arr);

        printArray(arr, 0, arr.length-1);
    }

    public static void printArray(int[] arr) {
        for (int el : arr) {
            System.out.print(el + "");
        }
    }

    public static void printArray(int[] arr, int low, int high) {
        if (low < 0 || high > arr.length - 1) {
            return;
        }
        for (int i= low; i<= high; i++ ) {
            System.out.print(arr[i] + " ");
        }
    }

}
