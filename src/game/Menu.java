package game;
import processing.core.PApplet;

public class Menu extends PApplet{
	
	int stage = 0;
	
public void draw () 
{
	if(stage == 0){
		background(0);
		textAlign(CENTER);
		text("FlopShout", width/2, 200);
		text("Start Game", width/2, 350);
		text("Options", width/2, 400);
		text("Quit", width/2, 450);
	}
}
	
}

