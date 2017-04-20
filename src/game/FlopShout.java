package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

public class FlopShout extends PApplet {

	int v_value = 0;
	Minim minum;
	AudioInput in;
	PImage img;
	float xpos = width - width/3;
	float ypos = 200;
	float b_height = 0;
	int stage = 0;
	
	
	public void setup()
	{
		minum = new Minim(this);
		in = minum.getLineIn(Minim.MONO, width, 44100, 16);
		img = loadImage("bird.png");
		
	}
	
	public void settings()
	{
		size(800,800);
	}
	
	public void draw()
	{
		background(255);
		stroke(255);
		image(img, xpos, ypos + b_height);
		 
		// print the values the pc is hearing
		//println(in.left.get(v_value));
		//b_height = height/2 + v_value*100;
		//ellipse(width/2,b_height,100,100);
		

		  // we draw the waveform by connecting neighbor values with a line
		  // we multiply each of the values by 50 
		  // because the values in the buffers are normalized
		  // this means that they have values between -1 and 1. 
		  // If we don't scale them up our waveform 
		  // will look more or less like a straight line.
		  for(int i = 0; i < in.bufferSize() - 1; i++)
		  {
			  if(in.left.get(i) * 50 > 50)
			  {
				  b_height =+(in.left.get(i)*50);
			  }
		  println(((in.left.get(i)*50) + (in.right.get(i)*50) / 2));
		  println(in.mix.get(i)*50);
		  }
		
	}
    public static void main(String[] args)
    {
        String[] a = {"MAIN"};
        PApplet.runSketch( a, new FlopShout());
    }
	
}
