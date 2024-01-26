import java.util.Scanner;

public class Nomor17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("input : ");
        String data = input.nextLine();
        String[] dataSplit = data.split(" ");

        int gunung = 0;
        int lembah = 0;

        int temp = 0;
        for (int i = 0; i < dataSplit.length; i++) {
            if (dataSplit[i].trim().equalsIgnoreCase("N")) {
                temp = temp + 1;
                if (temp == 0 ) {
                    lembah += 1;
                    System.out.println(lembah);
                }
            }else {
                temp = temp - 1;
                if(temp == 0) {
                    gunung +=1;
                    System.out.println(gunung);
                }
            }
        }

        System.out.println(gunung + " Gunung dan " + lembah + " lembah.");
    }
}

