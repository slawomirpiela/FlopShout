package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class FlopShout extends PApplet {

//PImage col;
Menu menu;
Bird bird1;
Column cols;

//float b_height = 0;
public static int stage = 0;
public static int difficulty = 0;
float x1,y1,x2,y2;

float border = 50;
	
public static void main(String[] args)
	{
		PApplet.main("game.FlopShout");  
    }
    
public void setup()
	{
		smooth();
		bird1 = new Bird(this);
		menu = new Menu(this);
		cols = new Column(this);
	}
	
public void settings()
	{
		size(1000,800);
	}
	
public void draw()
	{
		cols.display();
		bird1.display();
		menu.draw();
		//println(stage);
	}
	
}
