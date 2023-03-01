package com.wang.felixshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FelixShopApplication {

    public static void main(String[] args) {

        ListNode s = null;

        System.out.println("修改");
        SpringApplication.run(FelixShopApplication.class, args);
    }

      public class ListNode {
        int val;
        ListNode next = null;
      }

}
