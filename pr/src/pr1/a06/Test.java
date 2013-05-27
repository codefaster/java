//SIMON LISCHKA 797307
package pr1.a06;
import lernhilfe2012ws.graphics.*;
public class Test {
	public static void main(String[] args) {
		DirtyPainter painter = new DirtyPainter();
		painter.add(new DrawHorizon());
		painter.add(new Sun());
		painter.add(new DrawBuildings());
		painter.showDrawing();
	}
}
