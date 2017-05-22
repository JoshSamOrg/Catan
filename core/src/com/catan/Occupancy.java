package com.catan;

//interface that describes the open space of a harbor settlement or ship
public interface Occupancy {

	public void decreaseSpace(String piece); //decreases the space of the structure (harbor settlement or ship)
	public boolean hasSpaceForCrew(); //true when the structure has space for a crew
	public boolean hasSpaceForSettler(); //true when the structure has space for a settler
	public boolean hasSpaceForSpice(); //true when the structure has space for a spice
	public boolean hasSpaceForFish(); //true when the structure has space for a fish
}
