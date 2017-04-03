package org.apache.hadoop.yarn.sls.utils;

import org.apache.hadoop.yarn.util.Clock;
import org.apache.hadoop.yarn.util.SystemClock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ScaleClock extends com.codahale.metrics.Clock implements Clock {
    private final long scaleFactor;
    private final long origin;

    public ScaleClock(long scaleFactor) {
        this.scaleFactor = scaleFactor;
        origin = System.currentTimeMillis();
    }

    @Override
    public long getTime() {
        return (System.currentTimeMillis() - origin) * scaleFactor;
    }

    @Override
    public long getTick() {
       return System.nanoTime() * scaleFactor;
    }
}