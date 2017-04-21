package game;
import processing.core.PApplet;

public class Menu{
	
	PApplet parent;
	
	Menu(PApplet p) {
		parent = p;
	}
	
public void draw() 
{
	if(FlopShout.stage == 0){
		parent.fill(255,100);
		parent.textAlign(parent.CENTER);
		parent.text("FlopShout", parent.width/2, 200);
		parent.text("Start Game", parent.width/2, 350);
		parent.text("Options", parent.width/2, 400);
		parent.text("Quit", parent.width/2, 450);
	}
	
	if(FlopShout.stage == 0 && parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 330 && parent.mouseY < 370 ){
		FlopShout.stage = 2;
	}
	if(FlopShout.stage == 0 && parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 370 && parent.mouseY < 410 ){
		FlopShout.stage = 3;
	}
	if(FlopShout.stage == 0 && parent.mousePressed == true && parent.mouseX > 420 && parent.mouseX < 600 && parent.mouseY > 410 && parent.mouseY < 490 ){
		FlopShout.stage = 4;
		System.exit(0);
	}
}

}

