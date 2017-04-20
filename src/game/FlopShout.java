package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class FlopShout extends PApplet {

	float xpos = 200;
	float ypos = 50;
	int v_value = 0;
	int b_height;
	Minim minum;
	AudioInput in;
	
	public void setup()
	{
		minum = new Minim(this);
		in = minum.getLineIn(Minim.MONO, width, 44100, 16);
	}
	
	public void settings()
	{
		size(800,800);
	}
	
	public void draw()
	{
		background(0);
		stroke(255);
		 
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
		    line(i, 50 + in.left.get(i)*50, i+1, 50 + in.left.get(i+1)*50);
		    line(i, 150 + in.right.get(i)*50, i+1, 150 + in.right.get(i+1)*50);
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
