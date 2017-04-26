package game;

import processing.core.*;

public class FlopShout extends PApplet {

	PImage backImg, heroImg;
	PImage img, img2; // dummies
	float x, y; //dummies

	public static int stage, difficulty = 1; //not used yet
	float min_gap = 400 - (difficulty * 2); //not used yet 
	public static int score = 0; 
	int highscore = 0; //not used yet
	public static float velocity = 0;
	//int col_xpos[]= new int[2];
	//int col_ypos[]= new int[2]; 
	float bird_x, bird_y; //not used yet 
	Menu menu;
	Bird bird;
	Column columns;
	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
	//1365
	public void setup() { 
		fill(0);
		textSize(40);
		frameRate(30);
		heroImg = loadImage("potfinal.png"); // need to call it from bird class
		x = 0;
		y = 0;
		menu = new Menu(this);
		columns = new Column(this, x, y);
		bird = new Bird(this); //need to implement it
		}
	
	public void settings(){
		  size(600, 800);
		}

	public void draw() { 
		if(stage == 0){
			background(0);
			columns.draw();
			//bird.display(); //need to implement it
			//bird.move(); //need to implement it
			bird.display();
			for(int i = 0; i < 2; i++){
				imageMode(CENTER);
				image(columns.topcol, columns.col_xpos[i], columns.col_ypos[i] - (columns.topcol.height/2 + 100));
				image(columns.botcol, columns.col_xpos[i], columns.col_ypos[i] + (columns.botcol.height/2 + 100));
				if(columns.col_xpos[i] < -25) {
					columns.col_ypos[i] = (int) random(200, height-200);
					columns.col_xpos[i] = width + 25;
				}
				if(columns.col_xpos[i] == width/2) 
					highscore = max(++score, highscore);
				
				if (bird.b_ypos > height || bird.b_ypos < 0 || (abs(width/2 - columns.col_xpos[i]) < 25 && abs(bird.b_ypos - columns.col_ypos[i]) > 100))
					stage = 1;
					columns.col_xpos[i] -= 6;
				}
			//image(bird.heroImg, bird.b_xpos, bird.b_ypos);
			text(""+score, width/2 - 15, 700);
		}
		else {
			background(0);
			text("Game OVER", width/2, height/2);
		}

		if (mousePressed) { 
			velocity = -17;
			if(stage == 1) {
				columns.col_xpos[0] = 600;
				columns.col_ypos[0] = bird.b_ypos = height/2;
				columns.col_xpos[1] = 900;
				columns.col_ypos[0] = 600;
				stage = score = 0;
			}
		}
		
	}
		


}
