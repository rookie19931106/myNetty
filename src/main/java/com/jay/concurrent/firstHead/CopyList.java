package com.jay.concurrent.firstHead;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author jay
 * @date 2019/8/28 23:46
 * 演示多线程下的CopyOnWriteArrayList的迭代器弱一致性
 */
public class CopyList {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread thread1 = new Thread(() ->{
           arrayList.set(1,"baba");
           arrayList.remove(2);
           arrayList.remove(3);
        });

        //保证在线程前获取迭代器
        Iterator<String> iterator = arrayList.iterator();
        thread1.start();

        thread1.join();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
