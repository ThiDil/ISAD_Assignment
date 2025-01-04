/****************************************************************************
 Author - K.A.Thisal Dilmeth
 date - 23.05.2024
 purpose - Final assignment of the module ISAD1000
 ****************************************************************************/

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Welcome to the Numerology Analysis program.\n");

        do {
            System.out.print("Do you want to enter one(1) birthday or two(2) birthdays? ");
            choice = sc.nextInt();

            if(choice != 1 && choice != 2)
            {
                System.out.println("Please enter a valid choice.");
            }
        }while(choice != 1 && choice != 2);

        if(choice == 1) {
            singleBirthday();
        }
        if(choice == 2) {
            twoBirthdays();
        }
    }

    public static void singleBirthday()
    {
        int year = 0, ogYear, mv, day, lifePNum;
        String month, luckyColor = null;
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your birthday in the following order.");

        while(!validInput) {
            try {
                System.out.print("Year:- ");
                year = sc.nextInt();
                year = validYear(year);
                validInput = true;
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a valid integer year.");
                sc.nextLine();
            }
        }

        sc.nextLine();
        System.out.print("Month:- ");
        month = sc.nextLine().trim();
        mv = validateMonth(month);

        System.out.print("Day:- ");
        day = sc.nextInt();
        day = validDay(year, day, mv);

        System.out.println("\nYour birthday is -> " + year + "/" + mv + "/" + day);
        ogYear = year;

        System.out.println("\nCalculating life path number...");
        lifePNum = calcuLifePNum(mv, day, year);

        System.out.println("Your life path number is " + lifePNum);

        if(lifePNum == 11 || lifePNum == 22 || lifePNum == 33) {
            System.out.println("\n" + lifePNum + " is a master number.");
        }
        else {
            System.out.println("\n" + lifePNum + " is not a master number.");
        }

        luckyColor = Utility.luckyColorCheck(lifePNum);
        System.out.println("\nYour lucky color is " + luckyColor + "\n");
        Utility.generationCheck(ogYear); //calling method to check the generation.
        sc.close();
    }

    public static void twoBirthdays()
    {
        int year = 0, ogYear, mv, day, lifePNum, lifeP1 = 0, lifeP2 = 0;
        String month, luckyColor = null;
        boolean validInput = false;
        Scanner sc = new Scanner(System.in);

        for(int j = 0; j < 2; j++) {
            System.out.println("\nEnter your birthday in the following order.");

            while(!validInput) {
                try {
                    System.out.print("Year:- ");
                    year = sc.nextInt();
                    year = validYear(year);
                    validInput = true;
                }
                catch (InputMismatchException e){
                    System.out.println("Please enter a valid integer year.");
                    sc.nextLine();
                }
            }
            validInput = false;

            sc.nextLine();
            System.out.print("Month:- ");
            month = sc.nextLine().trim();
            mv = validateMonth(month);

            System.out.print("Day:- ");
            day = sc.nextInt();
            day = validDay(year, day, mv);

            System.out.println("\nYour birthday is -> " + year + "/" + mv + "/" + day);
            ogYear = year;

            System.out.println("\nCalculating life path number...");
            lifePNum = calcuLifePNum(mv, day, year);

            if(j == 0) { lifeP1 = lifePNum; }
            if(j == 1) { lifeP2 = lifePNum; }
            System.out.println("Your life path number is " + lifePNum);

            if(lifePNum == 11 || lifePNum == 22 || lifePNum == 33) {
                System.out.println("\n" + lifePNum + " is a master number.");
            } else {
                System.out.println("\n" + lifePNum + " is not a master number.");
            }

            luckyColor = Utility.luckyColorCheck(lifePNum);
            System.out.println("\nYour lucky color is " + luckyColor + "\n");
            Utility.generationCheck(ogYear); //calls method to find the generation.
        }

        if(lifeP1 == lifeP2) {
            System.out.println("The life path numbers of the two birthdays are the same.");
        } else {
            System.out.println("The life path numbers of the two birthdays are not the same.");
        }
        sc.close();
    }

    public static int validYear(int year) {
        Scanner sc = new Scanner(System.in);
        boolean validInput = false;

        while (!validInput) {
            try {
                if (1901 <= year && year <= 2024) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a year between 1901 and 2024.");
                    return 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer year.");
                sc.nextLine();
                return 0;
            }
        }
        return year;
    }

    public static int validateMonth(String month) {
        int monthNum = 0, mv;
        Scanner sc = new Scanner(System.in);

        try {
            monthNum = Integer.parseInt(month);
            while(0 > monthNum || monthNum > 13) {
                System.out.println("Please enter a valid month.");
                System.out.print("Month:- ");
                month = sc.nextLine();
                monthNum = Integer.parseInt(month);
            }
            mv = monthNum;
        } catch(NumberFormatException e) {
            mv = Utility.monthValid(month, monthNum);
            while (mv == 0) {
                System.out.println("Please enter a valid month or check the spellings of the month name.");
                System.out.print("Month:- ");
                month = sc.nextLine();
                mv = Utility.monthValid(month, monthNum);
            }
        }
        return mv;
    }

    public static int validDay(int year, int day, int mv) {
        Scanner sc = new Scanner(System.in);
        if (mv == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                while(day > 29 || day < 0) {
                    System.out.println("Please enter a valid day.");
                    System.out.print("Day:- ");
                    day = sc.nextInt();
                }
            }
            else{
                while(day > 28 || day < 0) {
                    System.out.println("Please enter a valid day.");
                    System.out.print("Day:- ");
                    day = sc.nextInt();
                }
            }
        }
        else if (mv == 4 || mv == 6 || mv == 9 || mv == 11) {
            while(day > 30 || day < 0) {
                System.out.println("Please enter a valid day.");
                System.out.print("Day:- ");
                day = sc.nextInt();
            }
        }
        else if (mv == 1 || mv == 3 || mv == 5 || mv == 7 || mv == 8 || mv == 10 || mv == 12) {
            while(day > 31 || day < 0) {
                System.out.println("Please enter a valid day.");
                System.out.print("Day:- ");
                day = sc.nextInt();
            }
        }
        else {
            day = 0;
        }
        return day;
    }

    public static int calcuLifePNum(int mv, int day, int year) {
        int sumMonth, sumYear, sumDay = 0, i, total, temp = 0, lifePNum = 0;
        String luckyColor;

        int[] yearArray = new int[4];
        int[] monthArray = new int[2];
        int[] dayArray = new int[2];

        for (i = 0; i < yearArray.length; i++) {
            yearArray[i] = year % 10;
            year = year / 10;
        }
        sumYear = yearArray[0] + yearArray[1] + yearArray[2] + yearArray[3];

        while (sumYear > 9 && sumYear != 11 && sumYear != 22 && sumYear != 33) {
            sumYear = (sumYear % 10) + (sumYear / 10);
        }

        if (mv == 11) {
            sumMonth = mv;
        }
        else if (mv > 9){
            do {
                monthArray[0] = mv % 10;
                monthArray[1] = mv / 10;
                sumMonth = monthArray[0] + monthArray[1];
            } while(sumMonth > 9);
        }
        else {
            sumMonth = mv;
        }

        if (day == 11 || day == 22 || day == 33) {
            sumDay = day;
        }
        else if(day > 9) {
            do {
                dayArray[0] = day % 10;
                dayArray[1] = day / 10;
                sumDay = dayArray[0] + dayArray[1];
                if (sumDay == 11 || sumDay == 22 || sumDay == 33) {
                    break;
                }
            }while (sumDay > 10);
        }
        else {
            sumDay = day;
        }

        total = sumYear + sumMonth + sumDay;

        while (total > 9 && total != 11 && total != 22 && total != 33) {
            total = (total % 10) + (total / 10);
        }

        switch(total){
            case 11:
                lifePNum = 11;
                break;
            case 22:
                lifePNum = 22;
                break;
            case 33:
                lifePNum = 33;
                break;
            default:
                lifePNum = total;
        }
        return lifePNum;
    }

}
