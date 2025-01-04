import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    public static void main(String[] args) {
        testValidYear();
        testInvalidYear();
        testValidDay();
        testInvalidDay();
        testValidateMonth();
        testInvalidMonth();
        testCalcuLifePNum();
        testSingleBirthday();
        testTwoBirthdays();
    }

    public static void testValidYear() {
        try {
            String input = "2000\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(1990) == 1990 : "Test failed for valid year";
            System.out.println("testValidYear passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "1899\n2020\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2020) == 2020 : "Test failed for invalid year 1899";

            input = "2025\n2021\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2021) == 2021 : "Test failed for invalid year 2025";

            input = "err\n2021\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2021) == 2021 : "Test failed for invalid input 'err'";

            input = "3055\n2021\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2021) == 2021 : "Test failed for invalid year 3055";
            System.out.println("testInvalidYear passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testValidDay() {
        try {
            assert Main.validDay(2000, 29, 2) == 29 : "Test failed for leap year February";
            assert Main.validDay(2001, 28, 2) == 28 : "Test failed for non-leap year February";
            assert Main.validDay(2020, 30, 4) == 30 : "Test failed for April with 30 days";
            assert Main.validDay(2020, 31, 12) == 31 : "Test failed for December with 31 days";
            System.out.println("testValidDay passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "30\n28\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validDay(2001, 30, 2) == 28 : "Test failed for invalid day in February";

            input = "31\n30\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validDay(2020, 31, 4) == 30 : "Test failed for invalid day in April";
            System.out.println("testInvalidDay passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testValidateMonth() {
        try {
            assert Main.validateMonth("1") == 1 : "Test failed for month '1'";
            assert Main.validateMonth("2") == 2 : "Test failed for month '2'";
            assert Main.validateMonth("3") == 3 : "Test failed for month '3'";
            assert Main.validateMonth("April") == 4 : "Test failed for month 'April'";
            assert Main.validateMonth("December") == 12 : "Test failed for month 'December'";
            System.out.println("testValidateMonth passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "InvalidMonth\nApril\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validateMonth("InvalidMonth") == 4 : "Test failed for invalid month 'InvalidMonth'";

            input = "Dilmeth\nApril\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validateMonth("InvalidMonth") == 4 : "Test failed for invalid month 'Dilmeth'";
            System.out.println("testInvalidMonth passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testCalcuLifePNum() {
        try {
            assert Main.calcuLifePNum(5, 15, 2000) == 4 : "Test failed for date 5/15/2000";
            assert Main.calcuLifePNum(12, 21, 1989) == 6 : "Test failed for date 12/21/1989";
            assert Main.calcuLifePNum(3, 15, 1990) == 1 : "Test failed for date 3/15/1990";
            assert Main.calcuLifePNum(11, 13, 1987) == 22 : "Test failed for date 11/13/1987";
            assert Main.calcuLifePNum(7, 4, 1992) == 5 : "Test failed for date 7/4/1992";
            assert Main.calcuLifePNum(11, 11, 1992) == 7 : "Test failed for date 11/11/1992";
            assert Main.calcuLifePNum(6, 9, 2002) == 1 : "Test failed for date 6/9/2002";
            System.out.println("testCalcuLifePNum passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testSingleBirthday() {
        try {
            String input = "1990\n4\n10\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            Main.singleBirthday();

            input = "1995\nOctober\n31\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            Main.singleBirthday();

            input = "1988\nFebruary\n29\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            Main.singleBirthday();
            // Verify the output by checking the system output stream if needed
            System.out.println("testSingleBirthday passed.");
        } catch (Exception e) {
            System.out.println("testSingleBirthday failed: " + e.getMessage());
        }
    }

    public static void testTwoBirthdays() {
        try {
            String input = "2000\nJune\n20\n1985\n1\n10\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            Main.twoBirthdays();

            input = "1999\nApril\n30\n1991\n5\n1\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            Main.twoBirthdays();
            // Verify the output by checking the system output stream if needed
            System.out.println("testTwoBirthdays passed.");
        } catch (Exception e) {
            System.out.println("testTwoBirthdays failed: " + e.getMessage());
        }
    }
}


