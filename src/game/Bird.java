package game;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class Bird {
	PApplet parent;
	PImage heroImg;
	Minim minum;
	AudioInput in;
	
	float xpos = 150;
	float ypos = 0;
	float velocity = 1;
	float gravity = (float) 0.0005;
	
	Bird(PApplet p, PImage img, float xpos, float ypos, float vel) {
		
		parent = p;
		minum = new Minim(p);
		in = minum.getLineIn(Minim.MONO, parent.width, 44100, 16);
		
		this.heroImg = img;
		this.xpos = xpos;
		this.ypos = ypos;
		this.velocity = vel;
	}

	public void display(){
		heroImg = parent.loadImage("potfinal.png");
		//
			parent.image(heroImg, xpos, ypos);
			velocity += 0.5;
			ypos += velocity;
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

