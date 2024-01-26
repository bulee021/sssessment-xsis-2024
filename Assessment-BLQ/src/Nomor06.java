import java.util.Scanner;

public class Nomor06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("kata : ");
        String kata = input.next();
        input.nextLine();

        String kataDibalik = "";
        for (int i = kata.length()-1; i >= 0 ; i--) {
            kataDibalik = kataDibalik + kata.charAt(i);
        }

        if(kataDibalik.equalsIgnoreCase(kata)) {
            System.out.println("Palindrome");
        }else {
            System.out.println("Bukan Palindrome");
        }
    }
}
