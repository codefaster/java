//SIMON LISCHKA 797307
package pr1.a06;
import java.awt.Color;
import java.awt.Graphics;

public class DrawHorizon implements lernhilfe2012ws.graphics.Drawable {
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 1000, 480);
		g.setColor(Color.BLACK);
		g.fillRect(0, 480, 1000, 100);
		g.setColor(Color.GRAY);
		g.fillRect(0, 502, 1000, 500);
	}
}
