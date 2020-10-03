package com.jxau.daoImpl;

import com.jxau.dao.Grades;
import com.jxau.domain.Grade;
import com.jxau.domain.GradeRank;
import com.jxau.domain.PartGrade;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradesImpl implements Grades {
    @Override
    public void addPartGrades(ArrayList<PartGrade> partGrades, Connection connection) throws SQLException {
        String sql = "INSERT INTO `partGrade` (`partgrade`, `partflag`, `expertId`, `itemId`) " +
                "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            for(PartGrade part : partGrades){
                pstmt.setDouble(1,part.getPartgrade());
//                pstmt.setString(2, part.getPartexplain());
                pstmt.setInt(2, part.getPartflag());
                pstmt.setInt(3, part.getExpertId());
                pstmt.setInt(4, part.getItemId());

                pstmt.addBatch();
            }
            pstmt.executeBatch();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    @Override
    public void addTotalGrades(Grade grade, Connection connection) throws SQLException {
        String sql = "INSERT INTO `grade` (`itemId`, `totalGrade`,`explain`, `userId`, `gradeId`, `gameId`, `expertId`) " +
                "VALUES (?, ?, ?, ?, NULL, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,grade.getItemId());
            pstmt.setDouble(2, grade.getTotalGrade());
            pstmt.setString(3, grade.getExplain());
            pstmt.setInt(4, grade.getUserId());
            pstmt.setInt(5, grade.getGameId());
            pstmt.setInt(6, grade.getExpertId());

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        }
    }

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

    public void setIsUsed(String userId, String itemsId) throws SQLException {
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "update `check` set isUsed = 1 where userId = ? and itemId = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, userId);
            pstmt.setString(2, itemsId);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        }
    }
}
