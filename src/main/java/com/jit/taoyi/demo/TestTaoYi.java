package com.jit.taoyi.demo;


/*
* 逃逸分析测试
*关闭逃逸分析 -Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
*打开逃逸分析 -Xmx4G -Xms4G -XX:+DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
* */
public class TestTaoYi {
    public static void main(String[] args) {

        long a1 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {

            alloc();

        }

// 查看执行时间

        long a2 = System.currentTimeMillis();

        System.out.println("cost " + (a2 - a1) + " ms");

// 为了方便查看堆内存中对象个数，线程sleep

        try {

            Thread.sleep(1000000);

        } catch (InterruptedException e1) {

            e1.printStackTrace();

        }

    }

    private static void alloc() {

        User user = new User();

    }

    static class User {
        String name;
        int age;
        boolean sex;
    }
}
