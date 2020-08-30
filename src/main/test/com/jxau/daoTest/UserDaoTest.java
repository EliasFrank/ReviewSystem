package com.jxau.daoTest;

import com.jxau.daoImpl.UserDao;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test01() throws Exception{
        System.out.println(UserDao.select_byId(3));
    }
}
