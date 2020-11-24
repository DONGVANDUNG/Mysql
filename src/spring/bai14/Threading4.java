package spring.bai14;

import com.sun.deploy.net.proxy.ProxyUnavailableException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static sun.misc.PostVMInitHook.run;

public class Threading4 {
       public static int count = 1;
    public static void main(String[] args) {
       Thread1 thread1=new Thread1();
       Thread2 thread2=new Thread2();
        thread1.start();
        thread2.start();
    }
    public synchronized void display() {
        Map<String, String> add = new HashMap<String, String>();
        add.put("Monday", "Thu 2");
        add.put("Tuesday", "Thu 3");
        add.put("Wednesday", "Thu 4");
        add.put("Thursday", "Thu 5");
        add.put("Friday", "Thu 6");
        add.put("Saturday", "Thu 7");
        add.put("Sunday", "Chu nhat");
        for (String i:add.keySet()) {
        if (count == 1) {
            System.out.println(i);
        }
        if (count == 0) {
            System.out.println(add.get(i));
            }
        }
    }
     static class Thread1 extends Thread {
         Threading4 main = new Threading4();
         @Override
         public void run() {
             while (true) {
                     main.display();
                     count = 1;
                     try {
                         Thread.sleep(1000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
    static class Thread2 extends Thread{
        Threading4 main=new Threading4();
        @Override
        public void run() {
            while (true){
                main.display();
                count=0;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
