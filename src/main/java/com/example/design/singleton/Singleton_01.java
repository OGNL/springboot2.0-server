package com.example.design.singleton;

/**
 * 单例模式
 * 懒汉模式（线程不安全）
 */
public class Singleton_01 {

    private static Singleton_01 instance;


    private Singleton_01(){
    }

    public static Singleton_01 getInstance() {
        if (instance != null) return instance;
        instance = new Singleton_01();
        return  instance;
    }
}
