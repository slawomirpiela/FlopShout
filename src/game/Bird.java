package game;

import java.util.Vector;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;
import processing.core.PVector;

public class Bird {
	 private PVector position;
	 private PVector velocity;
	 PImage birdImage;
	 PApplet parent;
	 
	 float x = 200;
	 float y = 200;

		Bird(PApplet p) {
			parent = p;
		}
	 
	 public Bird(float x, float y) {
		 //position = new PVector(x, y);
		 //velocity = new PVector(0, 0);
		 this.x = x;
		 this.y = y;
		 
			
	 }
	 
	 public void setup(){
		 
	 }
	 
	 public void display() {
		 
		 
		 parent.image(birdImage, x, y);
		 //position.add(velocity.x, 0);
		 
		 //velocity.mult(0.99f);
		 
	 }
	 
}
