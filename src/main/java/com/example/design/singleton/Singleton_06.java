package com.example.design.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS「AtomicReference」(线程安全)
 */
public class Singleton_06 {

    private static final AtomicReference<Singleton_06> INSTANCE = new AtomicReference<>();

    private Singleton_06(){

    }

    public static final Singleton_06 getInstance(){
        for (; ; ) {
            Singleton_06 instance = INSTANCE.get();
            if(instance != null) return instance;
            INSTANCE.compareAndSet(null, new Singleton_06());
            return INSTANCE.get();
        }
    }



}
