package game;

import processing.core.*;

public class Column {
	PApplet parent;
	PImage topcol, botcol;
	
	
	float col_xpos[]= new float[2];
	float col_ypos[]= new float[2];
	
	Column(PApplet p, float col_xpos, float col_ypos){
		parent = p;
	}
	
	public void draw(){
		topcol = parent.loadImage("col4.png");
		botcol = parent.loadImage("col3.png");
	}
	
public void display(){
		
	parent.imageMode(parent.CENTER);
	for(int i = 0; i < 2; i++){
		parent.image(topcol, col_xpos[i], col_ypos[i] - (topcol.height/2 + 100));
		parent.image(botcol, col_xpos[i], col_ypos[i] + (botcol.height/2 + 100));
		if(col_ypos[i] < 0){
			col_ypos[i] = parent.random(200, parent.height-200);
			col_xpos[i] = parent.width;
		}
		
		
		}
		
	}
}