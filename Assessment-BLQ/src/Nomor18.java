import java.util.Scanner;

public class Nomor18 {
    public static void main(String[] args) {
        int[] jam = { 9, 13, 15, 17 };
        int[] kalori = { 30, 20, 50, 80 };
        int waktu = 18;

        int durasiOlahraga = 0;
        int minutesInAnHour = 60;
        for (int i = 0; i < jam.length; i++) {
            int bedaWaktu = (waktu - jam[i]);
            durasiOlahraga += 0.1 * kalori[i] * bedaWaktu;

        }
        int hitungDurasi = durasiOlahraga / minutesInAnHour;
        int lamaOlahraga = (100 * hitungDurasi * 2) + 500;
        System.out.println("Donna butuh " + lamaOlahraga + " CC Air");
    }
}
