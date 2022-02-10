package com.mr.mr_admin.jmh;

import com.mr.mr_admin.MrAdminApplication;
import com.mr.mr_admin.feign.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@State(Scope.Thread)
@Slf4j
public class TestListJMH {

       //注入配置configure
    private ConfigurableApplicationContext context;

    private IProductService iProductService;
  /*  private IBizDiscountService couponService;

    private IcouponService icouponService;*/

    public static void main(String[] args) {
        Options build = new OptionsBuilder().include(TestListJMH.class.getName() + "*")
                .warmupIterations(2).measurementIterations(2).forks(1).build();

        try {
            new Runner(build).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    @Setup(Level.Trial)
    public void inint() {
        System.out.println("执行初始化--------------------------");
        String args = "";
        context = SpringApplication.run(MrAdminApplication.class, args);
        iProductService = context.getBean(IProductService.class);
        System.out.println("初始化完成--------------------------");
    }
    @TearDown
    public void finish(){
        context.close();
    }

    @Benchmark
    public void testMysqlTest() {
       // couponService.findList();

      /*  CouponVO couponVO = new CouponVO();
        couponVO.setCpId("174c57d9bb664409929f6617e7289141");

        UserDto userDto = new UserDto();
        userDto.setUmAccount("admin");

        UserDetails detailsTool = new UserDetailsTool(userDto,null);*/

        //icouponService.getUserCoupon(couponVO,detailsTool);
        iProductService.findProductTypeList();
    }

}