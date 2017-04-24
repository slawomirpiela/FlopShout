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
	float x,y, xyz, end_of_col;
	float min_gap = 300 * difficulty;
	boolean passed;
	boolean rotated = false;
	ArrayList<Column> Columns = new ArrayList<Column>();
	int level = 1;
	int levelcolumns = 20;
	float movement;
	
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
			//top ones
			//movement = frameCount + 20;
			xyz = random(-250,0);
			Columns.add(new Column(this, col2, 120+(200 *z) + movement, xyz, true ));
			
			end_of_col = xyz + 300;
			Columns.add(new Column(this,col, 120+(200 * z), min_gap + end_of_col, false ));
			
			println(Columns.size());
		}
	}
	
	public void settings(){
		size(1000,800);
	}//yo
	
	public void draw(){
		background(255);
		menu.draw();
		if(stage == 1){
			for(Column columns : Columns ){
				//if(rotated == true){
				//columns.torotate();
				//}
				columns.display();	
			}
			bird1.display();
		}
	}

}
