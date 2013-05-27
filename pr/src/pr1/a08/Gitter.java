package pr1.a08;

import java.awt.Graphics;
import java.awt.Color;
import lernhilfe2012ws.graphics.Drawable;
import pr1.a08.Defaults;

public class Gitter implements Drawable {
	protected int dx;
	protected int dy;
	protected int xMax;
	protected int yMax;
	protected Color color;

	// Vollst??ndiger Konstruktor, erm??glicht xMax und yMax zu ??bergeben
	public Gitter(int dx, int dy, int xMax, int yMax, Color color) {
		this.dx = dx;
		this.dy = dy;
		this.xMax = xMax;
		this.yMax = yMax;
		this.color = color;
	}

	public Gitter(int dx, int dy, Color color) {
		this(dx,dy,Defaults.X_MAX,Defaults.Y_MAX,color);
	}

	public Gitter(int dx, int dy) {
		this(dx,dy,Defaults.X_MAX,Defaults.Y_MAX,Defaults.GITTER_COLOR);
	}

	// Kopierkonstruktor
	public Gitter(Gitter other) {
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
		g.drawLine(0, Defaults.Y_OFFSET, xMax, Defaults.Y_OFFSET);
		// Y
		g.drawLine(0, 0, 0, yMax);
	}
}
