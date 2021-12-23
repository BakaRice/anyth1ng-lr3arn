package com.ricemarch.accesslambda.example02;

/**
 * 多重继承实验接口1
 */
public interface Carriage {
    default void rock() {
        System.out.println("...rock!");
    }
}
