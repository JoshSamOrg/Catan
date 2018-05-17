package com.catan;

import java.util.ArrayList;

public class Hex<E> {
	private Character type;
	private ArrayList<Point<E>> points;
	
	public Hex () {
		type = null;
		points = null;
	}
	
	public Hex (Character type) {
		this.type = type;
		points = null;
	}
	public Hex(Character type, ArrayList<Point<E>> points) {
		this.type = type;
		this.points = points;
	}
	
	//returns the type of the hex (land, sea, or undiscovered)
	public Character getType() {
		return type;
	}
	//returns the list of six points associated with a hex
	public ArrayList<Point<E>> getPoints() {
		return points;
	}
	public void setType(Character t) {
		type = t;
		return;
	}
	public void setPoints(ArrayList<Point<E>> p) {
		points = p;
		return;
	}
}
