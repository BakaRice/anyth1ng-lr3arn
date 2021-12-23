package com.ricemarch.accesslambda.example02;

public abstract class ExampleTest01 implements Carriage, Jukebox {
    @Override
    public void rock() {
        Carriage.super.rock();
    }

    public abstract void rock1();

    /*
    com.ricemarch.accesslambda.example02.ExampleTest01
     inherits unrelated defaults for rock() from
      types com.ricemarch.accesslambda.example02.Carriage and com.ricemarch.accesslambda.example02.Jukebox
     */
}
