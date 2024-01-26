import java.util.Scanner;

public class Nomor15 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Jam : ");
        String jam = input.nextLine();

        int h1 = (int) jam.charAt(1) - '0';
        int h2 = (int) jam.charAt(0) - '0';
        int hh = (h2 * 10 + h1 % 10);

        //  "AM"
        if (jam.charAt(8) == 'A') {
            if (hh == 12) {
                System.out.print("00");
                for (int i = 2; i <= 7; i++)
                    System.out.print(jam.charAt(i));
            } else {
                for (int i = 0; i <= 7; i++)
                    System.out.print(jam.charAt(i));
            }
        }

        //  "PM"
        else {
            if (hh == 12) {
                System.out.print("12");
                for (int i = 2; i <= 7; i++)
                    System.out.print(jam.charAt(i));
            } else {
                hh = hh + 12;
                System.out.print(hh);
                for (int i = 2; i <= 7; i++)
                    System.out.print(jam.charAt(i));
            }
        }
    }
}
