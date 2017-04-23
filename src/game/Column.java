package game;

import processing.core.*;

public class Column {
	
	PApplet parent;
	PImage col;
	
	float xpos = 200;
	float ypos = 200;
	
	Column(PApplet p) {
		parent = p;
	}

	public void display(){
		col = parent.loadImage("col.png");
		if(FlopShout.stage == 1){
			//parent.background(255);
			//parent.stroke(255);
			parent.image(col, xpos, ypos);
			for(int i = 0; i < 4; i++)
			{
				//parent.background(255);
				xpos = xpos + 40 * i;
				parent.image(col, xpos, ypos);
					if(xpos > parent.width)
						{
							//
						}
					}
			}
		}
}


