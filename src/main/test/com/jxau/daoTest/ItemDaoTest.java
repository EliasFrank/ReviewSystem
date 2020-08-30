package com.jxau.daoTest;

import com.jxau.daoImpl.ItemDaoImpl;
import com.jxau.domain.Items;
import com.jxau.service.SelectService;
import org.junit.Test;

import java.util.Map;

public class ItemDaoTest {
    @Test
    public void test01() {
        System.out.println(new ItemDaoImpl().selectIsPost(4, 2));
    }

    @Test
    public void test02() {
        String time = new ItemDaoImpl().selectGameTime(1);
        System.out.println(time);
    }

    @Test
    public void test03() {
        System.out.println(new ItemDaoImpl().selectMyItems(4).get(0).getItemName());
    }

    @Test
    public void test04() {
        System.out.println(new ItemDaoImpl().getCheckItems(1));
    }
    @Test
    public void test05() {
        Map<Integer, Object> map = SelectService.getItem("1");
        Items items = (Items) map.get(1);
        System.out.println(items.getItemName());
    }
    @Test
    public void test06() {
        System.out.println(new ItemDaoImpl().getItemsPath(1));
    }
}
