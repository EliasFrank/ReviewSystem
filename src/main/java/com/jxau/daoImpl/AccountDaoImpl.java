package com.jxau.daoImpl;

import com.jxau.dao.AccountDao;
import com.jxau.domain.Choose;
import com.jxau.domain.Game;
import com.jxau.domain.User;
import com.jxau.domain.UserApply;
import com.jxau.myUtils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void addUserApply(int parseInt, int gameId) {
        Connection connection = new MySQLConnection().getConnection();

        String sql = "INSERT INTO `check` (`userId`, `gameId`, `isCheck`) VALUES (?, ?, '0')";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, parseInt);
            pstmt.setInt(2, gameId);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
    }

    @Override
    public boolean deleteUser(int userId) {
        return false;
    }

    @Override
    public void updateItemSelect(int itemId, Connection connection) {

        String sql2 = "UPDATE items SET isSelected = 'yes' where itemId = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql2);
            pstmt.setInt(1, itemId);
            pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addJudges(int[] userId, int itemId, Connection connection) {
        String sql = "insert into `check`(id, userId, gameId, itemId, isCheck)\n" +
                "VALUES(DEFAULT,?,0,?,1)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            for(int i = 0; i < userId.length; i++){
                pstmt.setInt(1, userId[i]);
                pstmt.setInt(2, itemId);
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> selectExpert() {
        ArrayList<User> experts = new ArrayList<User>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "select userId, `name` from `user` where userflag = 1;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User expert = new User();
                expert.setUserId(rs.getString("userId"));
                expert.setName(rs.getString("name"));
                experts.add(expert);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return experts;
    }

    @Override
    public List<Choose> selectChoose() {
        ArrayList<Choose> chooses = new ArrayList<Choose>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "select i.userId, u.`name`, i.itemName, g.gameName, i.submitTime, i.itemId  " +
                "from `user` u, items i, games g " +
                "where u.userId = i.userId and i.isSelected = 'no' and i.gameId = g.gameId ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Choose choose = new Choose();
                choose.setGameName(rs.getString("g.gameName"));
                choose.setItemId(rs.getInt("i.itemId"));
                choose.setItemName(rs.getString("i.itemName"));
                choose.setUserId(rs.getInt("i.userId"));
                choose.setUserName(rs.getString("u.name"));
                choose.setSubTime(rs.getDate("i.submitTime").toString());
                chooses.add(choose);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return chooses;
    }

    @Override
    public void agreeApply(int id) {

        Connection connection = MySQLConnection.getConnection();
        String sql = "update `check` set isCheck = 1 where id = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();;
        }finally {
            MySQLConnection.close(connection);
        }
    }

    @Override
    public List<UserApply> selectUserApply() {
        ArrayList<UserApply> applys = new ArrayList<UserApply>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "select c.id, u.userId, u.name, u.number, g.gameId, g.gameName,g.type " +
                "from `check` c, `user` u, games g " +
                "where u.userId = c.userId AND c.gameId = g.gameId " +
                "and c.gameId  <> 0 and c.isCheck = 0";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                UserApply apply = new UserApply();
                apply.setId(rs.getInt("c.id"));
                apply.setGameId(rs.getInt("g.gameId"));
                apply.setGameName(rs.getString("g.gameName"));
                apply.setNumber(rs.getString("u.number"));
                apply.setUserId(rs.getInt("u.userId"));
                apply.setUserName(rs.getString("u.name"));
                apply.setGameType(rs.getString("g.type"));
                applys.add(apply);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return applys;
    }

    @Override
    public User selectUser(User user) {
        Connection connection = new MySQLConnection().getConnection();

        String sql = "select * from `user` where number = ? or tel = ? and password = ?";

        User selectUser = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, user.getNumber());
            pstmt.setString(2, user.getNumber());
            pstmt.setString(3, user.getPassword());

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                selectUser = new User();
                selectUser.setPassword(rs.getString("password"));
                selectUser.setNumber(rs.getString("number"));
                selectUser.setTel(rs.getString("tel"));
                selectUser.setName(rs.getString("name"));
                selectUser.setEmail(rs.getString("email"));
                selectUser.setUserflag(rs.getInt("userflag"));
                selectUser.setUserId(rs.getString("userId"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return selectUser;
    }

    @Override
    public void addAccounnt(User user) {

        Connection connection = new MySQLConnection().getConnection();

        String sql = "insert into `user`(userId, number, password, userflag, email, name, tel)\n" +
                "VALUES(DEFAULT, ?, ?, 2, ?, ?, ?);";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user.getNumber());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getName());
            pstmt.setString(5, user.getTel());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
    }

    @Override
    public boolean selectAccount(String number) {
        boolean flag = true;
        Connection connection = new MySQLConnection().getConnection();

        String sql = "select userId from `user` where number = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, number);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
                flag = false;
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return flag;
    }

    @Override
    public List<Game> selectAllGames() {
        ArrayList<Game> games = new ArrayList<Game>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "SELECT gameId, gameName,`type` FROM `games`;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Game game = new Game();
                game.setGameId(rs.getInt("gameId"));
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
    public boolean deleteExpertApply(int id, Connection connection) throws Exception{
        String sql = "DELETE from `check` where userId = ? and `check`.gameId = 0 and `check`.itemId = 0";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
           throw e;
        }
        return true;
    }

    @Override
    public boolean updateUserFlag(int id, int flag, Connection connection) throws Exception{

        String sql = "update `user` set userflag = ? where userId = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, flag);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            throw e;
        }
        return true;
    }


    @Override
    public List<User> selectAllCheckUser() {
        ArrayList<User> users = new ArrayList<User>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "select `user`.userId id, `name`, userflag, email from `user` " +
                    " where `user`.userId in (" +
                    "  select userId from `check` where isCheck=0 and gameId=0 and itemId=0" +
                    ")";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setUserflag(rs.getInt("userflag"));
                users.add(user);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return users;

    }

    @Override
    public boolean addExpertApply(int id) {

        Connection connection = new MySQLConnection().getConnection();

        String sql = "insert into `check` (id, userid, gameid, isCheck, itemId) values(default, ?, 0, 0, 0)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return true;
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        Connection connection = new MySQLConnection().getConnection();

        String sql = "select userId, `number`, `password`, `name` from `user`";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setNumber(rs.getString("number"));
                users.add(user);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
        return users;
    }

    public void resetPwd(String id) {
        Connection connection = new MySQLConnection().getConnection();

        String sql = "UPDATE `user` SET `password`='00000000' WHERE `userId` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
    }

    public void delUser(String id) {
        Connection connection = new MySQLConnection().getConnection();

        String sql = "DELETE FROM `user` WHERE `userId` = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.execute();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySQLConnection.close(connection);
        }
    }
}
