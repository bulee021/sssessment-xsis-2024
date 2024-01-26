import java.util.Scanner;

public class Nomor11 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("kalimat : ");
        String kalimat = input.nextLine();
        int kata = Math.abs(kalimat.length() / 2);

        for (int i = 0; i < kalimat.length(); i++) {
            String w = "";
            for (int j = 0; j < (kata * 2) + 1; j++) {
                if (j == kata) {
                    w = w + String.valueOf(kalimat.charAt(i));
                } else {
                    w = w + "*";
                }
            }
            System.out.println(w);
        }
    }
}
