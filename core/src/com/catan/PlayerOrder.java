package com.catan;

import java.util.ArrayList;
import java.util.Random;

import com.catan.Player.Order;

public class PlayerOrder {
	private Player one, two, three, four;
	private Random rand;
	private int set = 0;
	private int count=0;
	private ArrayList<Player> games;
	private static ArrayList<Player> orderedPlayers;
	private ArrayList<Order> positions;
	public PlayerOrder() {
		positions=new ArrayList<Order>();
		games=new ArrayList<Player>();
		orderedPlayers=new ArrayList<Player>();
		count=GamePlayers.getGamePlayers().size();
		one = new Player();
		two = new Player();
		three = new Player();
		four = new Player();
		rand = new Random();
		positions.add(Order.FIRST);
		positions.add(Order.SECOND);
		positions.add(Order.THIRD);
		positions.add(Order.FOURTH);
		for (int i=0; i<GamePlayers.getGamePlayers().size(); i++) {
			games.add(GamePlayers.getGamePlayers().get(i));
		}
	}

	public void Orders() {
			orderedPlayers.add(one);
			orderedPlayers.add(two);
			if (count==3) {
				orderedPlayers.add(three);
			}
			if (count==4) {
			orderedPlayers.add(three);
			orderedPlayers.add(four);
			}
		for (int i=0; i<count; i++) {
		set=rand.nextInt(count-i);
		orderedPlayers.get(i).setOrder(positions.get(i));
		orderedPlayers.get(i).setName(games.get(set).getName());
		orderedPlayers.get(i).setColor(games.get(set).getColor());
		games.remove(set);
	}

	}
	public static ArrayList<Player> getOrderedPlayers() {
		return orderedPlayers;
	}
}
