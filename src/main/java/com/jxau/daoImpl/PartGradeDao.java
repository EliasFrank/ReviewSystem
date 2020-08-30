package com.jxau.daoImpl;

import com.jxau.domain.PartGrade;
import com.jxau.myUtils.Util;

public class PartGradeDao {

	public static boolean insert(PartGrade p) {
		String sql = "insert into partGrade value(null,?,?,?,?,?)";
		Object[] params = {
				p.getPartgrade(),
				p.getPartexplain(),
				p.getPartflag(),
				p.getExpertId(),
				p.getItemId()
		};
		return Util.executeUpdate(sql, params);
	}
	
}
