package spring.bai11;

import java.util.Scanner;

public class Threading {
    public static void main(String[] args) {
        for (int i = 1; i < 51; i++) {
            Thread1 thread1 = new Thread1(i);
            thread1.setName("Thread " + i);
            thread1.start();
        }
    }
}

class Thread1 extends Thread {
    int i;

    public Thread1(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Thread " + i + " start");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
