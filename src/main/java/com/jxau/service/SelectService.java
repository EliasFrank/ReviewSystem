package com.jxau.service;

import com.jxau.daoImpl.AccountDaoImpl;
import com.jxau.daoImpl.GameDaoImpl;
import com.jxau.daoImpl.GradesImpl;
import com.jxau.daoImpl.ItemDaoImpl;
import com.jxau.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectService {
    public static List<User> selectAllCheckUser(){
        List<User> users =  new AccountDaoImpl().selectAllCheckUser();
        return users;
    }

    public static List<Game> selectAllGames() {
        List<Game> games =  new AccountDaoImpl().selectAllGames();
        return games;
    }

    public static List<GradeRank> selectGradeRank(int id){
        return new GradesImpl().getGrades(id);
    }

    public static boolean selectAccount(String number) {
        return new AccountDaoImpl().selectAccount(number);
    }

    public static User selectUser(User user) {
        return new AccountDaoImpl().selectUser(user);
    }

    public static int getGameId() {
        return new GameDaoImpl().getGameId();
    }

    public static List<UserApply> selectUserApply() {
        return new AccountDaoImpl().selectUserApply();
    }

    public static List<Choose> selectChoose() {
        return new AccountDaoImpl().selectChoose();
    }

    public static Object selectExpert() {
        return new AccountDaoImpl().selectExpert();
    }

    public static int getItemId() {
        return new GameDaoImpl().getItemId();
    }

    public static boolean selectIsPost(int userId, int gameId) {
        return new ItemDaoImpl().selectIsPost(userId, gameId);
    }

    public static String selectGamesTime(int gameId) {
        return new ItemDaoImpl().selectGameTime(gameId);
    }

    public static ArrayList<MyItems> getMyItems(String userId) {
       return new ItemDaoImpl().selectMyItems(Integer.parseInt(userId));
    }
    public static ArrayList<Game> selectGames(){
        return new GameDaoImpl().getGames();
    }

    public static ArrayList<CheckItem> selectCheckItems(int userId) {
        return new ItemDaoImpl().getCheckItems(userId);
    }

    public static ArrayList<Part> getParts(String gameId) {
        return new GameDaoImpl().getParts(gameId);
    }

    public static Map<Integer, Object> getItem(String itemId) {
        return new ItemDaoImpl().getItems(itemId);
    }

    public static String getItemFilePath(int itemId) {
        return new ItemDaoImpl().getItemsPath(itemId);
    }
}
