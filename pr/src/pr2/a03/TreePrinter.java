package pr2.a03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.tree.TreeNode;

import lernhilfe2013ss.tree.QadTree;
import lernhilfe2013ss.tree.QadTreeWalker;
import pr2.a02.tree.TreeFactory;

public class TreePrinter {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PrintWriter out = new PrintWriter(System.out, true);
		QadTree testTree = readTreeBinary("binary.txt");
		writeTreeBinary(testTree,"binary.txt");
		Iterator<TreeNode> inOrder = QadTreeWalker.inorderIterator(testTree);
		Iterator<TreeNode> postOrder = QadTreeWalker
				.postorderIterator(testTree);
		Iterator<TreeNode> preOrder = QadTreeWalker.preorderIterator(testTree);
		seperateMe();
		out.println("START --->");
//		seperateMe();
//		printTree(inOrder, out);
//		seperateMe();
//		printTree(postOrder, out);
//		seperateMe();
//		printTree(preOrder, out);
		printTree(testTree, out, 20);
	}

	public static void printTree(QadTree tree, PrintWriter out, int width) {
		Iterator<TreeNode> iterator = QadTreeWalker.preorderIterator(tree);
		printTree(iterator,out,width,true);
		printTree(iterator,out,width,false);
	}

	public static void seperateMe() {
		PrintWriter out = new PrintWriter(System.out, true);
		out.println();
		out.println("---");
	}

	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out) {
		while (iterator.hasNext()) {
			out.println(iterator.next());
		}
	}

	public static void printTree(Iterator<TreeNode> iterator, PrintWriter out,
			int width, boolean skipLeafs) {
		while (iterator.hasNext()) {
			TreeNode node = iterator.next();
			if (skipLeafs && node.isLeaf()) {
				continue;
			}
			out.printf("%-" + width + "s", node);
			if (node.getChildCount() == 0) {
				continue;
			}
			for (int i = 0; i < node.getChildCount(); i++) {
				out.printf("%-" + width + "s", node.getChildAt(i));
			}
			out.println(); 
		}
	}

	
	public static void writeTreeBinary(QadTree tree, String path)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(tree);
		oos.close();
	}

	public static QadTree readTreeBinary(String path) throws IOException,
			ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		QadTree tree = (QadTree) ois.readObject();
		ois.close();
		return tree;
	}

}
