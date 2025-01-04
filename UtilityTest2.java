public class UtilityTest2 {

    public static void main(String[] args) {
        testLuckyColorCheck();
        testGenerationCheck();
        testMonthValid();
    }

    static void testLuckyColorCheck() {
        try {
            assert "Red".equals(Utility.luckyColorCheck(1)) : "Test failed for input 1";
            assert "Orange".equals(Utility.luckyColorCheck(2)) : "Test failed for input 2";
            assert "Yellow".equals(Utility.luckyColorCheck(3)) : "Test failed for input 3";
            assert "Green".equals(Utility.luckyColorCheck(4)) : "Test failed for input 4";
            assert "Sky Blue".equals(Utility.luckyColorCheck(5)) : "Test failed for input 5";
            assert "Indigo".equals(Utility.luckyColorCheck(6)) : "Test failed for input 6";
            assert "Violet".equals(Utility.luckyColorCheck(7)) : "Test failed for input 7";
            assert "Magenta".equals(Utility.luckyColorCheck(8)) : "Test failed for input 8";
            assert "Gold".equals(Utility.luckyColorCheck(9)) : "Test failed for input 9";
            assert Utility.luckyColorCheck(0) == null : "Test failed for input 0"; // Test for an invalid life path number
            System.out.println("testLuckyColorCheck passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    static void testGenerationCheck() {
        try {
            Utility.generationCheck(1940);
            Utility.generationCheck(1955);
            Utility.generationCheck(1970);
            Utility.generationCheck(1990);
            Utility.generationCheck(2005);
            Utility.generationCheck(2018);
            System.out.println("testGenerationCheck passed.");
        } catch (Exception e) {
            System.out.println("testGenerationCheck failed: " + e.getMessage());
        }
    }

    static void testMonthValid() {
        try {
            assert Utility.monthValid("January", 0) == 1 : "Test failed for input 'January'";
            assert Utility.monthValid("March", 0) == 3 : "Test failed for input 'March'";
            assert Utility.monthValid("April", 0) == 4 : "Test failed for input 'April'";
            assert Utility.monthValid("September", 0) == 9 : "Test failed for input 'September'";
            assert Utility.monthValid("Dilmeth", 0) == 0 : "Test failed for input 'Dilmeth'"; // Test for an invalid month
            System.out.println("testMonthValid passed.");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }
}
