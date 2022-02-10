package com.mr.rsm.controller;

import com.mr.rsm.vo.MenuVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("management")
public class ManagementCotroller {


    @GetMapping("login")
    public String toLogin(){
        return null;
    }

    @GetMapping("index")
    public ModelAndView toIndex(){
        List<MenuVo> menulist = new ArrayList<>();
        //左侧导航区域 产品
        MenuVo mv1 = new MenuVo(1,"产品管理","");
        MenuVo mv2 = new MenuVo(2,"商品管理","/product/page");
        MenuVo mv3 = new MenuVo(3,"商品类型管理","/product/type/page");
        List<MenuVo> listp = new ArrayList<>(2);
        listp.add(mv2);
        listp.add(mv3);
        mv1.setChildList(listp);
        //左侧导航区域 营销
        MenuVo mv11 = new MenuVo(4,"营销管理","");
        MenuVo mv21 = new MenuVo(5,"优惠券管理","/coupon/page");
        MenuVo mv31 = new MenuVo(6,"优惠券类型管理","/coupon/type/page");
        List<MenuVo> listc = new ArrayList<>(2);
        listc.add(mv21);
        listc.add(mv31);
        mv11.setChildList(listc);
        //左侧导航区域 系统 user
        MenuVo mv12 = new MenuVo(7,"系统管理","");
        MenuVo mv22 = new MenuVo(8,"用户管理","/user/page");
        MenuVo mv32 = new MenuVo(9,"角色管理","/user/type/page");
        MenuVo mv42 = new MenuVo(10,"权限管理","/user/type/page");
        List<MenuVo> listu = new ArrayList<>(3);
        listu.add(mv22);
        listu.add(mv32);
        listu.add(mv42);
        mv12.setChildList(listu);

        //左侧导航区域 客服
        MenuVo mv13 = new MenuVo(11,"客服管理","");
        MenuVo mv23 = new MenuVo(12,"订单管理","/order/page");
        List<MenuVo> listo = new ArrayList<>(2);
        listo.add(mv23);
        mv13.setChildList(listo);

        //放到整体list里面
        menulist.add(mv1);
        menulist.add(mv11);
        menulist.add(mv12);
        menulist.add(mv13);
        //放到modelandview  key value
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data",menulist);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
