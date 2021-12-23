package com.ricemarch.accesslambda.example02;

public interface Jukebox {
    default void rock() {
        System.out.println("...rock!");
    }


}
