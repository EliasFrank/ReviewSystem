package com.jxau.daoImpl;

import com.jxau.dao.Grades;
import com.jxau.domain.Grade;
import com.jxau.domain.GradeRank;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradesImpl implements Grades {
    @Override
    public List<GradeRank> getGrades(int id) {
        ArrayList<GradeRank> grades = new ArrayList<GradeRank>();

        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT AVG(totalGrade) grades, itemName, `name` " +
                "FROM `grade` g, items i, `user` u " +
                "where g.gameId = ? " +
                "and g.itemId = i.itemId " +
                "and i.userId = u.userId " +
                "GROUP BY g.itemId  " +
                "ORDER BY grades DESC;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            int rank = 1;
            while(rs.next()) {
                GradeRank grade = new GradeRank();
                grade.setGrade(rs.getDouble("grades"));
                grade.setItemName(rs.getString("itemName"));
                grade.setUserName(rs.getString("name"));
                grade.setRank(rank++);

                grades.add(grade);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        return grades;
    }
}
