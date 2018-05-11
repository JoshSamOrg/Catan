package com.catan;

import java.util.ArrayList;

public class Point<E> {
	private int x;
	private int y;
	private ArrayList<Hex<E>> hexes;
	private E type;
	private ArrayList<Point<E>> neighbors;
	
	public Point(int x, int y) {
		type = null;
		this.x = x;
		this.y = y;
		hexes = new ArrayList<>();
		neighbors = new ArrayList<>();
	}
	
	//returns the x coordinate of the point
	public int getX() {
		return x;
	}
	//returns the y coordinate of the point
	public int getY() {
		return y;
	}
	//returns the three hexes associated with the point
	public ArrayList<Hex<E>> getHexes() {
		return hexes;
	}
	//returns the type of the piece placed on the point
	public E getType() {
		return type;
	}
	
	//returns the neighbors of the point
	public ArrayList<Point<E>> getNeighbors() {
		return neighbors;
	}

}
