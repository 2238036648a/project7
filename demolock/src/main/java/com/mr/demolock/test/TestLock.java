package com.mr.demolock.test;

public class TestLock {

    public static void main(String[] args) {

        Thread t1 = new Thread(new runA());
        Thread t2 = new Thread(new runB());

        t1.start();
        t2.start();

    }

    private static Object A = new Object();
    private static Object B = new Object();

    public static class runA implements Runnable{

        @Override
        public void run() {
            synchronized (A){
                System.out.println("获取A锁成功");
                try {
                    Thread.sleep(3);
                    System.out.println("RunA 尝试获取B锁");
                    synchronized (B){
                        System.out.println("获取B锁成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public static class runB implements Runnable {

        @Override
        public void run() {

            synchronized (B) {
                System.out.println("获取B锁成功");
                try {
                    Thread.sleep(3);
                    System.out.println("RunB 尝试获取A锁");
                    synchronized (A) {
                        System.out.println("获取A锁成功");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
