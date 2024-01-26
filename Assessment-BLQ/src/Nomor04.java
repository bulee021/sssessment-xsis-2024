import java.util.Scanner;

public class Nomor04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n : ");
        int n = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= n; i++) {
            int x = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    x++;
                }
            }
            if(x == 2) {
                System.out.print(i+" ");
            }
        }
    }
}
