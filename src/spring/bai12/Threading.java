package spring.bai12;

public class Threading {
    public static void main(String[] args) {
        MyThread thread1=new MyThread("ABC",3500);
        thread1.start();
        MyThread thread2=new MyThread("DEF",2500);
        thread2.start();
    }
}
class MyThread extends Thread {
    String name;
    int sleep;
    MyThread(String name, int sleep){
        this.name=name;
        this.sleep=sleep;
    }
    @Override
    public void run() {
        while (true) {
            System.out.println(name);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
