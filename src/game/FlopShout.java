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
	ArrayList<Column> Columns = new ArrayList<Column>();
	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
    
	public void setup(){
		smooth();
		bird1 = new Bird(this);
		menu = new Menu(this);
		for (int z = 1; z < 10; z++){
			for(int i = 1; i < 10; i++){
			Columns.add(new Column(this,x*20, y*30));
			println(Columns.size());
			}
			//x=+50;
			//cols = new Column(this, x, y);
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
				columns.display();	
			}

			bird1.display();
		}
		//println(stage);
	}

}
