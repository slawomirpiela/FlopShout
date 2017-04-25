package game;

import java.util.ArrayList;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import static java.lang.Math.abs;
import processing.core.*;

public class FlopShout extends PApplet {
	Menu menu;
	Bird bird1;
	PImage col, col2, img;
	PImage bgImg;
	public static int stage = 1;
	public static int difficulty = 1;
	float y, xyz, end_of_col, start_of_col, end_of_gap, end_of_bot_col;
	float xpos_top_cols, ypos_top_cols, xpos_bot_cols, ypos_bot_cols;
	float min_gap = 400 * difficulty;
	float x = -200;
	float velocity = 1;
	float birdx, birdy;
	int score = 0;
	int highscore = 0;
	int level = 1;
	int levelcolumns = 50;
	int[] colxpos = new int[4];
	int[] colypos= new int[4];

	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
    
	public void setup(){
		
		bgImg = loadImage("bg.jpg");
		col = loadImage( "col.png");
		col2 = loadImage( "col2.png");
		bird1 = new Bird(this, img, birdx, height/2, birdy);
		menu = new Menu(this);		
	}
	
	public void settings(){
		size(500,500);
	}
	
	public void draw(){

		//if(stage == 0){
		//	menu.draw();
		//}
		if(stage == 1){
			background(255);
			bird1.display();
			bird1.xpos += 6;
			if(bird1.xpos == width){
				bird1.xpos = 0;
			}
		
		if(bird1.xpos == -1800) bird1.xpos = 0;
			for(int i = 1; i < 3; i++){
				
				imageMode(CENTER);
				image(col2, colxpos[i], colypos[i] - (col2.height/2+100));
				//bot one
				image(col, colxpos[i], colypos[i] + (col.height/2+100));
				//
		
				if(colxpos[i] < 0){
					colypos[i] = (int)random(200, height-200);
					colxpos[i] = width;
				}
				if (colxpos[i] == width/2){
					score++;
					highscore = Math.max(score,highscore);
					println(score);
				}
				if((Math.abs(width/2-colxpos[i])< 25  && Math.abs(bird1.ypos - colypos[i])>100)) {
					stage = 0;
					
				}
				colxpos[i] -= 6;
				
			}
		}
			
	}
	
}
