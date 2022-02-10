package com.mr.mr_admin.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TestJMH {

    public static void main(String[] args) {
        //创建JVM builder 设置 预热次数  测试次数 以及 重复预测和预测次数
        Options options = new OptionsBuilder().warmupIterations(2).measurementIterations(2).forks(1).build();


        //运行
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    @Benchmark
    public void testStr(){
        String str="";
        for(int i = 0; i < 10; i++ ){
            str += i;
        }
    }

    @Benchmark
    public void testStrigBuffer(){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 10; i++ ){
            buffer.append(i);
        }
    }


    @Benchmark
    public void testList(){
        List<Object> list = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            list.add(i);
        }
    }

    @Benchmark
    public void testMap(){
        HashMap<Object, Object> hashMap = new HashMap<>();
        for(int i = 0; i < 10; i++ ){
            hashMap.get(i);
        }
    }


    @Benchmark
    public void testTreeMap(){
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        for(int i = 0; i < 10; i++ ){
            treeMap.get(i);
        }
    }
}
