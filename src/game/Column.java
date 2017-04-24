package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage col;
	boolean passed, rotated;
	PVector column;
	//float x,y;
	
	Column(PApplet p, float x, float y, boolean rotated) {
		column = new PVector(x,y);
		this.passed = false;
		this.rotated = rotated;
		parent = p;
		this.column.x = x;
		this.column.y = y;
		//display();
		//torotate();
	}

public void display(){
	col = parent.loadImage("col.png");
	torotate();
	parent.image(col, column.x, column.y);
	

}

public void torotate(){
	if(rotated = true){
		parent.pushMatrix();
		parent.translate(column.x, column.y);
		parent.rotate(parent.PI);
		parent.popMatrix();
	}
}

		
}


