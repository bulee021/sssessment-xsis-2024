public class Nomor16 {
    public static void main(String[] args) {
        int[][] menu = new int[][] { { 42000, 1 }, { 50000, 0 }, { 30000, 0 }, { 70000, 0 }, { 30000, 0 } };

        int jumlahOrang = 4;
        int orangAlergi = 1;

        bagiTagihan(menu, jumlahOrang, orangAlergi);
    }
    private static float[] caseSplitBill(int[][] menu, int totalPerson, int allergicPerson) {
        float allergicBill = 0;
        float nonAllergicBill = 0;
        float allergicSum = 0;
        float nonAllergicSum = 0;

        for (int i = 0; i < menu.length; i++) {
            if (menu[i][1] == 1) {
                allergicSum += pajakDanService(menu[i][0]);
            } else {
                nonAllergicSum += pajakDanService(menu[i][0]);
            }
        }
        allergicBill = nonAllergicSum / (totalPerson);
        System.out.println(allergicBill);
        nonAllergicBill = allergicBill + (allergicSum / (totalPerson - allergicPerson));
        System.out.println(allergicSum);
        System.out.println(nonAllergicBill);

        return new float[] { allergicBill, nonAllergicBill };
    }
    private static float pajakDanService(int price) {
        return price + (price * 15 / 100);
    }

    public static void bagiTagihan(int[][] menu, int totalPerson, int allergicPerson) {
        float[] bill = caseSplitBill(menu, totalPerson, allergicPerson);
        System.out.println("Bill for non-allergic: " + bill[1]);
        System.out.println("Bill for allergic: " + bill[0]);
    }
}
