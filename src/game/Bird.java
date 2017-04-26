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
			parent.image(heroImg, b_xpos, b_ypos);
			FlopShout.velocity += 1;
			b_ypos += FlopShout.velocity;
			//velocity += 0.5;
			//ypos += velocity;
		}
	//public void move(){
	//	for(int i = 0; i < in.bufferSize() - 1; i++){
	//		if(in.left.get(i)*parent.height/2 > 70){
	//			velocity =- 5;
	//			//velocity = -in.left.get(i)/2;
	//			parent.println(in.left.get(i)*parent.height/2);
	//		}
	//		if(ypos < 0){
	//			ypos = ypos + 2;
	//			
	//		}
	//	}
	//}
	
	public void collision(){
		
	}

}

