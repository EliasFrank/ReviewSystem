package com.jxau.serviceTest;

import com.jxau.domain.Document;
import com.jxau.domain.Items;
import com.jxau.service.AddService;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddServiceTest {
    @Test
    public void test01() {
        Items items = new Items();
        items.setItemId(6);
        items.setGameId(1);
        items.setIsSelected("no");
        items.setItemName("张三");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        items.setSubmitTime(date);
        items.setUserId(4);

        Document document = new Document();
        document.setDecumentflag(1);
        document.setIntroduce("introduce");
        document.setItemId(6);
        document.setPath("annex");

        AddService.addItem(items, document);
    }
}
