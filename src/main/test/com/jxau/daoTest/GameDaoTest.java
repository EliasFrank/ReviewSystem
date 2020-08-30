package com.jxau.daoTest;

import com.jxau.daoImpl.GameDaoImpl;
import com.jxau.daoImpl.GamesDao;
import org.junit.Test;

public class GameDaoTest {
    @Test
    public void test01() throws  Exception{
        System.out.println(GamesDao.select_checked(4));
    }

    @Test
    public void test02() {
        System.out.println(new GameDaoImpl().getItemId());
    }

    @Test
    public void test03() {
        System.out.println(new GameDaoImpl().getGames());
    }
    @Test
    public void test04() {
        System.out.println(new GameDaoImpl().getParts("1"));
    }
}
