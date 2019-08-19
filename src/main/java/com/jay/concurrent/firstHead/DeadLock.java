package com.jay.concurrent.firstHead;

/**
 * @author jay
 * @date 2019/8/19 21:58
 * 形成死锁的4个条件
 * 1 互斥条件
 * 2 请求并持有条件
 * 3 不可剥夺条件
 * 4 环路等待条件
 */
public class DeadLock {
    private static Object objectA = new Object();
    private static Object objectB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
           synchronized (objectA){
               try {
                   System.out.println(Thread.currentThread()+" get objectA");
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread()+"waiting for objectB");
               synchronized (objectB){
                   System.out.println(Thread.currentThread()+"got objectB");
               }
           }
        });

        Thread thread2 = new Thread(() ->{
            synchronized (objectB){
                try {
                    System.out.println(Thread.currentThread()+" get objectB");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"waiting for objectA");
                synchronized (objectA){
                    System.out.println(Thread.currentThread()+"got objectA");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
