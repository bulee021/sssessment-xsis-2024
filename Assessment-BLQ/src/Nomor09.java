import java.util.Scanner;

public class Nomor09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n : ");
        int n = input.nextInt();

        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = temp + n;

            System.out.print(temp + " ");
        }
    }
}
