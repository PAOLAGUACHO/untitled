package com.cydeo.utilites;

public class Browser_util {
    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
