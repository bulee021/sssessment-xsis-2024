import java.util.Scanner;

public class Nomor21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Lintasan ('_'/'0') : ");
        String lintasan = scanner.next();

        int st = 0;
        for (int i = 0; i < lintasan.length(); i++) {
            int w = 0;
            if (String.valueOf(lintasan.charAt(i)).equals("_")) {
                w = +1;
                if (w == 2) {
                    st += 1;
                }
                System.out.print("W ");
            }
            if (i + 1 < lintasan.length() || i + 2 < lintasan.length()) {
                if (String.valueOf(lintasan.charAt(i + 1)).equals("0")
                        || String.valueOf(lintasan.charAt(i + 2)).equals("0") && st > 0) {
                    i = i + 3;
                    st = st - 1;
                    System.out.print("J ");
                }
            }

            if (String.valueOf(lintasan.charAt(0)).equals("0") || String.valueOf(lintasan.charAt(1)).equals("0")) {
                System.out.print("FAILED");
                break;
            }

        }
    }
}
