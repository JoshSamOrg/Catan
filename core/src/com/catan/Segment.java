package com.catan;

import java.util.ArrayList;

public class Segment<E> {
	private ArrayList<Point<E>> points;
	private E type;
	private ArrayList<Segment<E>> neighbors;
	
	public Segment() {
		points = new ArrayList<>();
		type = null;
		neighbors = new ArrayList<>();
	}
	
	//returns the list of points associated with the segment
	public ArrayList<Point<E>> getPoints() {
		return points;
	}
	
	public void setType(E t) {
		type = t;
		return;
	}
	
	//returns the type of the piece placed on the segment
	public E getType() {
		return type;
	}
	
	//returns the neighbors of the segment
	public ArrayList<Segment<E>> getNeighbors() {
		return neighbors;
	}
	
}
