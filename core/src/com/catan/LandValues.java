package com.catan;

import java.util.ArrayList;

public class LandValues {
private static char[] land;

public LandValues() {
	land=new char[73];
	for (int i=0; i<15; i++) {
		land[i] = 'l';
	}
	for (int i=15; i<29; i++) {
		land[i]='s';
	}
	for (int i=29; i<42; i++) {
		land[i]= 'u';
	}
	land[42]= 's';
	land[43]= 'u';
	land[44]= 's';
	land[45]= 'u';
	land[46]= 'u';
	for (int i=47; i<54; i++) {
		land[i]= 's';
	}
	land[54]= 'u';
	land[55]= 'u';
	land[56]= 's';
	land[57]= 'u';
	land[58]= 's';
	land[59]= 'u';
	land[60]= 'u';
	for (int i=61; i<72; i++) {
		land[i]= 'u';
	}
	land[72]= 's';
}
public char[] getLand() {
	return land;
}
public void landChange(int i) {
	land[i] = 'l';
}
public void seaChange(int i) {
	land[i]= 's';
}
}
