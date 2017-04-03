package org.apache.hadoop.yarn.sls.utils;

import org.apache.hadoop.yarn.util.Clock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by jvaudour on 03/04/17.
 */
public class ClockHolder {

    private static final AtomicReference<ScaleClock> INSTANCE = new AtomicReference<>();

    public static void init(ScaleClock clock) {
        INSTANCE.compareAndSet(null,clock);
    }

    public static ScaleClock getInstance() {
        return INSTANCE.get();
    }
}
