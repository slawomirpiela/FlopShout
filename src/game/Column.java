package game;

import processing.core.*;

public class Column {
	PApplet parent;
	PImage topcol, botcol;
	int i = 0;
	
	
	float col_xpos[]= new float[2];
	float col_ypos[]= new float[2];
	
	Column(PApplet p){
		parent = p;
	}
	
	public void draw(){
		topcol = parent.loadImage("col4.png");
		botcol = parent.loadImage("col3.png");
	}
	
public void display(){
		
	parent.imageMode(parent.CENTER);

		parent.image(topcol, col_xpos[i], col_ypos[i] - (topcol.height/2 + 100));
		parent.image(botcol, col_xpos[i], col_ypos[i] + (botcol.height/2 + 100));
		if(col_ypos[i] < -25){
			col_ypos[i] = parent.random(200, parent.height-200);
			col_xpos[i] = parent.width;
		}
		
		
	//imageMode(CENTER);
	//image(columns.topcol, columns.col_xpos[i], columns.col_ypos[i] - (columns.topcol.height/2 + 100));
	//image(columns.botcol, columns.col_xpos[i], columns.col_ypos[i] + (columns.botcol.height/2 + 100));
	//if(columns.col_xpos[i] < -25) {
	//	columns.col_ypos[i] = (int) random(200, height-200);
	//	columns.col_xpos[i] = width + 25;
	//}
	
	}
}