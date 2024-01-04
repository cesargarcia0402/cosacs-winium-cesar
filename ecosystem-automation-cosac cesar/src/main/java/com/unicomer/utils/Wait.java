package com.unicomer.utils;
public class Wait {

    private Wait() {
        throw new IllegalStateException("Utility class");
    }
    public static void to(int seconds)  {
        try {
            Thread.sleep((long) seconds *1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
