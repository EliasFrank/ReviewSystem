package com.jxau.daoImpl;

import com.jxau.dao.GamesDao;
import com.jxau.domain.Game;
import com.jxau.domain.Part;
import com.jxau.myUtils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class GameDaoImpl implements GamesDao {

    @Override
    public void storeGame(Game game, Connection con, String userId) throws SQLException {
        String sql = "INSERT INTO `games_copy` (`userId`, `gameId`, `gameName`, `welcome`, `type`, `introduction`, `annex`, `startTime`, `endTime`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setInt(1,Integer.parseInt(userId));
        pstmt.setInt(2, game.getGameId());
        pstmt.setString(3, game.getGameName());
        pstmt.setString(4, game.getWelcome());
        pstmt.setString(5, game.getType());
        pstmt.setString(6, game.getIntroduction());
        pstmt.setString(7, game.getAnnex());
        pstmt.setDate(8, game.getStartTime());
        pstmt.setDate(9, game.getEndTime());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void storeParts(Part[] parts, Connection con) throws SQLException {
        String sql = "INSERT INTO `part_copy` (`id`, `partExplain`, `gamesId`, `grade`) VALUES (default, ?, ?, ?)";

        PreparedStatement pstmt = con.prepareStatement(sql);

        for(Part part : parts){
            pstmt.setString(1, part.getExplain());
            pstmt.setInt(2, part.getGameId());
            pstmt.setDouble(3, part.getGrade());

            pstmt.addBatch();
        }
        pstmt.executeBatch();
        pstmt.close();
    }

    @Override
    public ArrayList<Part> getParts(String gameId) {
        ArrayList<Part> parts = new ArrayList<Part>();
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT * from part where gamesId=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,gameId);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Part part = new Part();
                part.setGameId(rs.getInt("gamesId"));
                part.setGrade(rs.getDouble("grade"));
                part.setExplain(rs.getString("partExplain"));
                part.setId(rs.getInt("id"));
                parts.add(part);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return parts;
    }

    @Override
    public void addGame(Game game, Connection connection) throws SQLException {
        String sql = "INSERT INTO `games` (`gameId`, `gameName`, `welcome`, `type`, `introduction`, `annex`, `startTime`, `endTime`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, game.getGameId());
        pstmt.setString(2, game.getGameName());
        pstmt.setString(3, game.getWelcome());
        pstmt.setString(4, game.getType());
        pstmt.setString(5, game.getIntroduction());
        pstmt.setString(6, game.getAnnex());
        pstmt.setDate(7, game.getStartTime());
        pstmt.setDate(8, game.getEndTime());

        pstmt.executeUpdate();
        pstmt.close();
    }

    @Override
    public void addParts(Part[] parts, Connection connection) throws SQLException {
        String sql = "INSERT INTO `part` (`id`, `partExplain`, `gamesId`, `grade`) VALUES (default, ?, ?, ?)";

        PreparedStatement pstmt = connection.prepareStatement(sql);

        for(Part part : parts){
            pstmt.setString(1, part.getExplain());
            pstmt.setInt(2, part.getGameId());
            pstmt.setDouble(3, part.getGrade());

            pstmt.addBatch();
        }
        pstmt.executeBatch();
        pstmt.close();
    }

    @Override
    public int getGameId() {
        int id = 0;
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT MAX(id) FROM `games_copy`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                id = rs.getInt("MAX(gameId)");
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return id + 1;
    }

    public int getItemId() {
        int id = 0;
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT MAX(itemId) FROM `items`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                id = rs.getInt("MAX(itemId)");
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return id + 1;
    }
    @Override
    public Game getGame(int id) {
        return null;
    }

    @Override
    public ArrayList<Game> getGames() {
        ArrayList<Game> games = new ArrayList<Game>();
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT * FROM `games`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Game game = new Game();
                game.setGameId(Integer.parseInt(rs.getString("gameId")));
                game.setWelcome(rs.getString("welcome"));
                game.setIntroduction(rs.getString("introduction"));
                game.setStartTime(rs.getDate("startTime"));
                game.setEndTime(rs.getDate("endTime"));
                game.setAnnex(rs.getString("annex"));
                game.setType(rs.getString("type"));
                game.setGameName(rs.getString("gameName"));

                games.add(game);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return games;
    }

    @Override
    public boolean updateGame(Game game) {
        return false;
    }

    @Override
    public boolean deleteGmae(int gameId) {
        return false;
    }

    public String getGameIdByItemId(String itemsId) {
        String id = "";
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "select gameId, userId from items where itemId=1";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                id = rs.getInt("gameId") + " " + rs.getInt("userId");
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return id;
    }

    public Game getStoreGam(String userId) {
        Connection connection = new MySQLConnection().getConnection();
        Game game = new Game();

        String sql = "select * from games_copy where userId=?" +
                " ORDER BY id desc limit 1; ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,userId);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                game.setGameId(Integer.parseInt(rs.getString("gameId")));
                game.setWelcome(rs.getString("welcome"));
                game.setIntroduction(rs.getString("introduction"));
                game.setStartTime(rs.getDate("startTime"));
                game.setEndTime(rs.getDate("endTime"));
                game.setAnnex(rs.getString("annex"));
                game.setType(rs.getString("type"));
                game.setGameName(rs.getString("gameName"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return game;
    }

    public ArrayList<Part> getStoreParts(int gameId) {
        ArrayList<Part> parts = new ArrayList<Part>();
        //获取连接
        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT * from part_copy where gamesId=?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,gameId);

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                Part part = new Part();
                part.setGameId(rs.getInt("gamesId"));
                part.setGrade(rs.getDouble("grade"));
                part.setExplain(rs.getString("partExplain"));
                part.setId(rs.getInt("id"));
                parts.add(part);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return parts;
    }
}
