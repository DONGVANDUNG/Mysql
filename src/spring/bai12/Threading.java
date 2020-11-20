package spring.bai12;

public class Threading {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
        while (true) {
            System.out.println("DEF");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("ABC");
            try {
                Thread.sleep(3500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
