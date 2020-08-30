package com.jxau.daoImpl;

import com.jxau.domain.Document;
import com.jxau.myUtils.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DocumentDao {

	public static boolean insert(Document doc) {
		String sql = "insert into  document values(?,?,null,?)";
		Object[] params = {
				doc.getItemId(),
				doc.getPath(),
				doc.getDecumentflag()
		};
		return Util.executeUpdate(sql, params);
	
	}

	public static ArrayList<Document> select_all() throws Exception {
		String sql ="select * from document";
		ArrayList<Document> dous = new ArrayList<Document>();
		Object[] params = {};
		ResultSet rs =  Util.executeQuery(sql, params);
		while(rs.next()) {
			Document d = new Document(
					rs.getInt("itemId"), 
					rs.getString("path"), 
					rs.getString("introduce"),
					rs.getInt("documentId"), 
					Integer.parseInt(rs.getString("decumentflag")));
			dous.add(d);
		}
		rs.close();
		Util.pstmt.close();
		return dous;
	}
	
	public static Document select_byid(int id) throws Exception {
		String sql ="select * from document where itemId = ?";
		Object[] params = {id};
		Document d =null;
		ResultSet rs =  Util.executeQuery(sql, params);
		if(rs.next()) {
			 	d = new Document(
					rs.getInt("itemId"), 
					rs.getString("path"), 
					rs.getString("introduce"),
					rs.getInt("documentId"),
						Integer.parseInt(rs.getString("documentflag")))
					;
		}
		rs.close();
		Util.pstmt.close();
		return d;
	}
}
