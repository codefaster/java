//SIMON LISCHKA 797307
package pr1.a06;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class DrawBuildings implements lernhilfe2012ws.graphics.Drawable {
	public void draw(Graphics g) {
		final int MAX_X_VALUE = 800;
		final int Y_BASELINE = 500;
		final int Y_HIGHLINE = 50;
		final int MAX_TOWER_WIDTH = 80;
		final int MIN_TOWER_WIDTH = 20;
		final int MIN_TOWER_HEIGHT = 200;
		final int MAX_GAP = 40;
		final int MIN_GAP = 5;
		Random randomGenerator = new Random();
		g.setColor(Color.black);
		int xCursor=0;
		while (xCursor<MAX_X_VALUE) {
			int randomGap=randomGenerator.nextInt(MAX_GAP-MIN_GAP)+MIN_GAP;
			int yRandomHigh =  -MIN_TOWER_HEIGHT;
			int yHighLineCompd =Y_HIGHLINE+MIN_TOWER_HEIGHT;
			yRandomHigh += randomGenerator.nextInt(Y_BASELINE-yHighLineCompd)
					+ yHighLineCompd;
			// Checken, das Breite durch 8 teilbar ist. 
			int xRandomWidth=1;
			while((xRandomWidth % 8)!=0) {
				xRandomWidth = randomGenerator.nextInt(MAX_TOWER_WIDTH-MIN_TOWER_WIDTH)+MIN_TOWER_WIDTH;
			}
			// Draw Building.
			g.setColor(Color.GRAY);
			g.drawRect(xCursor, yRandomHigh, xRandomWidth,Y_BASELINE-yRandomHigh);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(xCursor, yRandomHigh, xRandomWidth,Y_BASELINE-yRandomHigh);
			// Draw Windows
			int windowPadding = xRandomWidth / 8;
			int windowWidth = ( xRandomWidth / 2 ) - 2 * windowPadding;
			for (int i=yRandomHigh; i<Y_BASELINE-windowWidth-windowPadding;i+=windowWidth+windowPadding){
				g.setColor(Color.white);
				g.drawRect(xCursor+windowPadding,i+windowPadding,windowWidth,windowWidth);
//				int lightsOn = randomGenerator.nextInt(2);
//				if (lightsOn==1) {
//					g.setColor(Color.yellow);
//				} else {
//					g.setColor(Color.black);
//				}
				boolean lightsOn = randomGenerator.nextInt(2) == 1;
				if (lightsOn) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(xCursor+windowPadding,i+windowPadding,windowWidth,windowWidth);
				g.setColor(Color.white);
				g.drawRect(xCursor+windowPadding*3+windowWidth,i+windowPadding,windowWidth,windowWidth);
			    lightsOn = randomGenerator.nextInt(2) == 1;
				if (lightsOn) {
					g.setColor(Color.yellow);
				} else {
					g.setColor(Color.black);
				}
				g.fillRect(xCursor+windowPadding*3+windowWidth,i+windowPadding,windowWidth,windowWidth);
				g.setColor(Color.black);
			}
			// Draw ground line
			xCursor+=xRandomWidth;
			g.setColor(Color.DARK_GRAY);
			g.drawLine(xCursor,Y_BASELINE,xCursor+randomGap,Y_BASELINE); 
			xCursor+=randomGap;
		}
	}
}
