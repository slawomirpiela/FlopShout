package game;
import controlP5.*;
import processing.core.PApplet;

public class GUI {
		ControlP5 cp5;
		PApplet parent;
		Button b;
		
		
		GUI(PApplet p) {
			parent = p;
			cp5 = new ControlP5(p);
			b = cp5.addButton("Start").setValue(1).setPosition(parent.width/2, parent.height/2).setSize(200,20).activateBy(parent.mouseButton);
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