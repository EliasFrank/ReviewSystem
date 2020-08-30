package com.jxau.daoTest;

import com.jxau.daoImpl.GradesImpl;
import com.jxau.domain.GradeRank;
import org.junit.Test;

import java.util.List;

public class GradeTest {
    @Test
    public void test1() {
        List<GradeRank> list = new GradesImpl().getGrades(2);
        System.out.println(list);
    }
}
