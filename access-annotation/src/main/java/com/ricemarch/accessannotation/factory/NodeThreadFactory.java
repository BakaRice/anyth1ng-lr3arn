package com.ricemarch.accessannotation.factory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tanwentao
 * @since 2021/10/20
 */
@Slf4j
public class NodeThreadFactory implements ThreadFactory {

    private final String namePrefix;
    private final AtomicInteger nextId = new AtomicInteger(1);

    NodeThreadFactory(String whatFeaturOfGroup) {
        namePrefix = "From NodeThreadFactory's" + whatFeaturOfGroup + "-worker-";
    }

    @Override
    public Thread newThread(Runnable task) {
        String name = namePrefix + nextId.getAndIncrement();
        Thread thread = new Thread(null, task, name, 0, false);
        log.info("{}", thread.getName());
        return thread;
    }
}
