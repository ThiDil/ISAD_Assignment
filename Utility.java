/****************************************************************************
 Author - K.A.Thisal Dilmeth
 date - 23.05.2024
 purpose - Final assignment of the module ISAD1000
 ****************************************************************************/
class Utility{
    public static String luckyColorCheck(int lifePNum)
    {
        String luckyColor = null;
        switch(lifePNum) {
            case 1:
                luckyColor = "Red";
                break;
            case 2:
                luckyColor = "Orange";
                break;
            case 3:
                luckyColor = "Yellow";
                break;
            case 4:
                luckyColor = "Green";
                break;
            case 5:
                luckyColor = "Sky Blue";
                break;
            case 6:
                luckyColor = "Indigo";
                break;
            case 7:
                luckyColor = "Violet";
                break;
            case 8:
                luckyColor = "Magenta";
                break;
            case 9:
                luckyColor = "Gold";
                break;
            case 11:
                luckyColor = "Silver";
                break;
            case 22:
                luckyColor = "White";
                break;
            case 33:
                luckyColor = "Crimson";
                break;
            default:
                break;
        }
        return luckyColor;
    }

    public static void generationCheck(int ogYear)
    {
        if(ogYear <= 1945 && ogYear >= 1901) {
            System.out.println("You belong to Generation Silent.");
        }
        if(ogYear <= 1964 && ogYear >= 1946) {
            System.out.println("You are a Baby Boomer.");
        }
        if(ogYear <= 1979 && ogYear >= 1965) {
            System.out.println("You belong to Generation X.");
        }
        if(ogYear <= 1994 && ogYear >= 1980) {
            System.out.println("You are a Millennial.");
        }
        if(ogYear <= 2009 && ogYear >= 1995) {
            System.out.println("You belong to Generation Z.");
        }
        if(ogYear <= 2024 && ogYear >= 2010) {
            System.out.println("You belong to Generation Alpha.");
        }
    }

    public static int monthValid(String month, int monthNum)
    {
        switch(month.toUpperCase())
        {
            case "JANUARY":
                monthNum = 1;
                break;
            case "FEBRUARY":
                monthNum = 2;
                break;
            case "MARCH":
                monthNum = 3;
                break;
            case "APRIL":
                monthNum = 4;
                break;
            case "MAY":
                monthNum = 5;
                break;
            case "JUNE":
                monthNum = 6;
                break;
            case "JULY":
                monthNum = 7;
                break;
            case "AUGUST":
                monthNum = 8;
                break;
            case "SEPTEMBER":
                monthNum = 9;
                break;
            case "OCTOBER":
                monthNum = 10;
                break;
            case "NOVEMBER":
                monthNum = 11;
                break;
            case "DECEMBER":
                monthNum = 12;
                break;
            default:
                return 0;
        }
        return monthNum;
    }
}
