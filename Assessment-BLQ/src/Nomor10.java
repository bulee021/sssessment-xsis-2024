import java.util.Scanner;

public class Nomor10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("kalimat : ");
        String kalimat = input.nextLine();
        String[] arrIn = kalimat.split(" ");
        String kataBaru = "";

        for(int i = 0; i < arrIn.length; i++) {
            String s = arrIn[i].trim();
            String ns = "";

            for(int j = 0; j < s.length(); j++) {
                String text1 = "";
                String text2 = "";
                String text3 = "";

                if(j==0) {
                    text1 = String.valueOf(s.charAt(j));
                    ns = ns + text1;

                }else if(j == s.length()-1) {
                    text2 = String.valueOf(s.charAt(j));
                    ns = ns + text2;

                }else {
                    text3 = "*";
                    ns = ns + text3;

                }

            }
            kataBaru = kataBaru + " " + ns;
        }

        System.out.println(kataBaru.trim());
    }
}
