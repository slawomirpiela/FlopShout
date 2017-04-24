package game;
import processing.core.PApplet;
import processing.core.PFont;

public class Menu
{
	PApplet parent;
	PFont font;
	boolean rectOver = false;
	float x1,y1,x2,y2;
	float rectColor = 0;
	float rectHighlight = 51;
	
	Menu(PApplet p) 
	{
		parent = p;
		font = parent.createFont("ffont.TTF", 38, true);
	}
	
	boolean overRect(float x, float y, float width, float height)  
	{
		if (parent.mouseX >= x && parent.mouseX <= x+width && parent.mouseY >= y && parent.mouseY <= y+height)
		{
			return true;
		} else {
		    return false;
			}
	}

	public void update(int x, int y){
		if( overRect(x1,y1,x2,y2)) 
		{
			rectOver = true;
		} else {
			rectOver = false;
			}
	}

	public void mousePressed(){
		if(rectOver){
			rectColor = 255;
		}
	}

	public void draw(){
		float hwidth = parent.width/2;
		float hheight = parent.height/2;
		int color = 255;
		float menulist[] = {200,350,440,510,590};
		float menuele[] = {210,355,425,495,515};
	
		//overRect(x1,y1,x2,y2);

		if(FlopShout.stage == 0){
			parent.background(255);
			if(rectOver){
				parent.fill(rectHighlight);
			} else {
				parent.fill(rectColor);
			}
			parent.rectMode(parent.CORNER);
			parent.fill(0,0,0,0);
			parent.stroke(255);
			parent.rect(x1,y1,x2,y2);
			parent.fill(255);
			parent.textAlign(parent.CENTER);
			parent.textFont(font);
			
			for(int i = 1; i < 4; i ++){
				float x1 = hwidth - 160;
				float y1 = menuele[i] - 25;
				float x2 = 320;
				float y2 = 50;
			}
			parent.fill(0);
			parent.text("FlopShout", hwidth, menuele[0] + 15);
			parent.text("Start Game", hwidth,menuele[1] + 15);
			parent.text("Options", hwidth, menuele[2] + 15);
			parent.text("Quit", hwidth, menuele[3] + 15);
			if(parent.mouseX > 420 && parent.mouseX < 600){
			
		}
		if(parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 330 && parent.mouseY < 370 ){
			FlopShout.stage = 1;
		}
		if(parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 370 && parent.mouseY < 410 ){
			FlopShout.stage = 2;
		}
		if(parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 410 && parent.mouseY < 490 ){
			FlopShout.stage = 3;
			System.exit(0);
		}
	}
	if(FlopShout.stage == 2){
		parent.background(255);
		parent.fill(0);
		parent.textAlign(parent.CENTER);
		parent.text("Options", hwidth, menulist[0]);
		parent.text("Change difficulty ", parent.width/2, menulist[1]);
		parent.text("  - "+FlopShout.difficulty + " +  ", parent.width/2 + 250, menulist[1]);
		if(parent.mousePressed == true && parent.mouseX > 880 && parent.mouseX < 900 && parent.mouseY > 300 && parent.mouseY < 400 && FlopShout.difficulty < -1)
		{
			FlopShout.difficulty -= 1;
		}
		if(parent.mousePressed == true && parent.mouseX > 800 && parent.mouseX < 650 && parent.mouseY > 330 && parent.mouseY < 370 && FlopShout.difficulty < 5)
		{
			FlopShout.difficulty += 1;
		}
		parent.text("Options", parent.width/2, menulist[2]);
		parent.text("Quit", parent.width/2, menulist[3]);
	}
	if(FlopShout.stage == 4){
		parent.background(255);
		parent.textAlign(parent.CENTER);
		//textFont(font);
		parent.fill(0);
		parent.text("Game Over", parent.width/2, parent.height/2);
	}
}

private void println(boolean rectOver2) {
	// TODO Auto-generated method stub
	
}

}

