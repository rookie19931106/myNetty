package com.jay.concurrent.firstHead;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author jay
 * @date 2019/8/26 23:09
 * 统计0的个数
 */
public class Atomic {

    private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] arrayOne = new Integer[]{0,1,2,3,0,5,6,56,0};
    private static Integer[] arrayTwo = new Integer[]{10,1,2,3,0,5,6,0,56,0};

    public static void main(String[] args) throws Exception{

        //线程1统计1线程0的个数
        Thread thread1 = new Thread(() ->{
            int length = arrayOne.length;
            for (int i = 0; i < length ; i++) {
                if (arrayOne[i].intValue() == 0){
                    atomicLong.incrementAndGet();
                }
            }
        });

        Thread thread2 = new Thread(() ->{
           int size = arrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (arrayTwo[i].intValue() == 0){
                    atomicLong.incrementAndGet();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("count 0:" + atomicLong.get());
    }

}
