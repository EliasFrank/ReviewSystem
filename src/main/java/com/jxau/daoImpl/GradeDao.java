package com.jxau.daoImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.jxau.domain.Grade;
import com.jxau.myUtils.Util;

public class GradeDao {
	public static boolean insert(Grade g) {
		String sql = "insert into grade values(?,?,?,null,?,?)";
		Object[] params= {
				g.getItemId(),
				g.getTotalGrade(),
				g.getUserId(),
				g.getGameId(),
				g.getExpertId()
		};
		return Util.executeUpdate(sql, params);
	}

	public static ArrayList<Grade> select_ByuserId(int userId) throws Exception {
		String sql = "select * from grade where userId=?";
		Object[] params = {userId};
		ArrayList<Grade> grades = new ArrayList<Grade>();
		ResultSet rs = Util.executeQuery(sql, params);
		while(rs.next()) {
			Grade grade = new Grade(
					rs.getInt("itemId"),
					rs.getDouble("totalGrade"),
					rs.getInt("userId"),
					rs.getInt("gradeId"),
					rs.getInt("gameId"),
					rs.getInt("expertId")
						);
			grades.add(grade);
		}
		rs.close();
		Util.pstmt.close();
		return grades;
	}
}
