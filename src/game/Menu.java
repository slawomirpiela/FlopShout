package game;
import processing.core.PApplet;
import processing.core.PFont;

public class Menu
{
	PApplet parent;
	PFont font;
	float x1,y1,x2,y2;
	
	Menu(PApplet p) 
	{
		parent = p;
		font = parent.createFont("ffont.TTF", 38, true);
	}

	public void drawMainMenu(){
		float hwidth = parent.width/2;
		float hheight = parent.height/2;
		float menulist[] = {200,350,440,510,590};
		float menuele[] = {210,355,425,495,565};
		
		//if the user is in the menu
		if(FlopShout.stage == 0){
			//setting for the rectangles
			parent.stroke(255);
			
			//text that appears when user enters the menu
			parent.fill(255);
			parent.textAlign(parent.CENTER);
			parent.textFont(font);
			parent.text("FlopShout", hwidth, menuele[0] + 15);
			parent.text("Start Game", hwidth,menuele[1] + 15);
			parent.text("Options", hwidth, menuele[2] + 15);
			parent.text("Quit", hwidth, menuele[3] + 15);
			parent.fill(0,0,0,0);
			
			//start button
		if(parent.mouseX > hwidth - 115 && parent.mouseX < hwidth + 115 && parent.mouseY > 325 && parent.mouseY < 385 ){
			parent.fill(255,0,0);
			parent.text("Start Game", hwidth,menuele[1] + 15);
			if(parent.mousePressed){
				//FlopShout.stage = 1;
				}
			}
		else{
			parent.fill(0,0,0,0);
			}
		
		//options button
		if(parent.mouseX > hwidth - 115 && parent.mouseX < hwidth + 115 && parent.mouseY > 395 && parent.mouseY < 450 ){
			//FlopShout.stage = 2;
			parent.fill(255,0,0);
			parent.text("Options", hwidth, menuele[2] + 15);
			if(parent.mousePressed){
				FlopShout.stage = 2;
				}
			}
		else{
			parent.fill(0,0,0,0);
			}
		
		//quit button
		if(parent.mouseX > hwidth - 80 && parent.mouseX < hwidth + 80 && parent.mouseY > 465 && parent.mouseY < 515 ){
			parent.fill(255,0,0);
			parent.text("Quit", hwidth, menuele[3] + 15);
			if(parent.mousePressed){
				FlopShout.stage = 3;
				System.exit(0);
				}
			}
		else{
			parent.fill(0,0,0,0);
			}
		//rectangles that will appear if the mouse button isn't over any of the buttons
		parent.fill(0,0,0,0);
		parent.rect(hwidth - 115, 325, 230, 60);
		parent.rect(hwidth - 115, 395, 230, 60);
		parent.rect(hwidth - 115, 465, 230, 60);
		} // end of - if stage = 0 statement

		//Options menu
	if(FlopShout.stage == 2){
		//starting menu elements
		parent.background(255);
		parent.fill(0);
		parent.textAlign(parent.CENTER);
		parent.text("Options", hwidth, menuele[0]);
		parent.text("Difficulty", hwidth, menuele[1]+15);
		parent.text("  - "+FlopShout.difficulty + " +  ", parent.width/2 + 200, menuele[1]+15);
		parent.text("Easy Mode ?", hwidth, menuele[2]+15);
		parent.text("Play again!", hwidth, menuele[3]+15);
		parent.text("Quit", hwidth, menuele[4]+15);
		
		//options button
		if(parent.mouseX > hwidth - 115 && parent.mouseX < hwidth + 270 && parent.mouseY > 325 && parent.mouseY < 385 ){
			//FlopShout.stage = 2;
			parent.fill(255,0,0);
			parent.text("Difficulty", hwidth, menuele[1] + 15);
			if(parent.mousePressed)	{
				if(parent.mouseX > 420 && parent.mouseX < 500 && FlopShout.difficulty > -1)
			{
				FlopShout.difficulty -= 1;
			}
			if(parent.mouseX > 525 && parent.mouseX < 560  && FlopShout.difficulty < 5)
			{
				FlopShout.difficulty += 1;
			
			}
		else{
			parent.fill(0,0,0,0);
			}
			}
		}
		
		//easy mode
		if(parent.mouseX > hwidth - 130 && parent.mouseX < hwidth + 130 && parent.mouseY > 415 && parent.mouseY < 465 ){
			parent.fill(255,0,0);
			parent.text("Easy Mode ?", hwidth, menuele[2] + 15);
			if(parent.mousePressed)
				if(FlopShout.ez_mode == false || FlopShout.ez_mode == true){
				FlopShout.ez_mode = !FlopShout.ez_mode;
				}
			}
		else{
			
			parent.fill(0,0,0,0);
			}
		parent.println(FlopShout.ez_mode);
		//back to menu
		if(parent.mouseX > hwidth - 130 && parent.mouseX < hwidth + 130 && parent.mouseY > 475 && parent.mouseY < 525 ){
			parent.fill(255,0,0);
			parent.text("Play again!", hwidth, menuele[3] + 15);
			if(parent.mousePressed){
				FlopShout.stage = 0;
				}
			}
		else{
			parent.fill(0,0,0,0);
			}
		
		//QUIT
		if(parent.mouseX > hwidth - 80 && parent.mouseX < hwidth + 80 && parent.mouseY > 540 && parent.mouseY < 600 ){
			parent.fill(255,0,0);
			parent.text("Quit", hwidth, menuele[4]+15);
			if(parent.mousePressed){
				FlopShout.stage = 3;
				System.exit(0);
				}
			}
		else{
			parent.fill(0,0,0,0);
			}
	}
	
	//Game over view
		if(FlopShout.stage == 4){
			parent.background(255);
			parent.textAlign(parent.CENTER);
			parent.fill(0);
			parent.text("GAME OVER", hwidth, menuele[0] + 15);
			parent.text(" Your score was " + (FlopShout.score), hwidth,menuele[1] + 15);
			parent.text("HighScore = " +FlopShout.highscore, hwidth,menuele[2] + 15);
			parent.text("Restart", 200, parent.height - 100);
			parent.text("Quit", parent.width - 200, parent.height - 100);
			
			//restart button
			if(parent.mouseX > hwidth -250 && parent.mouseX < hwidth -20  && parent.mouseY > parent.height - 145 && parent.mouseY < parent.height - 90 ){
				parent.fill(255,0,0);
				parent.text("Restart", 200, parent.height - 100);
				if(parent.mousePressed){
					FlopShout.stage = 1;
					}
				}
			else{
				parent.fill(0,0,0,0);
				}
			
			//quit button
			if(parent.mouseX > hwidth + 40 && parent.mouseX < hwidth + 160 && parent.mouseY > parent.height - 145 && parent.mouseY < parent.height - 90 ){
				parent.fill(255,0,0);
				parent.text("Quit", parent.width - 200, parent.height - 100);
				if(parent.mousePressed){
					FlopShout.stage = 3;
					System.exit(0);
					}
				}
			else{
				parent.fill(0,0,0,0);
				}
		}
	}
}