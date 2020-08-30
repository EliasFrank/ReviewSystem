package com.jxau.utilTest;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mess {
    public static void main(String[] args) {
        Date date = new Date(1111111111);
        System.out.println(date);
    }

    @Test
    public void test() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        System.out.println(date);
    }

    @Test
    public void test03() {
        boolean flag = checkTime("2020-01-18", "2020-01-15 2020-01-17");
        System.out.println(flag);
    }
    private boolean checkTime(String gameDate, String submitTime) {
        String startTime = submitTime.split(" ")[0];
        String endTime = submitTime.split(" ")[1];
        int result = gameDate.compareTo(startTime);
        int result2 = gameDate.compareTo(endTime);
        if(result >= 0 && result2 <= 0)
            return true;
        return false;
    }
}
