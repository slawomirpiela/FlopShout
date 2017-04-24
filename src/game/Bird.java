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
	float gravity = (float) 0.0005;
	
	Bird(PApplet p) {
		parent = p;
		minum = new Minim(p);
		in = minum.getLineIn(Minim.MONO, parent.width, 44100, 16);
	}

	public void display(){
		img = parent.loadImage("potfinal.png");
		img.resize(35,35);	
		for(int i = 0; i < in.bufferSize() - 1; i++){
			parent.image(img, xpos, ypos);
			ypos += gravity;
			if (parent.frameCount % 20 == 0){
				if(in.left.get(i)*parent.height/2 > 0 && ypos > 0){
					//parent.background(255);
					//ypos = ypos - in.left.get(i)/2;
					if(ypos < 0){
						ypos = ypos + 2;
					}
					//parent.println(in.left.get(i));
				}
			}
			if(ypos > 800){
				FlopShout.stage = 4;
			}	
		}
	}
	
	public void collision(){
		
	}

}

