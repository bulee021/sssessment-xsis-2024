import java.util.Scanner;

public class Nomor12 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // INPUT STRING TO SPLIT SPACE AND CONVERT TO INT ARRAY
        System.out.print("input : ");
        String data = input.nextLine();
        String[] arrIn = data.split(" ");
        int[] arrint = new int[arrIn.length];
        int temp = 0;

        for (int i = 0; i < arrIn.length; i++) {
            arrint[i] = Integer.parseInt(arrIn[i]);
        }

        for (int i = 0; i < arrint.length; i++) {
            for (int j = i + 1; j < arrIn.length; j++) {
                if (arrint[i] > arrint[j]) {
                    temp = arrint[i];
                    arrint[i] = arrint[j];
                    arrint[j] = temp;
                }
            }
        }
        System.out.print("Output : ");
        for (int i = 0; i < arrint.length; i++) {
            System.out.print(arrint[i] + " ");
        }
    }
}
