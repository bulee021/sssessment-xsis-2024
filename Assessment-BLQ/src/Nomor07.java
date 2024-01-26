import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Nomor07 {
    public static void main(String[] args) {
        int[] deret = {1,3,5,7,9,7,8,7,5,6,3,2,6,7,6,6};

        double mean = Mean(deret);
        double median = Median(deret);
        double mode = Modus(deret);

        System.out.println("Mean: "+ mean);
        System.out.println("Median: "+ median);
        System.out.println("Mode: "+ mode);
    }
    public static double Mean(int[] arr) {
        double mean = 0;
        for (int i = 0; i < arr.length; i++)
            mean = mean + arr[i];
        mean = mean / arr.length;

        return mean;
    }

    public static double Median(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        double median = 0;
        int n = arrCopy.length;

        if (n % 2 == 1) {
            median = arrCopy[n / 2];
        } else {
            median = (arrCopy[n / 2] + arrCopy[n / 2 - 1]) / 2.0;
        }

        return median;
    }

    public static double Modus(int[] arr) {
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);

        Map<Integer, Integer> freq = new TreeMap<>();
        for (int i : arrCopy) {
            if (!freq.containsKey(i))
                freq.put(i, 1);
            else
                freq.put(i, freq.get(i) + 1);
        }

        double modus = arrCopy[0];
        int maxFreq = 1;

        for (Map.Entry<Integer, Integer> me : freq.entrySet()) {
            if (me.getValue() > maxFreq) {
                maxFreq = me.getValue();
                modus = me.getKey();
            }
        }

        return modus;
    }
}
