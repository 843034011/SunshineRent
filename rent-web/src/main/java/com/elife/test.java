package com.elife;

import java.util.UUID;

public class test {
    public static void main(String[] args) {
        String orderId = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(orderId);
        System.out.println(orderId.length());
    }
}
