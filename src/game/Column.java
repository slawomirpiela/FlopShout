package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage img;

	boolean passed, rotated;
	PVector column;
	float z,c, butt;
	
	Column(PApplet p, PImage img, float x, float y, boolean rotated, float c, float butt) {
		column = new PVector(x,y);
		//this.passed = false;
		this.rotated = rotated;
		parent = p;
		this.column.x = x;
		this.column.y = y;
		this.img = img;
		this.c = c;
		this.butt = butt;
		//this.c = c;
	}

public void display(){
	parent.image(img, column.x, column.y);
	
}

public void move(){
	column.x = column.x - parent.second()/10;
	c = column.y + 300; //y value of the start of the column
	butt = c + 300; //y value of the end of the column
}
		
}


