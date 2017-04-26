<<<<<<< HEAD
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
=======
//package game;
//
//import processing.core.*;
//
//public class Column {
//	
//	PApplet parent;
//	PImage col;
//	PImage col2;
//
//	PVector column;
//	float z,c, butt;
//	
//	Column(PApplet p, PImage img, float x, float y, boolean rotated, boolean hittable) {
//		column = new PVector(x,y);
//		col = parent.loadImage("col.png");
//		col2 = parent.loadImage("col2.png");
//
//		parent = p;
//		this.column.x = x;
//		this.column.y = y;
//		//this.img = img;
//		this.c = c;
//		this.butt = butt;
//		//this.c = c;
//	}
//
//public void display(){
//	parent.image(col, column.x, column.y);
//}
//
//public void move(){
//	column.x = column.x - parent.second()/10;
//	c = column.y + 300; //y value of the start of the column
//	butt = c + 300; //y value of the end of the column
//}
//		
//}


>>>>>>> d97207a057ec3a2e35ce263ad9ed2831ac01a029
