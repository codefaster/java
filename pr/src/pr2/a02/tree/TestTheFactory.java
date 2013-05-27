package pr2.a02.tree;

public class TestTheFactory {
	public static void main(String[] args) {
		TreeFactory.buildTree().showInGUI();
		TreeFactory.createTree("tree.txt").showInGUI();
		TreeFactory.createTree("owntree.txt").showInGUI();
	}
}
