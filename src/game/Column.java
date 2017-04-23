package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage col;
	boolean passed;
	PVector column;
	float x,y;
	
	float xpos = 300;
	float ypos = 700;
	
	Column(PApplet p, float x, float y) {
		column = new PVector(x,y);
		this.passed = false;
		parent = p;
		this.column.x = column.x;
		this.column.y = column.y;
		display();
	}

public void display(){
	col = parent.loadImage("col.png");
	column.x = 300;
	column.y = 600;
	//parent.background(255);
	//parent.stroke(255);
	parent.image(col, column.x, column.y);
	for(int i = 0; i < 4; i++)
	{
		//parent.background(255);
		column.x = column.x + (40 * i);
		parent.image(col, column.x, column.y);
		if(xpos > parent.width)
			{
							//
			}
	}
}
		
}


