package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class Bird {
	
	PApplet parent;
	PImage img;
	Minim minum;
	AudioInput in;
	
	float xpos = 200;
	float ypos = 200;
	float gravity = (float) 0.05;
	
	Bird(PApplet p) {
		parent = p;
		minum = new Minim(p);
		in = minum.getLineIn(Minim.MONO, parent.width, 44100, 16);
	}

public void display(){
	
	img = parent.loadImage("potfinal.png");
	img.resize(35,35);	
	//parent.background(255);
	//parent.stroke(255);
	for(int i = 0; i < in.bufferSize() - 1; i++)
	{
		parent.image(img, xpos, ypos);
		if (parent.frameCount % 20 == 0)
		{
			if(in.left.get(i)*parent.height/2 > 0 && ypos > 0)
			{
				//parent.background(255);
				ypos = ypos - in.left.get(i)/2 + gravity;
				if(ypos < 0)
				{
					ypos = ypos + 2;
				}
				parent.println(in.left.get(i));
			}
		}
		if(ypos > 800)
		{
			parent.background(255);
			parent.textAlign(parent.CENTER);
			//textFont(font);
			parent.fill(0);
			parent.text("Game Over", parent.width/2, parent.height/2);
		}
	}
}
}

