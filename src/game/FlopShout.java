package game;

import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class FlopShout extends PApplet {
	Menu menu;
	Bird bird1;
	PImage col, col2, img;
	PImage bgImg;
	public static int stage = 0;
	public static int difficulty = 1;
	float y, xyz, end_of_col, start_of_col, end_of_gap, end_of_bot_col;
	float xpos_top_cols, ypos_top_cols, xpos_bot_cols, ypos_bot_cols;
	float min_gap = 400 * difficulty;
	float x = -200;
	float velocity = 1;
	float birdx, birdy;
	int score = 0;
	//boolean passed;
	//boolean rotated = false;
	//ArrayList<Column> Columns = new ArrayList<Column>();
	int level = 1;
	int levelcolumns = 50;
	int[] colxpos = new int[2];
	int[] colypos= new int[2];

	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
    
	public void setup(){
		//
		colxpos[0] = 600;
		colypos[0] = 0;
		//colxpos[1] = 800;
		//colypos[1] = 300;
		bgImg = loadImage("bg.jpg");
		col = loadImage( "col.png");
		col2 = loadImage( "col2.png");
		bird1 = new Bird(this, img, birdx, height/2, birdy);
		menu = new Menu(this);
		
		//for (int z = 1; z < levelcolumns; z++){
			//top columns
		//	xpos_top_cols = 120+(200 *z);
		//	ypos_top_cols = random(-250,0);
		//	end_of_col = xyz + 300;
		//	end_of_gap = end_of_col + min_gap;
		//	Columns.add(new Column(this,col2, xpos_top_cols, ypos_top_cols, false, true));		
		//	xpos_bot_cols = 120+(200 * z);
		//	end_of_bot_col = end_of_gap + 300;
		//	ypos_bot_cols = min_gap + end_of_col;
		//	Columns.add(new Column(this,col,xpos_bot_cols,ypos_bot_cols, true, true));
		//}
		
	}
	
	public void settings(){
		size(1000,800);
	}
	
	public void draw(){

		if(stage == 0){

		menu.draw();
		}
		//println(second());
		if(stage == 1){
			//background(255);
			imageMode(CORNER);
			image(bgImg, x, 0);
			image(bgImg, x + bgImg.width, birdy);
			bird1.display();
			x -= 6;
			if(x == -800) {
				x = 0;}
			for(int i = 0; i < 2; i++){
				imageMode(CENTER);
				image(col2, colxpos[i], colypos[i] - (col2.height/2+100));
				//bot one
				image(col, colxpos[i], colypos[i] + (col.height/2+100));
				//
				if(colxpos[i] < -20){
					colypos[i] = (int) random(-250, 300);
					colxpos[i] = width;
				}
				if (colxpos[i] == width/2){
					score++;
					println(score);
				}
				colxpos[i] -= 6;
			}
		}
			
	}
	
}
