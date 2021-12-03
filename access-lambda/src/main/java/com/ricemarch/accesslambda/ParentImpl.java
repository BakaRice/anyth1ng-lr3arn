package com.ricemarch.accesslambda;

/**
 * @author tanwentao
 * @since 2021/11/25
 */

public class ParentImpl implements Parent {

    String lastMsg;

    @Override
    public void message(String body) {
        System.out.println(body);
        lastMsg = body;
    }

    @Override
    public String getLastMessage() {
        return lastMsg;
    }
}
