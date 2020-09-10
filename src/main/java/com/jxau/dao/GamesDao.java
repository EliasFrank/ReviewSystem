package com.jxau.dao;

import com.jxau.domain.Game;
import com.jxau.domain.Part;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface GamesDao {
    public void addGame(Game game, Connection connection) throws SQLException;//新建申报项目
    public void addParts(Part[] parts, Connection connection) throws SQLException;
    public Game getGame(int id);//根据id得到申报项目
    public ArrayList<Game> getGames();//得到申报项目
    public boolean updateGame(Game game);
    public boolean deleteGmae(int gameId);//根据id删除申报项目

    int getGameId();

    ArrayList<Part> getParts(String gameId);

    void storeGame(Game game, Connection con, String userId) throws SQLException;

    void storeParts(Part[] parts, Connection con) throws SQLException;
}
