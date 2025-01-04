import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest2 {
    public static void main(String[] args) {
        testValidYear();
        testInvalidYear();
        testValidDay();
        testInvalidDay();
        testValidateMonth();
        testInvalidMonth();
        testCalcuLifePNum();
    }

    public static void testValidYear() {
        try {
            assert Main.validYear(2000) == 2000 : "Test failed for valid year 2000";
            assert Main.validYear(1901) == 1901 : "Test failed for valid year 1901";
            assert Main.validYear(2024) == 2024 : "Test failed for valid year 2024";
            System.out.println("testValidYear passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "abc\n2004\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2004) == 2004 : "Test failed for valid year 2004 after invalid input";

            input = "2025\n2020\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2020) == 2020 : "Test failed for valid year 2020 after invalid input 2025";

            input = "1899\n1987\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(1987) == 1987 : "Test failed for valid year 1987 after invalid input 1899";

            input = "3055\n2021\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validYear(2021) == 2021 : "Test failed for valid year 2021 after invalid input 3055";
            System.out.println("testInvalidYear passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testValidateMonth() {
        try {
            assert Main.validateMonth("3") == 3 : "Test failed for month '3'";
            assert Main.validateMonth("February") == 2 : "Test failed for month 'February'";
            System.out.println("testValidateMonth passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "13\n12\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validateMonth("12") == 12 : "Test failed for valid month 12 after invalid input 13";

            input = "abc\nMarch\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validateMonth("March") == 3 : "Test failed for valid month March after invalid input abc";

            input = "Dilmeth\nMarch\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validateMonth("March") == 3 : "Test failed for valid month March after invalid input Dilmeth";
            System.out.println("testInvalidMonth passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testValidDay() {
        try {
            assert Main.validDay(2020, 31, 1) == 31 : "Test failed for valid day 31 January 2020";
            assert Main.validDay(2021, 30, 4) == 30 : "Test failed for valid day 30 April 2021";
            assert Main.validDay(2020, 29, 2) == 29 : "Test failed for valid day 29 February 2020";
            assert Main.validDay(2021, 28, 2) == 28 : "Test failed for valid day 28 February 2021";
            System.out.println("testValidDay passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            String input = "32\n21\n";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validDay(2022, 21, 5) == 21 : "Test failed for valid day 21 May 2022 after invalid input 32";

            input = "29\n28\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validDay(2021, 28, 2) == 28 : "Test failed for valid day 28 February 2021 after invalid input 29";

            input = "abc\n14\n";
            in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            assert Main.validDay(2023, 14, 5) == 14 : "Test failed for valid day 14 May 2023 after invalid input abc";
            System.out.println("testInvalidDay passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    public static void testCalcuLifePNum() {
        try {
            assert Main.calcuLifePNum(4, 3, 2020) == 11 : "Test failed for date 4/3/2020";
            assert Main.calcuLifePNum(12, 29, 1985) == 1 : "Test failed for date 12/29/1985";
            assert Main.calcuLifePNum(11, 22, 1999) == 7 : "Test failed for date 11/22/1999";
            System.out.println("testCalcuLifePNum passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}

