package com.example.design.singleton;

/**
 * 懒汉模式（线程安全）
 */
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02(){
    }

    public static synchronized Singleton_02 getInstance() { //给方法加锁
        if (instance != null) return instance;
        instance = new Singleton_02();
        return  instance;
    }

}
