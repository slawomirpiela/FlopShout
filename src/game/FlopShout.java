package game;

import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class FlopShout extends PApplet {
	Menu menu;
	Bird bird1;
	Column cols;

	//float b_height = 0;
	public static int stage = 0;
	public static int difficulty = 0;
	float x1,y1,x2,y2;
	float border = 50;
	float x,y;
	boolean passed;
	boolean rotated = false;
	ArrayList<Column> Columns = new ArrayList<Column>();
	int level = 1;
	int levelcolumns = 20;
	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
    
	public void setup(){
		smooth();
		bird1 = new Bird(this);
		menu = new Menu(this);
		for (int z = 1; z < levelcolumns; z++){
			//top ones
			Columns.add(new Column(this,120+(200 *z), random(0,-250), rotated ));
			rotated = true;
		}
			for(int i = 1; i < levelcolumns; i++){
				//bottom ones
				Columns.add(new Column(this,120+(200 * i), random(600,900), rotated ));
				rotated = false;
			println(Columns.size());
			}
	}
	
	public void settings(){
		size(1000,800);
	}
	
	public void draw(){
		background(255);
		menu.draw();
		if(stage == 1){
			for(Column columns : Columns ){
				//columns.torotate();
				columns.display();	
				
			}
			bird1.display();
				
		}
			//Columns.get(<Column>1);
			
		
		//println(stage);
	}

}
