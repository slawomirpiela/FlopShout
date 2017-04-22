package game;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.*;

public class FlopShout extends PApplet {

int v_value = 0;
Minim minum;
AudioInput in;

Bird bird;
PImage birdImage;

PImage col;
Menu menu;
float playerX = 200;
float playerY = 200;
float b_height = 0;
public static int stage = 0;
public static int difficulty = 0;
float x1,y1,x2,y2;
float gravity = (float) 0.05;
float border = 50;




public static void main(String[] args)
	{
		PApplet.main("game.FlopShout");  
    }
    
public void setup()
	{
		smooth();
		minum = new Minim(this);
		menu = new Menu(this);
		in = minum.getLineIn(Minim.MONO, width, 44100, 16);
		
		
		bird = new Bird(200,200);
		
		col = loadImage("col.png");
		
	}
	
	public void settings()
	{
		size(1000,800);
	}
	
	public void draw()
	{
		if(stage == 1){
			background(255);
			stroke(255);
			for(int i = 0; i < in.bufferSize() - 1; i++)
			{
				if (frameCount % 60 == 0){
					}
					if(in.left.get(i)*height/2 > 0 && playerY > 0){
						background(255);
						playerY = playerY - in.left.get(i)/2;
						playerY += gravity;
						bird.display();
						if(playerY < 0)
						{
							playerY = playerY + 2;
							//println(((in.left.get(i)*50w) + (in.right.get(i)*50) / 2));
						}
						if(playerY > 800){
							
							background(255);
							textAlign(CENTER);
							//textFont(font);
							fill(0);
							text("Game Over", width/2, height/2);
						}
						
					//println(in.mix.get(i));
					//println(in.left.get(i));
					}
					println(in.left.get(i));
					
			}
		}
		menu.draw();
		//println(stage);
	}
	
}
