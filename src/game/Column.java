package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage col;
	boolean passed;
	PVector column;
	float x,y;
	
	Column(PApplet p, float x, float y) {
		column = new PVector(x,y);
		this.passed = false;
		parent = p;
		this.column.x = x;
		this.column.y = y;
		display();
	}

public void display(){
	col = parent.loadImage("col.png");
	parent.image(col, column.x, column.y);
}
		
}


