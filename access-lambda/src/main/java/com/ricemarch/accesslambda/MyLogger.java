package com.ricemarch.accesslambda;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author tanwentao
 * @since 2021/11/25
 */

public class MyLogger {

    public void debug(Supplier<String> message) {

        if (message.get().startsWith("HI")) {
            System.out.println("[HI] " + message.get());
        } else {
            System.out.println("[NO HI]" + message.get());
        }
    }
    // void error(Supplier<String> message);

}
