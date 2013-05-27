package pr2.a02.tree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import lernhilfe2013ss.tree.QadTree;

public class TreeFactory {

	public static QadTree createTree(String path) {
		return createTree(readlines(path));
	}

	public static QadTree createTree(String[] lines) {
		QadTree tree = new QadTree(lines[0]);
		for (String currentLine : lines) {
			String[] items = currentLine.split(" ");
			String parent = items[0];
			tree.addChilds(parent, Arrays.copyOfRange(items, 1, items.length));
		}
		return tree;
	}

	public static String[] readlines(String path) {
		PrintWriter err = new PrintWriter(System.err, true);
		Collection<String> lines = new ArrayList<String>();
		FileReader reader = null;
		try {
			reader = new FileReader(path);
			Scanner fileScan = new Scanner(reader);
			while (fileScan.hasNextLine()) {
				lines.add(fileScan.nextLine());
			}
		} catch (FileNotFoundException e1) {
			err.println("File not found.");
		} catch (IOException e2) {
			err.println("IO Error.");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
			}
		}

		String[] linesOut = new String[lines.size()];
		lines.toArray(linesOut);
		return linesOut;
	}

	public static QadTree buildTree() {
		QadTree myTree = new QadTree("Testus");
		String[] firstline = { "Adumus", "Baktus", "Caradin", "Fusan", "Garus",
				"Haitian", "Indiana", "Jones" };
		String[] adumus = { "My Hero", "Your Pleasure", "They" };
		String[] baktus = { "Behold", "The", "New" };
		String[] caradin = { "Dont", "Mess", "With" };
		String[] fusan = { "We", "Don't", "Need" };
		String[] garus = { "Lets", "Grillo" };
		String[] haitin = { "In", "Haiti" };
		String[] indiana = { "He's", "As" };
		String[] jones = { "Ramurgo", "Let" };
		myTree.addChilds("Testus", firstline);
		myTree.addChilds("Adumus", adumus);
		myTree.addChilds("Baktus", baktus);
		myTree.addChilds("Caradin", caradin);
		myTree.addChilds("Mess", fusan);
		myTree.addChilds("Garus", garus);
		myTree.addChilds("Haitian", haitin);
		myTree.addChilds("Indiana", indiana);
		myTree.addChilds("Behold", jones);
		return myTree;
	}
}
