import java.util.Scanner;

public class Nomor13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INPUT DALAM BENTU JAM:MENIT");
        System.out.print("input : ");
        String in = scanner.nextLine();
        String[] n = in.split(":");

        int jam = Integer.parseInt(n[0].trim()) % 12;
        int menit = Integer.parseInt(n[1].trim());
        double jarumJam = (jam * 30) + (menit * 0.5);
        double jarumMenit = menit * 6;
        double dif = Math.abs(jarumJam - jarumMenit);
        double sudutTerkecil2Jarum = Math.min(dif, 360 - dif);
        System.out.println((int) sudutTerkecil2Jarum);

    }
}
