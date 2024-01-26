import java.util.Arrays;

public class Nomor08 {
    public static void main(String[] args) {
        int[] deretAngka = { 2, 4, 7, 3, 6, 8, 4 };
        Arrays.sort(deretAngka);

        // HITUNG MIN DARI DERET
        System.out.println("HITUNG MIN DARI DERET");
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp = temp + deretAngka[i];
        }
        System.out.println("nilai minimum : " + temp);
        System.out.println();

        // HITUNG MAX DARI DERET
        System.out.println("HITUNG MAX DARI DERET");
        int temp02 = 0;
        for (int i = deretAngka.length - 1; i >= deretAngka.length - 4; i--) {
            temp02 = temp02 + deretAngka[i];
        }
        System.out.println("nilai maksimum : " + temp02);
        System.out.println();
    }
}
