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
	float gravity = (float) 0.0005;
	
	Bird(PApplet p) {		
		parent = p;
		minum = new Minim(p);
		in = minum.getLineIn(Minim.MONO, parent.width, 44100, 16);
	}

	public void display(){
		heroImg = parent.loadImage("potfinal.png");
			b_xpos = parent.width/2;

			parent.image(heroImg, b_xpos, b_ypos);
			FlopShout.velocity += 0.5;
			b_ypos += FlopShout.velocity;
			
			for(int i = 0; i < in.bufferSize() - 1; i++){
				if(b_ypos > 0 && b_ypos < parent.height && parent.frameCount % 20 == 0 && in.left.get(i) > 0 && in.left.get(i) < 0.03){
					FlopShout.velocity =-(in.left.get(i)*parent.height/2);
					parent.println(in.left.get(i));
					parent.println(in.left.get(i)*parent.height/2);
				}
			}
			
		}

}