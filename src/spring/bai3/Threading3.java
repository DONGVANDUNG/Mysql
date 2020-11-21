package spring.bai3;

import javafx.scene.transform.Scale;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Threading3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            for (int i = 1000; i < 1020; i++) {
                Thread3 thread3 = new Thread3(i);
                thread3.start();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ((i % 4 == 0) || ((i % 400 == 0) && (i % 100 != 0))) {
                    System.out.println("Nam " + i + " la nam nhuan!");
                } else System.out.println("Nam " + i + " khong la nam nhuan!");

            }
        }
    }
}
class Thread3 extends Thread {
    int i;

    public Thread3(int i) {
        this.i = i;
    }

    @Override
    public void run() {
            System.out.println(i);
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
