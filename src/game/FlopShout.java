package game;

import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class FlopShout extends PApplet {
	Menu menu;
	Bird bird1;
	PImage col, col2;
	public static int stage = 0;
	public static int difficulty = 1;
	float x,y, xyz, end_of_col, www, zzz, start_of_col, end_of_gap, end_of_bot_col;
	float min_gap = 300 * difficulty;
	boolean passed;
	boolean rotated = false;
	ArrayList<Column> Columns = new ArrayList<Column>();
	int level = 1;
	int levelcolumns = 1000;
	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
    
	public void setup(){
		smooth();
		bird1 = new Bird(this);
		menu = new Menu(this);
		col = loadImage( "col.png");
		col2 = loadImage( "col2.png");
		for (int z = 1; z < levelcolumns; z++){
			www = 120+(200 *z);
			xyz = random(-250,0);
			//constr Column(PApplet p, PImage img, float x, float y, boolean rotated, float c, float butt) {
			end_of_col = xyz + 300;
			//start_of_col = end_of_col + 300;
			end_of_gap = end_of_col + min_gap;
			Columns.add(new Column(this,col2, www, xyz, false, end_of_col, end_of_gap));
			
			zzz = 120+(200 * z);
			//start_of_col = end_of_col + 300;
			end_of_bot_col = end_of_gap + 300;
			Columns.add(new Column(this,col,zzz, min_gap + end_of_col, false, end_of_gap, end_of_bot_col));
		}
	}
	
	public void settings(){
		size(1000,800);
	}
	
	public void draw(){
		background(255);
		menu.draw();
		//println(second());
		if(stage == 1){
			bird1.display();
			for(Column columns : Columns ){
				columns.display();	
				columns.move();
			if(columns.column.x < 195 && columns.column.x > 260 ){
				columns.rotated = true;
				fill(0);
				rect(10,10, 50,50);
				println("k, bye then!");
			}
				if(bird1.xpos + bird1.img.width >= zzz && rotated == false &&  bird1.ypos > end_of_col 
						&& bird1.ypos < min_gap + end_of_col) {
					//stage = 4;
					println("STAPH");
				}
				println(columns.c); //y value of the start of the column - beginning of the gap
				println(columns.butt); //y value of the end of the column - end of the gap 
				//println(end_of_col);
				//println(columns.column.x);
				//println(min_gap+end_of_col);
				
			}
			
			//for(Column columns : Columns ){
			//if(columns.column.x < 500 && columns.column.x > 1000 && columns.column.y < 100	){
				
				//rotated = true;
				//fill(0);
				//rect(10,10, 50,50);
				//println("k, bye then!");
			//}

			}
			//pushMatrix();
			//translate(bird1.xpos, bird1.ypos);

			//popMatrix();
			//println(bird1.xpos);
			
		
	}

}
