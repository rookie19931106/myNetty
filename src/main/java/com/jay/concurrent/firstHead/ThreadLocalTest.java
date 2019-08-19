package com.jay.concurrent.firstHead;

/**
 * @author jay
 * @date 2019/8/19 22:19
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(String str){
        //打印当前线程本地内存中的localVariable变量的值
        System.out.println(str+":"+threadLocal.get());
        //清除当前线程本地内存中的localVariable变量
        threadLocal.remove();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() ->{
            //设置线程One中本地变量localVariable的值
            threadLocal.set("ThreadLocal1 local variable");
            print("thread1");
            System.out.println("thread1 remove after:"+threadLocal.get());
        });

        Thread thread2 = new Thread(() ->{
            //设置线程One中本地变量localVariable的值
            threadLocal.set("ThreadLocal2 local variable");
            print("thread2");
            System.out.println("thread2 remove after:"+threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
