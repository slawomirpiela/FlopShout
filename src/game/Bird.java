package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class Bird {
	PApplet parent;
	PImage heroImg;
	Minim minum;
	AudioInput in;
	
	float b_xpos,b_ypos = 0;
	//float velocity = 1;
	//float gravity = (float) 0.0005;
	
	Bird(PApplet p) {		
		parent = p;
		minum = new Minim(p);
		in = minum.getLineIn(Minim.MONO, parent.width, 44100, 16);
	}

	public void display(){
		heroImg = parent.loadImage("potfinal.png");
			b_xpos = parent.width/2;
			//parent.tint(255, 126);
			parent.image(heroImg, b_xpos, b_ypos);
			FlopShout.velocity += 1;
			b_ypos += FlopShout.velocity;
		}

}

