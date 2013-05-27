package pr1.a08;

import java.awt.Graphics;
import java.awt.Color;
import lernhilfe2012ws.graphics.Drawable;

public class GitterAlternative implements Drawable {
	protected int dx;
	protected int dy;
	protected int xMax;
	protected int yMax;
	protected Color color;
	protected static final int X_MAX = 1000;
	protected static final int Y_MAX = 500;
	protected static final int Y_OFFSET = Y_MAX / 2;
	protected static final Color GITTER_COLOR = Color.YELLOW;

	// Vollst??ndiger Konstruktor, erm??glicht xMax und yMax zu ??bergeben
	public GitterAlternative(int dx, int dy, int xMax, int yMax, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.xMax = xMax;
		this.yMax = yMax;
		this.color = color;
	}

	public GitterAlternative(int dx, int dy, Color color) {
		this(dx,dy,X_MAX,Y_MAX,color);
	}

	public GitterAlternative(int dx, int dy) {
		this(dx,dy,X_MAX,Y_MAX,GITTER_COLOR);
	}

	// Kopierkonstruktor
	public GitterAlternative(GitterAlternative other) {
		this(other.dx, other.dy);
	}

	public int getDx() {
		return dx;
	}

	public int getDy() {
		return dy;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void draw(Graphics g) {
		// Draw Background
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, xMax, yMax);
		g.setColor(color);
		// Draw Horizontals
		for (int xCursor = 0; xCursor < xMax; xCursor += dx) {
			g.drawLine(xCursor, 0, xCursor, yMax);
		}
		// Draw Verticals
		for (int yCursor = 0; yCursor < yMax; yCursor += dy) {
			g.drawLine(0, yCursor, xMax, yCursor);
		}
		// Draw Grundkoordinaten
		g.setColor(Color.BLUE);
		// X
		g.drawLine(0, Y_OFFSET, xMax, Y_OFFSET);
		// Y
		g.drawLine(0, 0, 0, yMax);
	}
}
