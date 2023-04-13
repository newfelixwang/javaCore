package com.wang.couponapp;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @Author：wp
 * @Package：com.wang.couponapp
 * @Project：java-Core
 * @name：JMHTest
 * @Date：2023/4/13 14:37
 * @Filename：JMHTest
 */
public class JMHTest {


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().warmupIterations(2).measurementIterations(2)
                .forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    public void testStringAdd() {
        String s = "";
        for (int i = 0; i < 10; i++) {
            s += i;
        }
    }

    @Benchmark
    public void testStringBuild() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            b.append(i);
        }
        b.toString();
    }
}
