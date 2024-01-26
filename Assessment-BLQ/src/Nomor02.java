import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Nomor02 {
    public static void main(String[] args) throws Exception{
        String aBorrowDate = "28 Februari 2016";
        String aReturnDate = "7 Maret 2016";

        String bBorrowDate = "29 April 2018";
        String bReturnDate = "30 Mei 2018";

        Map<String, Integer> bookMaximumBorrowingDays = new HashMap<>();
        bookMaximumBorrowingDays.put("A", 14);
        bookMaximumBorrowingDays.put("B", 3);
        bookMaximumBorrowingDays.put("C", 7);
        bookMaximumBorrowingDays.put("D", 7);

        System.out.println("Case a " + aBorrowDate + " until " + aReturnDate);
        libraryPenalty(bookMaximumBorrowingDays, aBorrowDate, aReturnDate);

        System.out.println();

        System.out.println("Case b " + bBorrowDate + " until " + bReturnDate);
        libraryPenalty(bookMaximumBorrowingDays, bBorrowDate, bReturnDate);
    }

    private static int countDays(String borrowingDay, String returnDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", new Locale("id", "ID"));
        Date date1, date2;

        try {
            date1 = dateFormat.parse(borrowingDay);
            date2 = dateFormat.parse(returnDay);
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }

        long duration = date2.getTime() - date1.getTime();
        return (int) TimeUnit.DAYS.convert(duration, TimeUnit.MILLISECONDS) + 1;
    }

    private static int countPenalty(Integer bookMaximumBorrowingDays, int borrowingDays) {
        if (borrowingDays <= bookMaximumBorrowingDays) {
            return 0;
        } else {
            return (borrowingDays - bookMaximumBorrowingDays) * 100;
        }
    }

    public static void libraryPenalty(Map<String, Integer> bookMaximumBorrowingDays, String borrowingDate,
                                      String returnDate) {
        int result = 0;
        int duration = countDays(borrowingDate, returnDate);
        for (String book : bookMaximumBorrowingDays.keySet()) {
            Integer maxDays = bookMaximumBorrowingDays.get(book);
            System.out.println("Penalty book " + book + " : " + countPenalty(maxDays, duration));
            result += countPenalty(maxDays, duration);
        }
        System.out.println("Total penalty: " + result);
    }
}
