package com.jxau.dao;

import com.jxau.domain.Choose;
import com.jxau.domain.Game;
import com.jxau.domain.User;
import com.jxau.domain.UserApply;

import java.sql.Connection;
import java.util.List;

public interface AccountDao {
    public boolean updateUserFlag(int id, int flag, Connection connection) throws Exception;
    public boolean addExpertApply(int id);
    public boolean deleteExpertApply(int id, Connection connection) throws Exception;

    public boolean deleteUser(int userId);
    public void addJudges(int[] userId, int itemId, Connection connection);
    public List<User> selectAllCheckUser();
    List<Game> selectAllGames();//查询所有项目
    boolean selectAccount(String number);//查询某个账号是否被使用
    void addAccounnt(User user);//添加用户
    User selectUser(User user);//查询用户账号密码是否正确
    List<UserApply> selectUserApply();//查询用户申请
    void agreeApply(int id);//同意用户申报项目的请求
    List<Choose> selectChoose();//查看还未分配专家审核的项目

    List<User> selectExpert();//查看所有专家

    void updateItemSelect(int itemId, Connection con);

    void addUserApply(int parseInt, int gameId);
}
