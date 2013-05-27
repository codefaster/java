package pr1.a08;

import java.awt.Graphics;
import lernhilfe2012ws.graphics.Drawable;
import pr1.a08.Defaults;

public class SinFunction implements Drawable {
	private int a;
	private int l;
	private int phi0;
	private int y0;

	//Vollst??ndiger Konstruktor
	public SinFunction(int a, int l, int phi0, int y0) {
		this.a = a;
		this.l = l;
		this.phi0 = phi0;
		this.y0 = y0;
	}

	//Konstruktor mit Defaultwert f??r a
	public SinFunction(int a, int l, int phi0) {
		this(a,l,phi0,a);
	}
	

	public void draw(Graphics g) {
		g.setColor(Defaults.CURVE_COLOR);
		final int DX = 5;
		for (int x = 0; x <= l; x += DX) {
			double phase = 2 * Math.PI * x / l;
			double y = a * Math.sin(Defaults.PHASE_REPEAT * phase + phi0) + y0;
			if (Defaults.OVAL_ISFILLED) {
				g.fillOval((int) x, (int) y, Defaults.OVAL_SIZE_X,
						Defaults.OVAL_SIZE_Y);
			} else {
				g.drawOval((int) x, (int) y, Defaults.OVAL_SIZE_X,
						Defaults.OVAL_SIZE_Y);
			}
		}
	}
}
