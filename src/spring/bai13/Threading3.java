package spring.bai13;

public class Threading3 {
    public static int i = 999;
    public static int count;
    public static void main(String[] args) {
        Threading3 main = new Threading3();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    main.increament();
                    System.out.println(main.i);
                    main.count = 0;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread2 = new Thread();
        class Thread1 extends Thread {
            @Override
            public void run() {
                while (true) {
                    if (main.count == 0) {
                        main.increament();
                        if (main.i % 400 == 0 || ((main.i % 4 == 0) && (main.i % 100 != 0))) {
                            System.out.println("Nam " + main.i + " la nam nhuan!");
                        } else {
                            System.out.println("Nam " + main.i + " khong la nam nhuan!");
                        }
                        try {
                            Thread.sleep(1500);
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

    public synchronized void increament() {
        if(i<9999){
            i+=1;
        }
        }
    }

