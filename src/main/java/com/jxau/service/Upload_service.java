package com.jxau.service;

import com.jxau.daoImpl.DocumentDao;
import com.jxau.daoImpl.GamesDao;
import com.jxau.daoImpl.IntroDao;
import com.jxau.daoImpl.ItemsDao;
import com.jxau.domain.Document;
import com.jxau.domain.Game;
import com.jxau.domain.Intro;
import com.jxau.domain.Items;
import com.jxau.domain.User;

public class Upload_service{
	public static void Upload(User user,String time,String fname,String intorduce,int gameId,String name) throws Exception{
		Game g = GamesDao.selectByGameName(gameId);
		Items ite = new Items(0,g.getGameId(), Integer.parseInt(user.getUserId()), 1, time, fname,"no");
		ItemsDao.insert(ite);
		String[] names = fname.split(".");
		int itemid=ItemsDao.select_ItemId(Integer.parseInt(user.getUserId()), gameId, name);
		Document doc = new Document(itemid,"document",intorduce,0, Integer.parseInt(fname));
		DocumentDao.insert(doc); 			
	}
}
