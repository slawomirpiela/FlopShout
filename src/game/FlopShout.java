package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;
//import processing.core.PImage;

public class FlopShout extends PApplet {

	int v_value = 0;
	Minim minum;
	AudioInput in;
	PImage img;
	Menu menu;
	float xpos = width - width/3;
	float ypos = 200;
	float b_height = 0;
	public static int stage = 0;
	
    public static void main(String[] args)
    {
        PApplet.main("game.FlopShout");  
    }
    
	public void setup()
	{
		minum = new Minim(this);
		menu = new Menu(this);
		in = minum.getLineIn(Minim.MONO, width, 44100, 16);
		img = loadImage("bird.png");
	}
	
	public void settings()
	{
		size(1000,800);
	}
	
	public void draw()
	{
		if(stage == 1){
			background(255);
			stroke(255);
		image(img, xpos, ypos + b_height);
		 
		  for(int i = 0; i < in.bufferSize() - 1; i++)
		  {
			  if(in.left.get(i) > 0)
			  {
				  b_height =+50;
			  }
		  println(((in.left.get(i)*50) + (in.right.get(i)*50) / 2));
		  println(in.mix.get(i)*50);
		  }
		}
		menu.draw();
		
		println(stage);
	}
	
}
