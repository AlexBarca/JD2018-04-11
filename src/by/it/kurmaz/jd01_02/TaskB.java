package by.it.kurmaz.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        step1();
        System.out.println("Enter month pls from 1 to 12");
        int month = scanner.nextInt();
        step2(month);
        System.out.println("Enter 3 numbers");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        step3(a, b, c);
    }

    private static void step3(double a, double b, double c) {
        double discriminant = Math.pow(b, 2) - 4*a*c;
        System.out.println(discriminant);
        if (discriminant < 0)
            System.out.println("корней нет");
        if (discriminant == 0)
            System.out.println((-b - Math.sqrt(discriminant))/ (2*a));
        if (discriminant > 0) {
            System.out.println((-b - Math.sqrt(discriminant))/ (2*a));
            System.out.println((-b + Math.sqrt(discriminant))/ (2*a));
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step1() {
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                System.out.print(j + i*5 + " ");
            }
            System.out.println("\n");
        }
    }


}
