package com.jay.concurrent.firstHead;

/**
 * @author jay
 * @date 2019/8/26 22:24
 */
public class ThreadLocalRandom {
    public static void main(String[] args) {
        java.util.concurrent.ThreadLocalRandom threadLocalRandom = java.util.concurrent.ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(threadLocalRandom.nextInt());

        }
    }
}
