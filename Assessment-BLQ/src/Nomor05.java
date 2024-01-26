import java.util.Scanner;

public class Nomor05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("n : ");
        int n = input.nextInt();
        input.nextLine();

        int x = 0;
        int y = 1;
        System.out.print(x+" "+y);
        int z ;
        for (int i = 2; i <= n; i++) {
            z = x + y;
            System.out.print(" "+z);
            x = y;
            y = z;
        }
    }
}

