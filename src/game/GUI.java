package game;
import controlP5.*;
import processing.core.PApplet;

public class GUI {
		ControlP5 cp5;
		PApplet parent;
		Button s;
		Button op;
		Button high;
		Button ex;
		
		GUI(PApplet p) {
			parent = p;
			cp5 = new ControlP5(p);
			s = cp5.addButton("Start Game").setValue(0).setPosition((float)(parent.width*0.25),(float)(parent.height*0.4625)).setSize(230,60).activateBy(parent.mouseButton);
			op = cp5.addButton("Options").setValue(0).setPosition((float)(parent.width*0.25),(float)(parent.height*0.5625)).setSize(230,60).activateBy(parent.mouseButton);
			high = cp5.addButton("HighScore").setValue(0).setPosition((float)(parent.width*0.25),(float)(parent.height*0.6625)).setSize(230,60).activateBy(parent.mouseButton);
			ex = cp5.addButton("Exit").setValue(0).setPosition((float)(parent.width*0.25),(float)(parent.height*0.7625)).setSize(230,60).activateBy(parent.mouseButton);
		}
		
		
public void drawGUIMenu(){
	
		Button button = cp5.get(Button.class, "Start");
	}

}
//public void Button(int value){
//	FlopShout.println("Button pressed");
//	if(value == 1){
//		cp5.getController("Start")
//		.setVisible(false);
//	}
//	}

//		
//}
//}