public class Nomor22 {
    public static void main(String[] args) {
        int[] inputArray = new int[] { 3, 3, 9, 6, 7, 8, 23 };
        System.out.println(fibonacciCandles(inputArray));
    }

    public static int fibonacciCandles(int[] arrayInput) {
        int result = 0;
        int[] temp = new int[arrayInput.length];
        int[] arrayFibonacci = new int[] { 1, 1, 2, 3, 5, 8, 13 };
        for (int i = 0; i < arrayInput.length; i++) {
            temp[i] = arrayInput[i] - arrayFibonacci[i];
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] <= 0) {
                result = arrayInput[i];
            }
        }
        return result;
    }
}
