package com.ricemarch.accesslambda;

/**
 * @author tanwentao
 * @since 2021/11/25
 */

public interface Parent {

    void message(String body);

    default void welcome() {
        message("Parent:Hi!");
    }

    String getLastMessage();
}
