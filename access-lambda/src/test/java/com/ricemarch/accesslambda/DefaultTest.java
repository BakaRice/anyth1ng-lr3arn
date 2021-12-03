package com.ricemarch.accesslambda;

import org.junit.jupiter.api.Test;

/**
 * @author tanwentao
 * @since 2021/11/25
 */

public class DefaultTest {

    @Test
    public void parentDefaultUsed() {
        Parent parent = new ParentImpl();
        parent.welcome();
        assert "Parent:Hi!".equals(parent.getLastMessage());
    }
}
