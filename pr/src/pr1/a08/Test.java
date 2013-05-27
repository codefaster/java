//SIMON LISCHKA 797307
package pr1.a08;
import java.awt.Color;
import lernhilfe2012ws.graphics.*;

public class Test {

	public static void main(String[] args) {
		sinusTest();
		movingPointDemo();
	}

	public static void sinusTest() {
		// Gitter + Sinfunktion auf painterA zeichnen.
		DirtyPainter painterA = new DirtyPainter();
		Drawable gitterA = new Gitter(20, 20, Color.YELLOW);
		painterA.add(gitterA);
		painterA.add(new SinFunction(200, 500, 0, Defaults.Y_OFFSET));
		painterA.showDrawing();
		// Alternatives Gitter auf painterB
		DirtyPainter painterB = new DirtyPainter();
		painterB.add(new Gitter(50, 50));
		painterB.showDrawing();
		// boolean s = new Point(100,100).equals(new Point(101,100));
	}

	public static void movingPointDemo() {
		DirtyPainter movingPainter = new DirtyPainter();
		int i = 0;
		while (true) {
			i += Defaults.CIRCLE_STEP;
			if (i == 360) {
				i = 0;
			}
			double inRad = i * (Math.PI / 180);
			int x = Defaults.CIRCLE_X_OFFSET + (int) Math.round(Defaults.CIRCLE_SIZE * Math.cos(inRad));
			int y = Defaults.CIRCLE_Y_OFFSET + (int) Math.round(Defaults.CIRCLE_SIZE * Math.sin(inRad));
			Point movingPoint = new Point(x, y);
			movingPoint.setColor(Color.BLACK);
			movingPainter.add(movingPoint);
			movingPainter.showDrawingAfterWaiting(Defaults.DELAY_TIME);
			movingPainter.remove(movingPoint);
		}
	}
}
