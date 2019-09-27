package com.elife;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class test {
    public static void main(String[] args) {
        String timeStr= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(timeStr.replaceAll("-",""));

    }

}
