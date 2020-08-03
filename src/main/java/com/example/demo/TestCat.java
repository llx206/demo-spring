package com.example.demo;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;

import java.util.Random;

public class TestCat {

    public static void main(String[] args) {
//        Transaction t = Cat.newTransaction("TEST1", "test.method");
//        Cat.logEvent("Method_test1", "good");
//        Cat.logEvent("Method_event1", "bad");
//        int nextInt = new Random().nextInt(3);
//        if (nextInt % 2 == 0) {
//            t.setStatus(Transaction.SUCCESS);
//        } else {
//            t.setStatus(String.valueOf(nextInt));
//        }
//        t.complete();
//        System.out.println("ok...");
        while (true) {
            try {

                Transaction t = Cat.newTransaction("TEST1", "test.method");
                Cat.logEvent("Method_test1", "good");
                Cat.logEvent("Method_event1", "bad");
                int nextInt = new Random().nextInt(3);
                if (nextInt % 2 == 0) {
                    t.setStatus(Transaction.SUCCESS);
                } else {
                    t.setStatus(String.valueOf(nextInt));
                }
                t.complete();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
