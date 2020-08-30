package com.jxau.dao;

import com.jxau.domain.Grade;
import com.jxau.domain.GradeRank;
import com.jxau.domain.PartGrade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Grades {
    public List<GradeRank> getGrades(int id);

    void addPartGrades(ArrayList<PartGrade> partGrades, Connection connection) throws SQLException;

    void addTotalGrades(Grade grade, Connection connection) throws SQLException;
}
