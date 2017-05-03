package game;

import processing.core.*;
import controlP5.*;
import controlP5.*;
public class FlopShout extends PApplet {

	PImage bgImg;
	float x = -200;
	float y; //dummies

	public static int stage, difficulty,score, highscore = 0; //not used yet
	float min_gap = 200 - (difficulty * 5); //not used yet 
	public static float velocity = 0;
	Menu menu; //not yet implemented
	Bird bird; 
	Column columns;
	boolean ez_mode = false; //ez mode to be changed from true = false in the menu
	GUI gui; //possibly will be implemented
	
	public static void main(String[] args){
		PApplet.main("game.FlopShout");  
	}
	//1365
	public void setup() { 
		fill(0);
		textSize(40);
		frameRate(60);
		bgImg = loadImage("bgImg.jpg");
		menu = new Menu(this); //to be implemented / replaced by P5Control
		columns = new Column(this);
		bird = new Bird(this);
		gui = new GUI(this);
		//cp5 = new ControlP5(this);
		//cp5.addButton("Start Game").setValue(0).setPosition((float)(width*0.25),(float)(height*0.4625)).setSize(230,60);
		}
	
	public void settings(){
		  size(600, 800);
		}

	public void draw() { 
		
		if(stage == 1){
			
			//background(255);
			imageMode(CORNER);
			image(bgImg,x,0);
			image(bgImg,x + bgImg.width,0);
			x -=4;
			//println(x);

			//simple if statement to reset the bg
			if(x == -600) x = 0;
			
			//gets the bird class img
			bird.display();
			if(score == 0){
			text("1", width/2 - 15, 700);}
			for(int i = 0; i < 2; i++){
				imageMode(CENTER);
				if(ez_mode == false){
				image(columns.topcol, columns.col_xpos[i], columns.col_ypos[i] - (columns.topcol.height/2 + min_gap));
				image(columns.botcol, columns.col_xpos[i], columns.col_ypos[i] + (columns.botcol.height/2 + min_gap));}
				else{
					image(columns.botcol, columns.col_xpos[i], columns.col_ypos[i] + (columns.botcol.height/2 + min_gap));
				}
				
				if(columns.col_xpos[i] < -25) {
					columns.col_ypos[i] = (int) random(150, height-150);
					columns.col_xpos[i] = width + 25;
					score = score+ 1;
				}
				
				//moving the columns to the left
				columns.col_xpos[i] -= 4;
				
				
				//collision
				if(ez_mode == false){
					if (bird.b_ypos > height || bird.b_ypos < 0 || (abs(width/2 - columns.col_xpos[i]) < 25 && abs(bird.b_ypos - columns.col_ypos[i]) > min_gap))
						stage = 4;
						fill(255,0,0);}
				 else{
					if (bird.b_ypos > height || bird.b_ypos < 0 || bird.b_ypos > (columns.col_ypos[i] + min_gap) && (abs(width/2 - columns.col_xpos[i]) < 25))
						stage = 4;
						fill(255,0,0);
						println(bird.b_ypos);
						println(columns.col_ypos[i]);
				 }			
				}
				
			text(""+ (score), width/2 - 15, 700);
		}

		if (gui.s.isMousePressed()) { 
			//velocity = -12;
			if(stage == 0 && ez_mode == false){
				columns.col_xpos[0] = 600;
				columns.col_ypos[0] = bird.b_ypos = height/2;
				columns.col_xpos[1] = 900;
				columns.col_ypos[1] = 600;
				score = 1;
				stage = 1;
				
				gui.s.setVisible(false);
				gui.op.setVisible(false);
			}
			if(stage == 0 && ez_mode == true) {
				bird.b_ypos = 200;
				columns.col_xpos[0] = 600;
				columns.col_ypos[0] = 500;
				columns.col_xpos[1] = 900;
				columns.col_ypos[1] = height;
				stage = 1;
				score = 1;
				
				gui.s.setVisible(false);
				gui.op.setVisible(false);
			}
		}
		if(gui.op.isMousePressed()){
			stage = 3;
			
			gui.s.setVisible(false);
			gui.op.setVisible(false);
		}
		if(gui.high.isMousePressed()){
			stage = 4;
			
			gui.s.setVisible(false);
			gui.op.setVisible(false);
			gui.high.setVisible(false);
		}
		if(gui.ex.isMousePressed()){
			System.exit(0);
		}
		//menu.drawMainMenu();
		gui.drawGUIMenu();	
		columns.draw();
	}
}
