package com.wang.couponapp;

import com.wang.couponapp.service.CouponService;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ExecutionException;

/**
 * @Author：wp
 * @Package：com.wang.couponapp
 * @Project：java-Core
 * @name：JMHSpringbootTest
 * @Date：2023/4/13 14:43
 * @Filename：JMHSpringbootTest
 */
@State(Scope.Thread)
public class JMHSpringbootTest {

    private ConfigurableApplicationContext context;
    private CouponService couponService;


    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(JMHSpringbootTest.class.getName() + ".*")
                .warmupIterations(2).measurementIterations(2)
                .forks(1).build();
        new Runner(options).run();
    }

    /**
     * setup初始化容器的时候只执行一次
     */
    @Setup(Level.Trial)
    public void init(){
        String arg = "";
        context = SpringApplication.run(CouponAppApplication.class,arg);
        couponService = context.getBean(CouponService.class);
    }


    /**
     * benchmark执行多次，此注解代表触发我们所要进行基准测试的方法
     */
    @Benchmark
    public void test() throws ExecutionException {
        System.out.println(couponService.getCouponList());
    }



    @Benchmark
    public void testDB(){
        System.out.println(couponService.loadCoupon(1));
    }




}
