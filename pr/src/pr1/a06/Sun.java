//SIMON LISCHKA 797307
package pr1.a06;
import java.awt.Graphics;
import java.awt.Color;

public class Sun implements lernhilfe2012ws.graphics.Drawable {
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillOval(40, 40, 103, 103);
		g.setColor(Color.ORANGE);
		g.fillOval(40, 40, 100, 100);
	}
}
