package com.catan;

import java.util.ArrayList;
import java.util.Random;

import com.catan.Player.Order;

public class PlayerOrder {
	private Player one, two, three, four;
	private Random rand;
	private int set = 0;
	private int count=0;
	ArrayList<Player> games;
	ArrayList<Player> counter;

	public PlayerOrder() {
		games=GamePlayers.getGamePlayers();
		counter=new ArrayList<Player>();
		count=GamePlayers.getGamePlayers().size();
		one = new Player();
		two = new Player();
		three = new Player();
		four = new Player();
		rand = new Random();
	}

	public void Orders() {
			counter.add(one);
			counter.add(two);
			counter.add(three);
			counter.add(four);
		for (int i=0; i<count; i++) {
		set=rand.nextInt(count-i);
		counter.get(i).setOrder(Order.FIRST);
		counter.get(i).setName(games.get(set).getName());
		counter.get(i).setColor(games.get(set).getColor());
		games.remove(set);
	}
	 	
	}
	public ArrayList<Player> getCounter() {
		return counter;
	}
	public ArrayList<Player> getGames() {
		return games;
	}
	public int getCount() {
		return count;
	}
}
