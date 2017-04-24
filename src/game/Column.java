package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage img;

	boolean passed, rotated;
	PVector column;
	
	Column(PApplet p, PImage img, float x, float y, boolean rotated) {
		column = new PVector(x,y);
		//this.passed = false;
		this.rotated = rotated;
		parent = p;
		this.column.x = x;
		this.column.y = y;
		this.img = img;
	}

public void display(){
	parent.image(img, column.x, column.y);
	
}

public void move(){
	column.x = column.x - parent.second()/10;
}

		
}


