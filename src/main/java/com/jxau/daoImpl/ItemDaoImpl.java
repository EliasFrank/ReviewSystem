package com.jxau.daoImpl;

import com.jxau.domain.*;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ItemDaoImpl {
    public void addItem(Items items, Connection con) throws Exception{
        String sql  = "INSERT INTO `items` " +
                "(`itemId`, `gameId`, `userId`, `itemflag`, `submitTime`, `itemName`) " +
                "VALUES (?, ?, ?, 1, ?, ?)";

        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, items.getItemId());
            pstmt.setInt(2, items.getGameId());
            pstmt.setInt(3, items.getUserId());
            pstmt.setString(4, items.getSubmitTime());
            pstmt.setString(5, items.getItemName());

            pstmt.execute();
        }catch (Exception e){
            throw new Exception();
        }
    }

    public void addDocument(Document document, Connection con) throws Exception{
        String sql  = "INSERT INTO `document` " +
                "(`itemId`, `path`, `introduce`, `documentflag`) " +
                "VALUES (?, ?, ?, 1)";
        try{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, document.getItemId());
            pstmt.setString(2, document.getPath());
            pstmt.setString(3, document.getIntroduce());

            pstmt.execute();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception();
        }
    }

    public boolean selectIsPost(int userId, int gameId) {
        Connection connection = new MySQLConnection().getConnection();
        boolean flag = true;
        String sql = "SELECT count(*) FROM `items`  " +
                "where gameId = ? " +
                "and userId=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, gameId);
            pstmt.setInt(2,userId);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            if(rs.getInt("count(*)") == 0){
                flag = false;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return flag;
    }

    public String selectGameTime(int gameId) {
        Connection connection = new MySQLConnection().getConnection();
        String time = "";
        String sql = "SELECT startTime, endTime from games where gameId = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, gameId);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                time = rs.getString("startTime") + " " + rs.getString("endTime");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return time;
    }

    public ArrayList<MyItems> selectMyItems(int userId) {
        ArrayList<MyItems> items = new ArrayList<MyItems>();

        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "select i.itemId, i.itemName, g.gameName, u.`name`  " +
                "from items i, `user` u, games g " +
                "where i.userId = ? and  i.userId = u.userId " +
                "and i.gameId = g.gameId";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                MyItems item= new MyItems();
                item.setGameName(rs.getString("g.gameName"));
                item.setItemName(rs.getString("i.itemName"));
                item.setUserName(rs.getString("u.name"));
                item.setItemId(rs.getInt("i.itemId"));

                items.add(item);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        return items;
    }

    public ArrayList<CheckItem> getCheckItems(int userId) {
        Map<Integer,CheckItem> items = new HashMap<Integer,CheckItem>();

        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "select distinct ci.*, g.totalGrade, c.isUsed from check_item ci, `check` c, grade g " +
                "where c.userId = ? and c.itemId = ci.itemId and IF(g.itemId = c.itemId, 1, g.itemId = 0) " +
                "and c.isCheck = 1";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                CheckItem item= new CheckItem();
                item.setGameId(rs.getInt("gameId"));
                item.setUserId(rs.getInt("userId"));
                item.setItemId(rs.getInt("itemId"));
                item.setGrade(rs.getDouble("totalGrade"));
                item.setGameName(rs.getString("gameName"));
                item.setItemName(rs.getString("itemName"));
                item.setUserName(rs.getString("name"));
                item.setIsUsed(rs.getInt("isUsed"));
                items.put(rs.getInt("itemId"), item);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        ArrayList<CheckItem> list = new ArrayList<>();
        Set<Map.Entry<Integer, CheckItem>> set =  items.entrySet();
        Iterator<Map.Entry<Integer, CheckItem>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, CheckItem> entry = iterator.next();
            list.add(entry.getValue());
        }
        return list;
    }

    public Map<Integer, Object> getItems(String itemId) {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        Items items = new Items();
        String introduce = null;
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT i.itemId, i.itemName, introduce FROM items i , document d " +
                "where i.itemId = ? and i.itemId=d.itemId";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, itemId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                items.setItemName(rs.getString("i.itemName"));
                items.setItemId(rs.getInt("i.itemId"));
                introduce = rs.getString("introduce");
            }
            map.put(1, items);
            map.put(2, introduce);
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        return map;
    }

    public String getItemsPath(int itemId) {
        Connection connection = new MySQLConnection().getConnection();
        String annex =  null;
        String sql = "SELECT path from document where itemId=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, itemId);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                annex = rs.getString("path");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return annex;
    }

    public void setItemFlag(int userId, int itemId) throws SQLException {
        Connection connection = new MySQLConnection().getConnection();
        String sql = "update `check` set isCheck=1 where userId=? and itemId=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, userId);
            pstmt.setInt(2, itemId);

            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            throw  e;
        }finally {
            MySQLConnection.close(connection);
        }
    }

    public ArrayList<ResultRank> getResult(String id) {
        ArrayList<ResultRank> ranks = new ArrayList<ResultRank>();
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT AVG(totalGrade) grades,  itemName, `name` " +
                "FROM `grade` g, check_item c " +
                "where g.gameId = ?  " +
                "and g.itemId = c.itemId " +
                "GROUP BY g.itemId " +
                "ORDER BY grades DESC;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            int rank = 1;
            while(rs.next()) {
                ResultRank grade = new ResultRank();
                grade.setGrade(rs.getDouble("grades"));
                grade.setItemName(rs.getString("itemName"));
                grade.setUserName(rs.getString("name"));
                grade.setRank(rank++);
                ranks.add(grade);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        return ranks;
    }

    public Map<String,  ArrayList<String>> getExplain(String id) {
        Map<String, ArrayList<String>> map = new HashMap<String,  ArrayList<String>>();
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT `explain`, itemName " +
                "FROM `grade` g, check_item c " +
                "where g.gameId = ? " +
                "and g.itemId = c.itemId";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                String itemName = rs.getString("itemName");
                if(map.containsKey(itemName)){
                    map.get(itemName).add(rs.getString("explain"));
                }else{
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(rs.getString("explain"));
                    map.put(itemName, temp);
                }
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭数据库连接
            MySQLConnection.close(connection);
        }
        return map;
    }
}
