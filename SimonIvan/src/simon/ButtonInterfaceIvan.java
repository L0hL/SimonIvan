package simon;
import java.awt.Color;

//import GUIpractice.component.Action;
//import GUIpractice.component.Clickable;

import GUIpractice.component.Action;
import GUIpractice.component.Clickable;

public interface ButtonInterfaceIvan extends Clickable{


	void setX(int i);

	void setY(int i);

	void setColor(Color color);
	
	public void setAction(Action a);

	void highlight();

	void dim();

	


}
