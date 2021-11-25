package com.ricemarch.accesslambda.dto;

/**
 * @author tanwentao
 * @since 2021/11/24
 */

public class TwoTuple<A, B> {

    public final A firsrt;
    public final B second;

    public TwoTuple(A firsrt, B second) {
        this.firsrt = firsrt;
        this.second = second;
    }

    @Override
    public String toString() {
        return "TwoTuple{" +
                "firsrt=" + firsrt +
                ", second=" + second +
                '}';
    }
}
