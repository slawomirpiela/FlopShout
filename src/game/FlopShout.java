package game;

<<<<<<< HEAD
import processing.core.*;

public class FlopShout extends PApplet {
=======
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
>>>>>>> d97207a057ec3a2e35ce263ad9ed2831ac01a029

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
<<<<<<< HEAD
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
=======
    
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
				
>>>>>>> d97207a057ec3a2e35ce263ad9ed2831ac01a029
			}
		}
		
	}
		


}
