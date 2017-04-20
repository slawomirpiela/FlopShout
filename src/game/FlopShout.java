package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;

public class FlopShout extends PApplet {

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
		 
		// draw the waveforms so we can see what we are monitoring
    	float amp = 100;
        for (int i = 0 ; i < in.bufferSize() ; i ++)
        {
        	line(i, height / 2, i, height / 2 + (in.left.get(i) * amp));
        }
        int display = 0;
		println(in.left.get(display));
	}
    public static void main(String[] args)
    {
        String[] a = {"MAIN"};
        PApplet.runSketch( a, new FlopShout());
    }
	
}
