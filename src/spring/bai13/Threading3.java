package spring.bai13;

import java.util.Random;

public class Threading3 {
    public static int year = 0;

    public static void main(String[] args) {
        Threading3 main = new Threading3();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (year != 0) {
                        if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
                            System.out.println("Nam " + year + " la nam nhuan!");
                        } else {
                            System.out.println("Nam " + year + " khong la nam nhuan!");
                        }
                        year = 0;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (year == 0) {
                        Random a = new Random();
                        year = 1000 + a.nextInt(1000);
                        System.out.println(year);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}

