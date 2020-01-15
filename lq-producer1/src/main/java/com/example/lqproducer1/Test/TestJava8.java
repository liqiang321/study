package com.example.lqproducer1.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestJava8 {


    public static void main(String[] args) {
      /*  List<String> list = Lists.newArrayList();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.stream().forEach(string ->{
            System.out.println(string);
        });*/

        HashMap<String, String> map = Maps.newHashMap();
        map.put("1", "张三");
        map.put("2", "李四");
        map.put("3", "王五");
        HashMap<String, String> map2 = Maps.newHashMap();
        map2.put("4", "德玛西亚");
        map2.put("5", "索瑞玛");
        map2.put("6", "艾欧尼亚");
        ArrayList<Map> list1 = Lists.newArrayList();
        list1.add(map);
        list1.add(map2);
        list1.forEach(map1 -> {map1.forEach((k,v)-> System.out.println(v));});
        System.out.println("-----分割线------");
        list1.forEach(map1 -> {map1.forEach((k,v)-> System.out.println(k+"----"+v));});
    }

    public void testList(List<String> list) {
        list.stream().forEach(string ->{
            System.out.println(string);
        });
    }

    public void testMap(Map map) {
    }

}
