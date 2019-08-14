package com.yw.util;

import com.yw.function.Procedure;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author yuanwei on 2019/8/12
 **/
@Slf4j
public final class Timing {

    private Timing() {
    }

    /**
     * 对指定操作进行计时监控，并返回操作产生的结果
     *
     * @param supplier 操作提供者，有返回值
     * @param recorder 耗时记录者，它可以对耗时打监控，也可以记日志
     * @param <T>      返回类型
     * @return 返回操作的执行结果
     */
    public static <T> T run(Supplier<T> supplier, Consumer<Long> recorder) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        if (recorder != null) {
            recorder.accept(elapsed);
        }
        return result;
    }

    public static <T> T run(Supplier<T> supplier) {
        long start = System.currentTimeMillis();
        T result = supplier.get();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        log.info("cost {}ms", elapsed);
        return result;
    }

    /**
     * 对指定操作进行计时监控
     *
     * @param procedure 操作提供者，无返回值
     * @param recorder  耗时记录者，它可以对耗时打监控，也可以记日志
     */
    public static void run(Procedure procedure, Consumer<Long> recorder) {
        long start = System.currentTimeMillis();
        procedure.invoke();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        if (recorder != null) {
            recorder.accept(elapsed);
        }
    }

    public static void run(Procedure procedure) {
        long start = System.currentTimeMillis();
        procedure.invoke();
        long end = System.currentTimeMillis();
        long elapsed = end - start;
        log.info("cost {}ms", elapsed);
    }
}
