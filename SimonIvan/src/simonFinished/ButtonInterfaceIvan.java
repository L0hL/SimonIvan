package simonFinished;
import java.awt.Color;

import GUIpractice.components.Action;
import GUIpractice.components.Clickable;
public interface ButtonInterfaceIvan extends Clickable{

	void setX(int i);

	void setY(int i);

	void setColor(Color color);
	
	public void setAction(Action a);

	void highlight();

	void dim();

	


}
