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
	float x,y, xyz, end_of_col, www;
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
			xyz = random(-250,0);
			www = 120+(200 *z);
			Columns.add(new Column(this,col2, www, xyz, true ));
			end_of_col = xyz + 300;
			Columns.add(new Column(this,col, 120+(200 * z), min_gap + end_of_col, false ));
		}
	}
	
	public void settings(){
		size(1000,800);
	}
	
	public void draw(){
		background(255);
		menu.draw();
		println(second());
		if(stage == 1){
			bird1.display();
			for(Column columns : Columns ){
				columns.display();	
				columns.move();
				if(bird1.xpos + 35 == columns.column.x && bird1.ypos < columns.column.y ){
					stage = 4;
				}
				
			}
			//pushMatrix();
			//translate(bird1.xpos, bird1.ypos);

			//popMatrix();
			println(bird1.xpos);
			
		}
	}

}
