package com.example.design.singleton;

/**
 * 静态内部类(线程安全)
 */
public class Singleton_04 {


    private static class SingletonHolder {
        private static Singleton_04 instance = new Singleton_04();
    }

    private Singleton_04() {
    }

    public static Singleton_04 getInstance() {
        return SingletonHolder.instance;
    }

}
