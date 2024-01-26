import java.util.Scanner;

public class Nomor14 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("input deret : ");
        String in = scanner.nextLine();

        System.out.print("input index baru : ");
        int idx = scanner.nextInt();

        String[] arrIn = in.split(" ");
        int[] arrint = new int[arrIn.length];

        for (int i = 0; i < arrIn.length; i++) {
            arrint[i] = Integer.parseInt(arrIn[i]);
        }

        plusIndex(arrint, idx);
    }

    public static void plusIndex(int[] data, int idx) {

        System.out.print("new index : ");
        for (int i = 0; i < data.length; i++) {
            if (i + idx >= data.length) {
                System.out.print(data[((i + idx) - data.length)]+" ");
            } else {
                System.out.print(data[i + idx]+" ");

            }
        }
    }
}
