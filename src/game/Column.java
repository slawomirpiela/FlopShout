package game;

import processing.core.*;

public class Column {
	PApplet parent;
	PImage topcol, botcol;
	
	
	int col_xpos[]= new int[2];
	int col_ypos[]= new int[2];
	
	Column(PApplet p, int col_xpos, int col_ypos){
		parent = p;
	}
	
	public void draw(){
		topcol = parent.loadImage("col.png");
		botcol = parent.loadImage("col2.png");
	}
	
public void display(){
		
		
		for(int i = 0; i < 2; i++){
		parent.image(topcol, col_xpos[i], col_ypos[i] - (topcol.height/2 + 100));
		parent.image(botcol, col_xpos[i], col_ypos[i] + (botcol.height/2 + 100));
		if(col_ypos[i] < 0){
			col_ypos[i] = (int) parent.random(200, parent.height-200);
			col_xpos[i] = parent.width;
		}
		
		//parent.imageMode(CENTER); fix
		
		}
	}
}