package spring.bai14;

import java.util.*;


public class Threading4 {
    public static String key = null;

    public static void main(String[] args) {
        Map<String, String> add = new HashMap<String, String>();
        add.put("Monday", "Thu 2");
        add.put("Tuesday", "Thu 3");
        add.put("Wednesday", "Thu 4");
        add.put("Thursday", "Thu 5");
        add.put("Friday", "Thu 6");
        add.put("Saturday", "Thu 7");
        add.put("Sunday", "Chu nhat");
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (key != null) {
                        String value = add.get(key);
                        System.out.println(value);
                        key = null;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (key == null) {
                        int index = new Random().nextInt(7);
                        Set keys = add.keySet();
                        List<String> ki = new ArrayList<>(keys);
                        key = ki.get(index);
                        System.out.println(key);
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}



