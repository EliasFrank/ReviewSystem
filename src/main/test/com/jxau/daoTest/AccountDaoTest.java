package com.jxau.daoTest;

import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.domain.Game;
import com.jxau.domain.User;
import com.jxau.domain.UserApply;
import com.jxau.service.SelectService;
import com.jxau.service.UpdateSrvice;
import net.sf.json.JSONArray;
import org.junit.Test;
import java.util.Date;

import java.util.List;

public class AccountDaoTest {
    @Test
    public void test01() {
       // new AccountDaoImpl().selectAllCheckUser();
        List<Game> list =  new AccountDaoImpl().selectAllGames();
        System.out.println(list);
    }

    @Test
    public void test11() {
        String[] s = {"1", "2"};
        new UpdateSrvice().checkAddExpert(s, "1");
    }

    @Test
    public void nmsl() {
        new AccountDaoImpl().resetPwd("5");
    }

    @Test
    public void test10() {
        new AccountDaoImpl().delUser("10");
    }

    @Test
    public void chsl() {
        List<User> list =  new AccountDaoImpl().getAllUsers();
        System.out.println(list);
    }

    @Test
    public void test02() {
        User user = new User();
        user.setNumber("2018162");
        user.setPassword("HL04ch88*");
        User select = new AccountDaoImpl().selectUser(user);
        System.out.println(select);
    }

    @Test
    public void test03() {
        List<UserApply> list =  new AccountDaoImpl().selectUserApply();
        System.out.println(list);
    }
    @Test
    public void test05() {
        new AccountDaoImpl().agreeApply(24);
    }
    @Test
    public void test06() {
        JSONArray choices = JSONArray.fromObject(SelectService.selectChoose());
        System.out.println(choices);
    }

    @Test
    public void test07() {
        System.out.println(new AccountDaoImpl().selectExpert());
    }

}
