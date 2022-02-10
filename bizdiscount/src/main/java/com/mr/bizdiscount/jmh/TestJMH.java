//package com.mr.bizdiscount.jmh;
//
//
//import com.mr.bizdiscount.BizdiscountApplication;
//import com.mr.bizdiscount.service.impl.CouponServiceImpl;
//import lombok.extern.slf4j.Slf4j;
//import org.openjdk.jmh.annotations.*;
//import org.openjdk.jmh.runner.Runner;
//import org.openjdk.jmh.runner.RunnerException;
//import org.openjdk.jmh.runner.options.Options;
//import org.openjdk.jmh.runner.options.OptionsBuilder;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//
//@State(Scope.Thread)
//@Slf4j
//public class TestJMH {
//
//    //注入配置configure
//    private ConfigurableApplicationContext context;
//
//    private CouponServiceImpl couponService;
//
//
//    public static void main(String[] args) {
//        Options build = new OptionsBuilder().include(TestJMH.class.getName() + "*")
//                .warmupIterations(2).measurementIterations(2).forks(1).build();
//
//        try {
//            new Runner(build).run();
//        } catch (RunnerException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Setup(Level.Trial)
//    public void inint(){
//        log.info("执行初始化--------------------------");
//        String args = "";
//         context = SpringApplication.run(BizdiscountApplication.class, args);
//         couponService = context.getBean(CouponServiceImpl.class);
//        log.info("初始化完成--------------------------");
//    }
//
//    @Benchmark
//    public void testMysqlTest(){
//        couponService.couponlist();
//    }
//}
