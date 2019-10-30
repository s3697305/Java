import java.util.*;
import java.lang.Math;

public class Lab1 {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        questionLoop();
    }


    // ** Functions declaration **

    public static void questionLoop() {
        System.out.print("Enter the exercise number (0 to exit): ");
        int choice = input.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    helloWorld();
                    break;
                case 2:
                    drawJava();
                    break;
                case 3:
                    celToFah();
                    break;
                case 4:
                    sumDigits();
                    break;
                case 5:
                    savingMoney();
                    break;
                case 6:
                    numberOrder();
                    break;
                case 7:
                    divisible();
                    break;
                case 8:
                    dayOfTheWeek();
                    break;
                case 9:
                    overlapCircles();
                    break;
                case 10:
                    //jap();
                    break;



                default:
                    System.out.println("Invalid input.");
            }
            System.out.print("\nEnter the exercise number: ");
            choice = input.nextInt();
        }

        System.out.println("Program finished!");

    }
    //ex1
    public static void helloWorld() {

        System.out.println("Hello World");
    }

    //ex2
    public static void drawJava() {
        System.out.println("    J     A   V     V   A");
        System.out.println("    J    A A   V   V   A A");
        System.out.println("J   J   AAAAA   V V   AAAAA");
        System.out.println(" J J   A     A   V   A     A");
    }

    //ex3
    public static void celToFah() {
        System.out.print("Enter a degree in Celsius: ");
        double celsius = input.nextDouble();
        double fahrenheit = (9.0 / 5) * celsius + 32; //double type
        System.out.printf("%.2f Celsius = %.2f Fahrenheit\n",celsius ,fahrenheit);
    }

    //ex4
    public static void sumDigits() {
        System.out.print("Enter a integer from 0 to 1000: ");
        int number = input.nextInt();

        int sum = 0;

        if (number < 0)
            System.out.println("Invalid input");

        while (number > 0) {
            sum = sum + (number % 10);
            number = number/10;
        }
        System.out.print("Sum of all digits is: " + sum + "\n");
    }

    //ex5
    public static void savingMoney() {
        System.out.print("Enter a monthly saving amount: ");
        double saving = input.nextDouble();
        double balance = 0;
        double interest = 0.00417;
        //int month = 1;
        //using while loop:
        /*while (month < 13) {
            balance = (saving + balance) * (1 + interest);
            if (month == 1) {
                System.out.printf("Your saving after 1 month is: %.2f\n", balance);
                month += 1;
            }
            else
            System.out.printf("Your saving after %d months is: %.3f\n", month, balance);
            month += 1;
        } */

        //Using for loop:
        balance = 0;
        for (int month = 1; month < 13; month++) {
            balance = ((saving + balance) * (1 + interest));
            if (month == 1)
                System.out.printf("Your saving after %d month is: %.3f\n", month, balance);
            else
                System.out.printf("Your saving after %d months is: %.3f\n", month, balance);
        }
    }

    //ex6
    public static void numberOrder() {
        System.out.print("Input number 1: ");
        int num1 = input.nextInt();
        System.out.print("Input number 2: ");
        int num2 = input.nextInt();
        System.out.print("Input number 3: ");
        int num3 = input.nextInt();

        System.out.print("The ascending order is: ");

        if ((num1 < num2) && (num1 < num3)) {
            if (num2 < num3)
                System.out.printf("%d %d %d", num1, num2, num3);
            else
                System.out.printf("%d %d %d", num1, num3, num2);
        } else if ((num2 < num3) && (num2 < num1)) {
            if (num3 < num1)
                System.out.printf("%d %d %d", num2, num3, num1);
            else
                System.out.printf("%d %d %d", num2, num1, num3);
        } else if ((num3 < num1) && (num3 < num2)) {
            if (num1 < num2)
                System.out.printf("%d %d %d", num3, num1, num2);
            else
                System.out.printf("%d %d %d", num3, num2, num1);
        }
        System.out.println();

    }

    //ex7
    public static void divisible() {
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        int div5 = num % 5;
        int div6 = num % 6;

        //while (num != -1) {
            if ((div5 == 0) && (div6 == 0))
                System.out.println(num + " is divisible by both 5 and 6.");
            else if ((div5 == 0) || (div6 == 0))
                System.out.println(num + " is divisible by 5 or 6, but not both.");
            else
                System.out.println(num + " is not divisible by either 5 or 6.");

//            System.out.print("\nEnter a number: ");
//            num = input.nextInt();
    }

    //ex8
    public static void dayOfTheWeek() {
        System.out.print("Enter year: ");
        int year = input.nextInt();
        System.out.print("Enter month: ");
        int month = input.nextInt();
        System.out.print("Enter date: ");
        int date = input.nextInt();
        int century = (year / 100) + 1;
        int yearofcentury = year % 100;
        String dayLetter = ".";

        //System.out.println(century);

        if (month == 1) {
            month = 13;
            year -= 1;
        }

        if (month == 2) {
            month = 14;
            year -= 1;
        }

        //Christian Zeller's algorithm

        int dayoftheweek = (date + (26 * (month + 1)/10) + yearofcentury +
                ((yearofcentury)/4) + (century / 4) + (5 * century)) % 7;

        switch(dayoftheweek) {
            case 0:
                dayLetter = "Sunday";
                break;
            case 1:
                dayLetter = "Monday";
                break;
            case 2:
                dayLetter = "Tuesday";
                break;
            case 3:
                dayLetter = "Wednesday";
                break;
            case 4:
                dayLetter = "Thursday";
                break;
            case 5:
                dayLetter = "Friday";
                break;
            case 6:
                dayLetter = "Saturday";
                break;
        }

        System.out.println("Day of the week is: " + dayLetter);


        //if ((year) < 0)
        //            System.out.println("Invalid input.");

        //check for valid inputs too!

    }

    //ex9
    static class Circle {
        double x;
        double y;
        double radius;
    }

    public static void overlapCircles() {

        Circle circle1 = new Circle();
        Circle circle2 = new Circle();

        System.out.print("Enter circle 1's center x-, y-coordinates, and radius: ");
        circle1.x = input.nextDouble();
        circle1.y = input.nextDouble();
        circle1.radius = input.nextDouble();

        System.out.print("Enter circle 2's center x-, y-coordinates, and radius: ");
        circle2.x = input.nextDouble();
        circle2.y = input.nextDouble();
        circle2.radius = input.nextDouble();

        double distance = Math.sqrt(Math.pow((circle1.x - circle2.x), 2) + Math.pow((circle1.y - circle2.y), 2));

        if ((circle1.radius > 0) && (circle2.radius > 0) ) {
            if ((circle1.x == circle2.x) && (circle1.y == circle2.y) && (circle1.radius == circle2.radius))
                System.out.println("Two circles are equal on top of each other");
            else if (distance <= Math.abs(circle1.radius - circle2.radius))
                System.out.println("Circle 2 is inside circle 1.");
            else if (distance <= (circle1.radius + circle2.radius))
                System.out.println("Circle 2 overlaps circle 1.");
            else if (distance >= (circle1.radius + circle2.radius))
                System.out.println("Circle 2 is outside circle 1.");
            else
                System.out.println("Invalid input.");
        } else
            System.out.println("Radii have to be greater than 0.");
    }

}
