import java.util.Scanner;

public class Nomor19 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("input : ");
        String kalimat = input.nextLine();
        int size = kalimat.length();

        if (allLetterCheck(kalimat, size)) {
            System.out.println("IS PANGRAM");
        } else {
            System.out.println("IS NOT PANGRAM");
        }
    }

    public static boolean allLetterCheck(String kalimat, int size) {
        int huruf = 26;
        kalimat = kalimat.toLowerCase();
        boolean[] present = new boolean[huruf];

        for (int i = 0; i < size; i++) {
            if (isLetter(kalimat.charAt(i))) {
                int letter = kalimat.charAt(i) - 'a';
                present[letter] = true;
            }
        }

        for (int i = 0; i < huruf; i++) {
            if (!present[i])
                return false;
        }
        return true;
    }

    public static boolean isLetter(char ch) {
        if (!Character.isLetter(ch)) {
            return false;
        } else {
            return true;
        }
    }
}
